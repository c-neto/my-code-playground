package br.org.celiolemos.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

import br.org.celiolemos.api.service.AlunoService;
import br.org.celiolemos.api.service.ResponsavelService;
import br.org.celiolemos.api.service.TurmaService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.FalhaNoCadastro;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Aluno;
import br.org.celiolemos.model.Doenca;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.repository.AlunoRepository;
import br.org.celiolemos.repository.DoencaRepository;
import br.org.celiolemos.repository.ResponsavelRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private ResponsavelService responsavelService;

	@Autowired
	private DoencaRepository doencaRepository;

	@Autowired
	private ResponsavelRepository responsavelRepository;

	private Log logger = LogFactory.getLog(AlunoService.class);

	@Override
	@Transactional
	public Aluno adicionarAluno(Aluno aluno, Integer turmaId) {

		if (repository.existsByNomeAndDataNascimento(aluno.getNome(), aluno.getDataNascimento()))
			throw new ElementoJaCadastrado("Aluno já está cadastrado");
		Turma turma = turmaService.encontrarPorId(turmaId);
		aluno.setTurma(turma);

		// evita duplicidade no cadastro de responsavel
		String cpf = aluno.getResponsavel().getCpf();
		Optional<Responsavel> optionalResponsavel = responsavelRepository.findByCpf(cpf);
		if (optionalResponsavel.isPresent()) {
			aluno.setResponsavel(optionalResponsavel.get());
		} else {
			Responsavel responsavel = responsavelService.adicionarResponsavel(aluno.getResponsavel());
			aluno.setResponsavel(responsavel);
		}
		Aluno alunoCriado;
		try {
			alunoCriado = repository.save(aluno);
			Set<Doenca> d = aluno.getDoencas();
			d.forEach(doenca -> doenca.setAluno(alunoCriado));
			Set<Doenca> doencas = Sets.newHashSet(doencaRepository.saveAll(d));
			alunoCriado.setDoencas(doencas);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FalhaNoCadastro(e.getCause().getLocalizedMessage());
		}
		return alunoCriado;
	}

	@Override
	public Aluno encontrarPorId(Integer id) {
		Optional<Aluno> alunoEncontrado = repository.findById(id);

		if (alunoEncontrado.isPresent()) {
			return alunoEncontrado.get();
		}
		throw new NaoEncontrado("Usuário não encontrado pelo ID");
	}

	@Override
	public Iterable<Aluno> encontrarTudo() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Aluno atualizarAluno(Integer id, Aluno aluno) {

		Optional<Aluno> alunoParaAtualizar = repository.findById(id);

		if (alunoParaAtualizar.isPresent()) {
			aluno.setId(alunoParaAtualizar.get().getId());
			Set<Doenca> doencas = aluno.getDoencas();
			doencas.forEach(doenca -> doenca.setAluno(aluno));
			aluno.setDoencas(Sets.newHashSet(doencaRepository.saveAll(doencas)));
			
			Responsavel responsavel = aluno.getResponsavel();
			Responsavel responsavelSalvo = responsavelService.atualizarResponsavel(responsavel.getId(), responsavel);
			aluno.setResponsavel(responsavelSalvo);
			Aluno alunoAtualizado = repository.save(aluno);
			if (Objects.nonNull(alunoAtualizado)) {
				return alunoAtualizado;
			}
			throw new FalhaNaAtualizacao("Aluno não foi atualizado! Tente novamente mais tarde");
		}
		throw new NaoEncontrado("Aluno não encontrado. Para atualizar é necessário um aluno válido!");
	}

	@Override
	public void removeAluno(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);

			if (repository.existsById(id)) {
				throw new FalhaNaRemocao("Aluno não foi removido, tente novamente mais tarde");
			}
			return;
		} else {
			throw new NaoEncontrado("Aluno não encontrado. Para remover o aluno deve existir!");
		}
	}
}

package br.org.celiolemos.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.api.service.ResponsavelService;
import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.FalhaNoCadastro;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.repository.EnderecoRepository;
import br.org.celiolemos.repository.ResponsavelRepository;
import br.org.celiolemos.repository.TelefoneRepository;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Autowired
	@Qualifier("responsavelService")
	private TelefoneService telefoneService;
	@Autowired
	@Qualifier("responsavelService")
	private EnderecoService enderecoService;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	private Log logger = LogFactory.getLog(ResponsavelService.class);

	@Override
	@Transactional
	public Responsavel adicionarResponsavel(Responsavel responsavel) {

		Objects.requireNonNull(responsavel.getTelefones());
		Objects.requireNonNull(responsavel.getEnderecos(), "O campo endereco é obrigatorio");
		if (responsavelRepository.existsByCpf(responsavel.getCpf())) {
			throw new ElementoJaCadastrado("Responsavel já cadastrado!");
		}

		Set<Telefone> telefones = responsavel.getTelefones();
		Set<Endereco> enderecos = responsavel.getEnderecos();

		telefones.parallelStream().forEach(telefone -> {
			if (telefoneRepository.existsByNumero(telefone.getNumero())) {
				throw new ElementoJaCadastrado("Telefone já cadastrado, não foi possível adicionar o responsável");
			}
		});

		enderecos.parallelStream().forEach(endereco -> {
			if (enderecoRepository.existsByCepAndNumero(endereco.getCep(), endereco.getNumero())) {
				throw new ElementoJaCadastrado("Endereco já cadastrado, não foi possível adicionar o responsável");
			}
		});

		try {
			Responsavel responsavelSalvo = responsavelRepository.save(responsavel);
			telefoneService.adicionarTelefone(responsavelSalvo.getId(), telefones);
			enderecoService.adicionarEndereco(responsavelSalvo.getId(), enderecos);
			return responsavelSalvo;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FalhaNoCadastro(e.getCause().getLocalizedMessage());
		}
	}

	@Override
	public Responsavel encontrarPorId(Integer responsavelId) {

		Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(responsavelId);
		if (optionalResponsavel.isPresent()) {
			return optionalResponsavel.get();
		}
		throw new NaoEncontrado("Responsavel não foi encontrado");
	}

	@Override
	public Iterable<Responsavel> encontrarTudo() {
		return responsavelRepository.findAll();
	}

	@Override
	@Transactional
	public Responsavel atualizarResponsavel(Integer responsavelId, Responsavel responsavel) {

		Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(responsavelId);
		if (optionalResponsavel.isPresent()) {
			Responsavel responsavelAntigo = optionalResponsavel.get();
			responsavel.setId(responsavelAntigo.getId());
			responsavel.getEnderecos().forEach(end -> end.setResponsavel(responsavel));
			responsavel.getTelefones().forEach(tel -> tel.setResponsavel(responsavel));
			responsavel.setEnderecos(Sets.newHashSet(enderecoRepository.saveAll(responsavel.getEnderecos())));
			responsavel.setTelefones(Sets.newHashSet(telefoneRepository.saveAll(responsavel.getTelefones())));
			Responsavel updateStatus = responsavelRepository.save(responsavel);

			if (Objects.nonNull(updateStatus)) {
				return updateStatus;
			}
			throw new FalhaNaAtualizacao("Responsavel não foi atualizado, tente novamente mais tarde");
		}
		throw new NaoEncontrado("Responsavel não foi encontrado. A atualização não foi realizada");

	}

	@Override
	public void removeResponsavel(Integer idResponsavel) {

		if (responsavelRepository.existsById(idResponsavel)) {

			responsavelRepository.deleteById(idResponsavel);

			if (responsavelRepository.existsById(idResponsavel)) {
				throw new FalhaNaRemocao("Responsavel não foi removido, tente novamente mais tarde");
			}
			return;
		}
		throw new NaoEncontrado("Responsavel não encontrado. Para excluir um responsavel ele precisa existir");
	}
}
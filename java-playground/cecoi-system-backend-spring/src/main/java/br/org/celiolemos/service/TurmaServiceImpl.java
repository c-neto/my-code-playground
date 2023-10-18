package br.org.celiolemos.service;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.TurmaService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.repository.TurmaRepository;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	@Override
	public Turma adicionarTurma(Turma turma) {

		if (turmaRepository.existsByPeriodoAndNome(turma.getPeriodo(), turma.getNome())){
			throw new ElementoJaCadastrado("Turma já cadastrada!");
		}
		return turmaRepository.save(turma);
	}

	@Override
	public Turma encontrarPorId(Integer turmaId) {

		Optional<Turma> optionalTurma = turmaRepository.findById(turmaId);
		if (optionalTurma.isPresent()) {
			return optionalTurma.get();
		}
		throw new NaoEncontrado("Turma não foi encontrada");
	}

	@Override
	public Iterable<Turma> encontrarTudo() {
		return turmaRepository.findAll();
	}

	@Override
	@Transactional
	public Turma atualizarTurma(Integer turmaId, Turma turma) {

		Optional<Turma> optionalTurma = turmaRepository.findById(turmaId);
		if (optionalTurma.isPresent()) {
			Turma turmaAntigo = optionalTurma.get();
			turma.setId(turmaAntigo.getId());
			Turma updateStatus = turmaRepository.save(turma);

			if (Objects.nonNull(updateStatus)) {
				return updateStatus;
			}
			throw new FalhaNaAtualizacao("Turma não foi atualizada, tente novamente mais tarde");
		}
		throw new NaoEncontrado("Turma não foi encontrada. A atualização não foi realizada");

	}

	@Override
	public void removeTurma(Integer idTurma) {

		if (turmaRepository.existsById(idTurma)) {

			turmaRepository.deleteById(idTurma);

			if (turmaRepository.existsById(idTurma)) {
				throw new FalhaNaRemocao("Turma não foi removida, tente novamente mais tarde");
			}
			return;
		}
		throw new NaoEncontrado("Turma não encontrada. Para excluir um turma ela precisa existir");
	}
}
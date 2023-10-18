package br.org.celiolemos.api.service;

import org.springframework.security.access.prepost.PreAuthorize;

import br.org.celiolemos.model.Turma;

public interface TurmaService {

	@PreAuthorize("hasRole('VIEWER')")
	Turma adicionarTurma(Turma turma);
	
	Turma encontrarPorId(Integer turmaId);

	Iterable<Turma> encontrarTudo();

	@PreAuthorize("hasRole('VIEWER')")
	Turma atualizarTurma(Integer turmaId, Turma turma);

	@PreAuthorize("hasRole('VIEWER')")
	void removeTurma(Integer idTurma);

}

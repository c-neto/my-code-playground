package br.org.celiolemos.api.service;

import org.springframework.security.access.prepost.PreAuthorize;

import br.org.celiolemos.model.Aluno;

public interface AlunoService {

	@PreAuthorize("hasRole('ADMIN')")
	Aluno adicionarAluno(Aluno aluno, Integer turma) throws RuntimeException;

	@PreAuthorize("hasAnyRole('VIEWER', 'EDITOR', 'ADMIN')")
	Aluno encontrarPorId(Integer id) throws RuntimeException;

	@PreAuthorize("hasAnyRole('VIEWER', 'EDITOR', 'ADMIN')")
	Iterable<Aluno> encontrarTudo() throws RuntimeException;

	@PreAuthorize("hasAnyRole('ADMIN','EDITOR')")
	Aluno atualizarAluno(Integer id, Aluno aluno) throws RuntimeException;

	@PreAuthorize("hasRole('ADMIN')")
	void removeAluno(Integer id) throws RuntimeException;
}

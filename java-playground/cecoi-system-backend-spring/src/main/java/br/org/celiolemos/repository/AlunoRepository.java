package br.org.celiolemos.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	
	Boolean existsByNomeAndDataNascimento(String nome, Date dataNascimento);
}

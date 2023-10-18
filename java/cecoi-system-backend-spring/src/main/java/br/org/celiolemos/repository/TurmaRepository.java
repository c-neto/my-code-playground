package br.org.celiolemos.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {
	Boolean existsByPeriodoAndNome(Turma.Periodo periodo, String nome);
	
}

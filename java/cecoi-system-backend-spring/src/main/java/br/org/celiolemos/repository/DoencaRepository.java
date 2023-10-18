package br.org.celiolemos.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Doenca;

public interface DoencaRepository extends CrudRepository<Doenca, Integer> {
}

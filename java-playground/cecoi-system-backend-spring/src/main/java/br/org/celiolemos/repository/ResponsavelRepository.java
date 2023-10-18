package br.org.celiolemos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Responsavel;

public interface ResponsavelRepository extends CrudRepository<Responsavel, Integer> {
	Boolean existsByCpf(String cpf);

	Boolean existsByRg(String rg);

	Optional<Responsavel> findByCpf(String cpf);
}

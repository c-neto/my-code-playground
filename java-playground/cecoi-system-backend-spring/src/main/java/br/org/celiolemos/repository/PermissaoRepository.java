package br.org.celiolemos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Permissao;

public interface PermissaoRepository extends CrudRepository<Permissao, Integer> {

	Optional<Permissao> findByNome(String nome);

	boolean existsByNome(String nome);
}

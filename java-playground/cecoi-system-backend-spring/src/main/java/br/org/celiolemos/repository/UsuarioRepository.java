package br.org.celiolemos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.celiolemos.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	boolean existsByCpf(String cpf);
	
	Optional<Usuario> findByLogin(String login);

	boolean existsByLogin(String login);
	
}

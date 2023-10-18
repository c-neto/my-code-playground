package br.org.celiolemos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.celiolemos.model.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Integer> {

	Boolean existsByNumero(String numero);

	List<Telefone> findAllByUsuarioId(Integer usuarioId);

	List<Telefone> findAllByResponsavelId(Integer responsavelId);
}

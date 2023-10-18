package br.org.celiolemos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.celiolemos.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
	boolean existsByCepAndNumero(String cep, Integer numero);

	List<Endereco> findAllByUsuarioId(Integer usuarioId);

	List<Endereco> findAllByResponsavelId(Integer responsavelId);
}

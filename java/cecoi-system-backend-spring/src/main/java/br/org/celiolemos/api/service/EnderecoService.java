package br.org.celiolemos.api.service;

import java.util.Set;

import br.org.celiolemos.model.Endereco;

public interface EnderecoService {

	Iterable<Endereco> adicionarEndereco(Integer id, Set<Endereco> enderecos);

	Endereco encontrarPorId(Integer id, Integer enderecoId);

	Iterable<Endereco> encontrarTudo(Integer id);

	Endereco atualizarEndereco(Integer usuarioId, Integer enderecoId, Endereco endereco);

	void removeEndereco(Integer id, Integer enderecoId);

}

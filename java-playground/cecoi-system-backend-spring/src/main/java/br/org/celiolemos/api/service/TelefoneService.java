package br.org.celiolemos.api.service;

import java.util.List;
import java.util.Set;

import br.org.celiolemos.model.Telefone;

public interface TelefoneService {

	Iterable<Telefone> adicionarTelefone(Integer id, Set<Telefone> telefone);

	Telefone encontrarPorId(Integer id, Integer telefoneId);

	List<Telefone> encontrarTudo(Integer id);

	Telefone atualizarTelefone(Integer id, Integer telefoneId, Telefone telefone);

	void removeTelefone(Integer id, Integer idTelefone);

}

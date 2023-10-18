package br.org.celiolemos.api.service;

import br.org.celiolemos.model.Responsavel;

public interface ResponsavelService {

	Responsavel adicionarResponsavel(Responsavel responsavel);

	Responsavel encontrarPorId(Integer responsavelId);

	Iterable<Responsavel> encontrarTudo();

	Responsavel atualizarResponsavel(Integer responsavelId, Responsavel responsavel);

	void removeResponsavel(Integer idResponsavel);

}

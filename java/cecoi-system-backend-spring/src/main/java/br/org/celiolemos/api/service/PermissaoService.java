package br.org.celiolemos.api.service;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;

import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Usuario;

public interface PermissaoService {

	@PreAuthorize("hasRole('ADMIN')")
	Usuario adicionarPermissaoEmUsuario(Integer id, Set<Permissao> permissoes);

	@PreAuthorize("hasRole('ADMIN')")
	Usuario removerPermissaoDeUsuario(Integer id, Set<Permissao> permissoes);
	
	@PreAuthorize("hasRole('ADMIN')")
	Permissao adicionarPermissao(Permissao permissao);

	@PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
	Permissao encontrarPorId(Integer permissaoId);

	@PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
	Iterable<Permissao> encontrarTudo();

	@PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
	Permissao atualizarPermissao(Integer permissaoId, Permissao permissao);

	@PreAuthorize("hasRole('ADMIN')")
	void removerPermissao(Integer id);

}

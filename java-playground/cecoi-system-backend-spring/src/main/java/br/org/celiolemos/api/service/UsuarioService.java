package br.org.celiolemos.api.service;

import org.springframework.security.access.prepost.PreAuthorize;

import br.org.celiolemos.model.Usuario;

public interface UsuarioService {

	@PreAuthorize("hasRole('ADMIN')")
	Usuario adicionarUsuario(Usuario usuario, String permissao);

	@PreAuthorize("hasAnyRole('EDITOR', 'ADMIN')")
	Usuario encontrarPorId(Integer id);

	@PreAuthorize("hasAnyRole('EDITOR', 'ADMIN')")
	Iterable<Usuario> encontrarTudo();

	@PreAuthorize("hasAnyRole('EDITOR', 'ADMIN')")
	Usuario atualizarUsuario(Integer id, Usuario usuario);

	@PreAuthorize("hasRole('ADMIN')")
	void removeUsuario(Integer id);

}

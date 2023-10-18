package br.org.celiolemos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.celiolemos.excecoes.AcessoNegado;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.repository.UsuarioRepository;

@Service
public class AutenticacaoServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByLogin(login);
		if (usuario.isPresent())
			return usuario.get();
		throw new AcessoNegado("Usuário não encontrado. Acesso negado");
	}
}

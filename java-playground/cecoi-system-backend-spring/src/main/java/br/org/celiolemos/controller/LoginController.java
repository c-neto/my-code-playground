package br.org.celiolemos.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;

import br.org.celiolemos.config.jwt.JwtUtils;
import br.org.celiolemos.model.Credencial;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.view.View;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager auth;

	@PostMapping(path = "/login")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<Usuario> login(@RequestBody Credencial credencial, HttpServletResponse response)
			throws JsonProcessingException {
		Authentication credentials = new UsernamePasswordAuthenticationToken(credencial.getLogin(),
				credencial.getSenha());
		Usuario usuario = (Usuario) auth.authenticate(credentials).getPrincipal();
		response.setHeader("Token", JwtUtils.gerarToken(usuario));
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
}

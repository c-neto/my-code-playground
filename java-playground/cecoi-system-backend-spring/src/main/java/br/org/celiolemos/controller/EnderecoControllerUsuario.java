package br.org.celiolemos.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.view.View;

@Validated
@RestController
@RequestMapping(path = "usuarios/{usuarioId}/enderecos")
public class EnderecoControllerUsuario {

	@Autowired
	@Qualifier("usuarioService")
	private EnderecoService service;

	/**
	 * Recupera endereco
	 * 
	 * @return
	 */
	@GetMapping(path = "{enderecoId}")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> encontraEndereco(@PathVariable Integer usuarioId,
			@PathVariable @NonNull Integer enderecoId) {
		Endereco resposta = service.encontrarPorId(usuarioId, enderecoId);
		return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
	}

	/**
	 * Lista todos os enderecos
	 * 
	 * @return
	 */
	@GetMapping
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<Iterable<Endereco>> listaEnderecos(@PathVariable Integer usuarioId) {
		Iterable<Endereco> resposta = service.encontrarTudo(usuarioId);
		return new ResponseEntity<Iterable<Endereco>>(resposta, HttpStatus.OK);
	}

	/**
	 * Atualiza endereco
	 * 
	 * @return
	 */
	@PutMapping(path = "{enderecoId}")
	public ResponseEntity<?> atualizaEndereco(@PathVariable Integer usuarioId, @PathVariable Integer enderecoId,
			@Valid @RequestBody Endereco endereco) {
		Endereco resposta = service.atualizarEndereco(usuarioId, enderecoId, endereco);
		return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria endereco
	 * 
	 * @param endereco
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> adicionaEndereco(@PathVariable Integer usuarioId,
			@Valid @RequestBody Set<Endereco> enderecos) {
		Iterable<Endereco> resposta = service.adicionarEndereco(usuarioId, enderecos);
		return new ResponseEntity<Iterable<Endereco>>(resposta, HttpStatus.OK);
	}

	/**
	 * Remove endereco
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{enderecoId}")
	public ResponseEntity<?> removeEndereco(@PathVariable Integer usuarioId, @PathVariable Integer enderecoId) {
		service.removeEndereco(usuarioId, enderecoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

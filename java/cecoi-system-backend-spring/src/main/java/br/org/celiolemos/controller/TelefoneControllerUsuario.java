package br.org.celiolemos.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.view.View;

@RestController
@RequestMapping(path = "usuarios/{usuarioId}/telefones")
public class TelefoneControllerUsuario {

	@Autowired
	@Qualifier("usuarioService")
	private TelefoneService service;

	/**
	 * Recupera telefone
	 * 
	 * @return
	 */
	@GetMapping(path = "{telefoneId}")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> encontrarTelefone(@PathVariable Integer usuarioId,
			@PathVariable @NonNull Integer telefoneId) {
		Telefone resposta = service.encontrarPorId(usuarioId, telefoneId);
		return new ResponseEntity<Telefone>(resposta, HttpStatus.OK);
	}

	/**
	 * Lista todos os telefones
	 * 
	 * @return
	 */
	@GetMapping
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> listarTelefones(@PathVariable Integer usuarioId) {
		Iterable<Telefone> resposta = service.encontrarTudo(usuarioId);
		return new ResponseEntity<Iterable<Telefone>>(resposta, HttpStatus.OK);
	}

	/**
	 * Atualiza telefone
	 * 
	 * @return
	 */
	@PutMapping(path = "{telefoneId}")
	public ResponseEntity<?> atualizaTelefone(@PathVariable Integer usuarioId, @PathVariable Integer telefoneId,
			@Valid @RequestBody Telefone telefone) {
		Telefone resposta = service.atualizarTelefone(usuarioId, telefoneId, telefone);
		return new ResponseEntity<Telefone>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria telefone
	 * 
	 * @param telefone
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> adicionaTelefone(@PathVariable Integer usuarioId, @Valid @RequestBody Set<Telefone> telefone) {
		Iterable<Telefone> resposta = service.adicionarTelefone(usuarioId, telefone);
		return new ResponseEntity<Iterable<Telefone>>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Remove telefone
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{telefoneId}")
	public ResponseEntity<?> removeTelefone(@PathVariable Integer usuarioId, @PathVariable Integer telefoneId) {
		service.removeTelefone(usuarioId, telefoneId);
		return new ResponseEntity<Telefone>(HttpStatus.NO_CONTENT);
	}

}

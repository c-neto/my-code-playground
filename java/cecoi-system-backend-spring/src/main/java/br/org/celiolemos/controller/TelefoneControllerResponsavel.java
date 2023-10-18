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

import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.model.Telefone;

@RestController
@RequestMapping(path = "responsaveis/{responsavelId}/telefones")
public class TelefoneControllerResponsavel {

	@Autowired
	@Qualifier("responsavelService")
	private TelefoneService service;

	/**
	 * Recupera telefone
	 * 
	 * @return
	 */
	@GetMapping(path = "{telefoneId}")
	public ResponseEntity<?> encontrarTelefone(@PathVariable Integer responsavelId,
			@PathVariable @NonNull Integer telefoneId) {
		Telefone resposta = service.encontrarPorId(responsavelId, telefoneId);
		return new ResponseEntity<Telefone>(resposta, HttpStatus.OK);
	}

	/**
	 * Lista todos os telefones
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> listarTelefones(@PathVariable Integer responsavelId) {
		Iterable<Telefone> resposta = service.encontrarTudo(responsavelId);
		return new ResponseEntity<Iterable<Telefone>>(resposta, HttpStatus.OK);
	}

	/**
	 * Atualiza telefone
	 * 
	 * @return
	 */
	@PutMapping(path = "{telefoneId}")
	public ResponseEntity<?> atualizaTelefone(@PathVariable Integer responsavelId, @PathVariable Integer telefoneId,
			@Valid @RequestBody Telefone telefone) {
		Telefone resposta = service.atualizarTelefone(responsavelId, telefoneId, telefone);
		return new ResponseEntity<Telefone>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria telefone
	 * 
	 * @param telefone
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> adicionaTelefone(@PathVariable Integer responsavelId, @Valid @RequestBody Set<Telefone> telefone) {
		Iterable<Telefone> resposta = service.adicionarTelefone(responsavelId, telefone);
		return new ResponseEntity<Iterable<Telefone>>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Remove telefone
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{telefoneId}")
	public ResponseEntity<?> removeTelefone(@PathVariable Integer responsavelId, @PathVariable Integer telefoneId) {
		service.removeTelefone(responsavelId, telefoneId);
		return new ResponseEntity<Telefone>(HttpStatus.NO_CONTENT);
	}

}

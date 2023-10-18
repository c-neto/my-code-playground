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

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.model.Endereco;

@RestController
@RequestMapping(path = "responsaveis/{responsavelId}/enderecos")
public class EnderecoControllerResponsavel {

	@Autowired
	@Qualifier("responsavelService")
	private EnderecoService service;

	/**
	 * Recupera endereco
	 * 
	 * @return
	 */
	@GetMapping(path = "{enderecoId}")
	public ResponseEntity<?> encontraEndereco(@PathVariable Integer responsavelId,
			@PathVariable @NonNull Integer enderecoId) {
		Endereco resposta = service.encontrarPorId(responsavelId, enderecoId);
		return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
	}

	/**
	 * Lista todos os enderecos
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Iterable<Endereco>> listaEnderecos(@PathVariable Integer responsavelId) {
		Iterable<Endereco> resposta = service.encontrarTudo(responsavelId);
		return new ResponseEntity<Iterable<Endereco>>(resposta, HttpStatus.OK);
	}

	/**
	 * Atualiza endereco
	 * 
	 * @return
	 */
	@PutMapping(path = "{enderecoId}")
	public ResponseEntity<?> atualizaEndereco(@PathVariable Integer responsavelId, @PathVariable Integer enderecoId,
			@Valid @RequestBody Endereco endereco) {
		Endereco resposta = service.atualizarEndereco(responsavelId, enderecoId, endereco);
		return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria endereco
	 * 
	 * @param endereco
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> adicionaEndereco(@PathVariable Integer responsavelId,
			@Valid @RequestBody Set<Endereco> enderecos) {
		Iterable<Endereco> resposta = service.adicionarEndereco(responsavelId, enderecos);
		return new ResponseEntity<Iterable<Endereco>>(resposta, HttpStatus.OK);
	}

	/**
	 * Remove endereco
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{enderecoId}")
	public ResponseEntity<?> removeEndereco(@PathVariable Integer responsavelId, @PathVariable Integer enderecoId) {
		service.removeEndereco(responsavelId, enderecoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

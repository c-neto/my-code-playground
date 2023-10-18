package br.org.celiolemos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.org.celiolemos.api.service.ResponsavelService;
import br.org.celiolemos.model.Responsavel;

@RestController
@RequestMapping(path = "responsaveis", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;

	@GetMapping(path = "{responsavelId}")
	public ResponseEntity<Responsavel> encontrarResponsavel(@PathVariable @NonNull Integer responsavelId) {
		Responsavel resposta = service.encontrarPorId(responsavelId);
		return new ResponseEntity<Responsavel>(resposta, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> listarResponsaveis() {
		Iterable<Responsavel> resposta = service.encontrarTudo();
		return new ResponseEntity<Iterable<Responsavel>>(resposta, HttpStatus.OK);
	}

	@PutMapping(path = "{responsavelId}")
	public ResponseEntity<Responsavel> atualizaResponsavel(@PathVariable Integer responsavelId,
			@Valid @RequestBody Responsavel responsavel) {
		Responsavel resposta = service.atualizarResponsavel(responsavelId, responsavel);
		return new ResponseEntity<Responsavel>(resposta, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Responsavel> adicionaResponsavel(@Valid @RequestBody Responsavel responsavel) {
		Responsavel resposta = service.adicionarResponsavel(responsavel);
		return new ResponseEntity<Responsavel>(resposta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "{responsavelId}")
	public ResponseEntity<?> removeResponsavel(@PathVariable Integer responsavelId) {
		service.removeResponsavel(responsavelId);
		return new ResponseEntity<Responsavel>(HttpStatus.NO_CONTENT);
	}
}

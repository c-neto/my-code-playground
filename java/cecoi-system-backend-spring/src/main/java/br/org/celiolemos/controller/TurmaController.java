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

import br.org.celiolemos.api.service.TurmaService;
import br.org.celiolemos.model.Turma;

@RestController
@RequestMapping(path = "turmas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TurmaController {

	@Autowired
	private TurmaService service;

	@GetMapping(path = "{turmaId}")
	public ResponseEntity<Turma> encontrarTurma(@PathVariable @NonNull Integer turmaId) {
		Turma resposta = service.encontrarPorId(turmaId);
		return new ResponseEntity<Turma>(resposta, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> listarTurmas() {
		Iterable<Turma> resposta = service.encontrarTudo();
		return new ResponseEntity<Iterable<Turma>>(resposta, HttpStatus.OK);
	}

	@PutMapping(path = "{turmaId}")
	public ResponseEntity<Turma> atualizaTurma(@PathVariable Integer turmaId,
			@Valid @RequestBody Turma turma) {
		Turma resposta = service.atualizarTurma(turmaId, turma);
		return new ResponseEntity<Turma>(resposta, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Turma> adicionaTurma(@Valid @RequestBody Turma turma) {
		Turma resposta = service.adicionarTurma(turma);
		return new ResponseEntity<Turma>(resposta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "{turmaId}")
	public ResponseEntity<Turma> removeTurma(@PathVariable Integer turmaId) {
		service.removeTurma(turmaId);
		return new ResponseEntity<Turma>(HttpStatus.NO_CONTENT);
	}
}

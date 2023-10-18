package br.org.celiolemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.celiolemos.api.service.AlunoService;
import br.org.celiolemos.model.Aluno;

@RestController
@RequestMapping(path = "alunos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Aluno> criarAluno(@Param("turma") Integer turma, @RequestBody Aluno aluno) {
		Aluno alunoCriado = alunoService.adicionarAluno(aluno, turma);
		return new ResponseEntity<Aluno>(alunoCriado, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Aluno> encontrarAluno(@PathVariable Integer id) {
		return new ResponseEntity<Aluno>(alunoService.encontrarPorId(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<Aluno>> encontrarTodos() {
		return new ResponseEntity<Iterable<Aluno>>(alunoService.encontrarTudo(), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
		return new ResponseEntity<Aluno>(alunoService.atualizarAluno(id, aluno), HttpStatus.OK);
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Aluno> removeAluno(@PathVariable Integer id) {
		alunoService.removeAluno(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

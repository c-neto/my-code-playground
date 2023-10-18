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

import br.org.celiolemos.api.service.PermissaoService;
import br.org.celiolemos.model.Permissao;

/**
 * RestController: Define esta classe como um controller e que as informacoes
 * enviadas estarao no body da resposta
 * 
 * ResponseBody:
 * https://stackoverflow.com/questions/28646332/how-does-the-spring-responsebody-annotation-work-in-this-restful-application-ex
 * 
 * RequestMapping parametros -> Path: Define caminho padrao, o contexto "/"
 * deste controller será /usuarios. Produces: Define a saida produzida, a
 * resposta que o servidor envia, neste caso json
 * 
 *
 */

@RestController
@RequestMapping(path = "permissoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PermissaoController {

	@Autowired
	private PermissaoService service;

	@GetMapping(path = "{id}")
	public ResponseEntity<Permissao> recuperarPermissao(@PathVariable @NonNull Integer id) {
		Permissao permissao = service.encontrarPorId(id);
		return new ResponseEntity<Permissao>(permissao, HttpStatus.OK);
	}

	/**
	 * Lista todas as permissoes
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Iterable<Permissao>> listarUsuarios() {
		Iterable<Permissao> resposta = service.encontrarTudo();
		return new ResponseEntity<Iterable<Permissao>>(resposta, HttpStatus.OK);
	}

	/**
	 * Atualiza usuario com base no body da requisicao recebida a partir da url
	 * "/usuarios/1", no corpo desta requisicao um usuario precisa ser defindo. e.g:
	 * { nome: "exemplo", senha: "super secreta" }
	 * 
	 * A anotacao Valid verifica propriedades definida na classe Usuario (se existem
	 * campos nulos ou de tamanhos nao permitidos)
	 * 
	 * @param usuario
	 * @return
	 */
	@PutMapping(path = "{id}")
	public ResponseEntity<Permissao> atualizaPermissao(@PathVariable Integer id,
			@Valid @RequestBody Permissao permissao) {
		Permissao resposta = service.atualizarPermissao(id, permissao);
		return new ResponseEntity<Permissao>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria permissao
	 * 
	 * @param Permissao
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Permissao> adicionaPermissao(@Valid @RequestBody Permissao permissao) {
		Permissao resposta = service.adicionarPermissao(permissao);
		return new ResponseEntity<Permissao>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Remove permissao
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Permissao> removeUsuario(@PathVariable Integer id) {
		service.removerPermissao(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

package br.org.celiolemos.controller;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.api.service.PermissaoService;
import br.org.celiolemos.api.service.UsuarioService;
import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.view.View;

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
@RequestMapping(path = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PermissaoService permissaoService;

	/**
	 * Recupera perfil do usuario pelo id informado na requisicao e.g /usuarios/1
	 * retorna o perfil do usuario com id numero 1
	 * 
	 * ResponseEntity e uma classe que contem todos os campos de uma resposta (body,
	 * header, status) existem mais campos mas estes sao os mais utilizados em APIs.
	 * Ela e definida com seu tipo entre <>, o interrogacao definido na assinatura
	 * do metodo quer dizer que qualquer coisa pode ser retornada, desde uma string
	 * ate uma excessao, no servico isto pode ser verificado com mais clareza
	 * 
	 * A anotacao PathVariable converte a Expression Language (parametro id entre
	 * chaves) da anotacao GetMapping para a variavel Integer id do parametro
	 * 
	 * Explicacao sobre Expression Language:
	 * https://pt.stackoverflow.com/questions/186462/o-que-%C3%A9-uma-expression-language-el
	 * 
	 * @return
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<?> perfilUsuario(@PathVariable @NonNull Integer id) {
		Usuario resposta = service.encontrarPorId(id);
		return new ResponseEntity<Usuario>(resposta, HttpStatus.OK);
	}

	/**
	 * Lista todos os usuarios
	 * 
	 * @return
	 */
	@GetMapping
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> listarUsuarios() {
		Iterable<Usuario> resposta = service.encontrarTudo();
		return new ResponseEntity<Iterable<Usuario>>(resposta, HttpStatus.OK);
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
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> atualizaUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
		Usuario resposta = service.atualizarUsuario(id, usuario);
		return new ResponseEntity<Usuario>(resposta, HttpStatus.OK);
	}

	/**
	 * Cria secretaria
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("secretaria")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> adicionaSecretaria(@Valid @RequestBody Usuario secretaria) {
		Usuario resposta = service.adicionarUsuario(secretaria, "ROLE_ADMIN");
		return new ResponseEntity<Usuario>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Cria recepcao
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("recepcao")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> adicionaRecepcao(@Valid @RequestBody Usuario recepcao) {

		Usuario resposta = service.adicionarUsuario(recepcao, "ROLE_EDITOR");
		return new ResponseEntity<Usuario>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Cria assitente social
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("assistente/social")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<?> adicionaAssistenteSocial(@Valid @RequestBody Usuario assistenteSocial) {
		Usuario resposta = service.adicionarUsuario(assistenteSocial, "ROLE_VIEWER");
		return new ResponseEntity<Usuario>(resposta, HttpStatus.CREATED);
	}

	/**
	 * Remove usuario
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> removeUsuario(@PathVariable Integer id) {
		service.removeUsuario(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("{id}/permissoes")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<Usuario> adicionaPermissaoEmUsuario(@PathVariable Integer id,
			@Valid @RequestBody Set<Permissao> permissoes) {

		Usuario resposta = permissaoService.adicionarPermissaoEmUsuario(id, permissoes);
		return new ResponseEntity<Usuario>(resposta, HttpStatus.OK);
	}

	@DeleteMapping("{id}/permissoes")
	@JsonView(View.UsuarioSemSenha.class)
	public ResponseEntity<Usuario> removerPermissaoDeUsuario(@PathVariable Integer id,
			@Valid @RequestBody Set<Permissao> permissoes) {

		Usuario resposta = permissaoService.removerPermissaoDeUsuario(id, permissoes);
		return new ResponseEntity<Usuario>(resposta, HttpStatus.OK);
	}
}

package br.org.celiolemos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.view.View;

/**
 * Acesso da secretaria = admin,
 **
 * 
 * Acesso da assistente social = viewer,
 **
 * 
 * Acesso da recepcao = editor;
 * 
 */

@Entity
@Table(name = "PERMISSAO")
public class Permissao implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "per_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.UsuarioSemSenha.class)
	private Integer id;
	@Column(name = "per_nome")
	@JsonView(View.UsuarioSemSenha.class)
	private String nome;

	public Permissao() {
		super();
	}
	
	public Permissao(String nome) {
		this.setNome(nome);
	}

	public void setAuthority(String authority) {
		this.setNome(authority);
	}

	@Override
	@JsonIgnore
	public String getAuthority() {
		return this.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

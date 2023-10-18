package br.org.celiolemos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.view.View;

@Entity
@Table(name = "TELEFONE")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tel_pk")
	@JsonView(View.UsuarioSemSenha.class)
	private Integer id;

	@Column(name = "tel_tipo")
	@Enumerated(EnumType.STRING)
	@JsonView(View.UsuarioSemSenha.class)
	private Tipo tipo;

	@Column(name = "tel_numero")
	@JsonView(View.UsuarioSemSenha.class)
	private String numero;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "tel_usr_fk", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "tel_res_fk", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Responsavel responsavel;

	public enum Tipo {
		Residencial, Movel, Profissional
	}

	public Telefone() {
	}

	public Telefone(Tipo tipo, String numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
}

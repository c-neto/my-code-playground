package br.org.celiolemos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.view.View;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_pk")
	@JsonView(View.UsuarioSemSenha.class)
	private Integer id;

	@Column(name = "end_rua")
	@JsonView(View.UsuarioSemSenha.class)
	private String rua;

	@Column(name = "end_numero")
	@JsonView(View.UsuarioSemSenha.class)
	private Integer numero;

	@Column(name = "end_complemento")
	@JsonView(View.UsuarioSemSenha.class)
	private String complemento;

	@Column(name = "end_bairro")
	@JsonView(View.UsuarioSemSenha.class)
	private String bairro;

	@Column(name = "end_cidade")
	@JsonView(View.UsuarioSemSenha.class)
	private String cidade;

	@Column(name = "end_cep")
	@JsonView(View.UsuarioSemSenha.class)
	private String cep;

	@Column(name = "end_edr_uf")
	@JsonView(View.UsuarioSemSenha.class)
	private String uf;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "end_usr_fk", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "end_res_fk", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Responsavel responsavel;

	public Endereco() {
	}

	public Endereco(String rua, Integer numero, String complemento, String bairro, String cidade, String cep,
			String uf) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

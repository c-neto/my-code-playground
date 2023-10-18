package br.org.celiolemos.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.celiolemos.model.enumerator.Sexo;

@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_pk")
	private Integer id;

	@Column(name = "res_rg")
	private String rg;

	@Column(name = "res_cpf")
	private String cpf;

	@Column(name = "res_nome")
	private String nome;

	@Column(name = "res_grau_parentesco")
	private String grauDeParentesco;

	@Column(name = "res_sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "res_data_nascimento")
	private Date dataNascimento;

	@Column(name = "res_profissao")
	private String profissao;

	@Column(name = "res_email")
	private String email;

	@OneToMany(mappedBy = "responsavel", targetEntity = Aluno.class, orphanRemoval = false)
	@JsonIgnoreProperties("responsavel")
	private Set<Aluno> alunos;

	@OneToMany(mappedBy = "responsavel", orphanRemoval = true)
	@JsonIgnoreProperties({ "usuario", "responsavel" })
	private Set<Telefone> telefones;

	@OneToMany(mappedBy = "responsavel", orphanRemoval = true)
	@JsonIgnoreProperties({ "usuario", "responsavel" })
	private Set<Endereco> enderecos;

	public Responsavel() {
	}

	public Responsavel(Set<Aluno> alunos, String rg, String cpf, String nome, String grauDeParentesco, Sexo sexo,
			Date dataNascimento, String profissao, String email) {
		super();
		this.alunos = alunos;
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.grauDeParentesco = grauDeParentesco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.profissao = profissao;
		this.email = email;
	}

	public Responsavel(String rg, String cpf, String nome, String grauDeParentesco, Sexo sexo, Date dataNascimento,
			String profissao, String email, Set<Aluno> alunos, Set<Telefone> telefones, Set<Endereco> enderecos) {
		super();
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.grauDeParentesco = grauDeParentesco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.profissao = profissao;
		this.email = email;
		this.alunos = alunos;
		this.telefones = telefones;
		this.enderecos = enderecos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}

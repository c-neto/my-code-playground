package br.org.celiolemos.model;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.celiolemos.model.enumerator.Sexo;

@Entity
@Table(name = "ALUNO")
/**
 * https://stackoverflow.com/questions/28179369/spring-rest-json-can-not-handle-managed-back-reference-defaultreference-415
 * como resolver o problema do loop infinito e exibir os objetos corretamente
 */
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alu_pk")
	private Integer id;

	@Column(name = "alu_nome")
	private String nome;

	@Column(name = "alu_sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "alu_cor")
	private String cor;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "alu_data_nascimento")
	private Date dataNascimento;

	@Column(name = "alu_numero_irmaos")
	private Integer numeroDeIrmao;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Responsavel.class)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "alu_res_fk")
	@JsonIgnoreProperties("alunos")
	private Responsavel responsavel;

	@ManyToOne
	@JoinColumn(name = "alu_trm_fk", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties("alunos")
	private Turma turma;

	@OneToMany(mappedBy = "aluno", orphanRemoval = true)
	@JsonIgnoreProperties("aluno")
	private Set<Doenca> doencas;

	public Aluno() {
	}

	public Aluno(String nome, Sexo sexo, String cor, Date dataNascimento, Integer numeroDeIrmao, Turma turma) {
		this.nome = nome;
		this.sexo = sexo;
		this.cor = cor;
		this.dataNascimento = dataNascimento;
		this.numeroDeIrmao = numeroDeIrmao;
		this.turma = turma;
	}

	public Aluno(String nome, Sexo sexo, String cor, Date dataNascimento, Integer numeroDeIrmao) {
		this.nome = nome;
		this.sexo = sexo;
		this.cor = cor;
		this.dataNascimento = dataNascimento;
		this.numeroDeIrmao = numeroDeIrmao;
	}
	
	public Aluno(String nome, Sexo sexo, String cor, Date dataNascimento, Integer numeroDeIrmao,
			Responsavel responsavel, Turma turma) {
		this.nome = nome;
		this.sexo = sexo;
		this.cor = cor;
		this.dataNascimento = dataNascimento;
		this.numeroDeIrmao = numeroDeIrmao;
		this.responsavel = responsavel;
		this.turma = turma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNumeroDeIrmao() {
		return numeroDeIrmao;
	}

	public void setNumeroDeIrmao(Integer numeroDeIrmao) {
		this.numeroDeIrmao = numeroDeIrmao;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Set<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(Set<Doenca> doencas) {
		this.doencas = doencas;
	}
}

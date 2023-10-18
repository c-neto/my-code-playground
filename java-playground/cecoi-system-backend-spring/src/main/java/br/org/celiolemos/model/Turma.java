package br.org.celiolemos.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TURMA")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trm_pk")
	private Integer id;

	@Column(name = "trm_perido")
	@Enumerated(EnumType.STRING)
	private Periodo periodo;

	@Column(name = "trm_nome")
	private String nome;

	@OneToMany(mappedBy = "turma")
	@JsonIgnoreProperties("turma")
	private Set<Aluno> alunos;

	public enum Periodo {
		Matutino, Vespertino, Noturno
	}

	public Turma() {
	}

	public Turma(Periodo periodo, String nome, Set<Aluno> alunos) {
		this.alunos = alunos;
		this.periodo = periodo;
		this.nome = nome;
	}

	public Turma(Periodo periodo, String nome) {
		this.periodo = periodo;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
}

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

@Entity
@Table(name = "DOENCA")
public class Doenca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dnc_pk")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dnc_alu_fk", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Aluno aluno;

	@Column(name = "dnc_nome")
	private String nome;

	@Column(name = "dnc_descricao")
	private String descricao;

	public Doenca() {
	}

	public Doenca(Aluno aluno, String nome, String descricao) {
		super();
		this.aluno = aluno;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

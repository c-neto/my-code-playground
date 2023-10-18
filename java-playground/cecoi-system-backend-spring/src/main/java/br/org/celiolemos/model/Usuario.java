package br.org.celiolemos.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.model.enumerator.Sexo;
import br.org.celiolemos.view.View;

/**
 * Anotacao que define classes como entidades, para que o spring data consiga
 * realizar a persistencia no banco
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id: Define que este e o id da entidade Column: No banco sera procurado por
	 * esta propriedade para mapeamento deste campo GeneratedValue: Como sera a
	 * geracao do id
	 * 
	 */
	@Id
	@Column(name = "usr_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.UsuarioSemSenha.class)
	private Integer id;

	@Column(name = "usr_login")
	@JsonView(View.UsuarioSemSenha.class)
	private String login;

	@Column(name = "usr_senha")
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_PERMISSAO", joinColumns = { @JoinColumn(name = "usr_fk") }, inverseJoinColumns = {
			@JoinColumn(name = "per_fk") })
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonView(View.UsuarioSemSenha.class)
	private List<Permissao> permissoes;

	@Column(name = "usr_email")
	@JsonView(View.UsuarioSemSenha.class)
	private String email;

	@Column(name = "usr_rg")
	@JsonView(View.UsuarioSemSenha.class)
	private String rg;

	@Column(name = "usr_cpf")
	@JsonView(View.UsuarioSemSenha.class)
	private String cpf;

	@Column(name = "usr_nome")
	@JsonView(View.UsuarioSemSenha.class)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "usr_sexo")
	@JsonView(View.UsuarioSemSenha.class)
	private Sexo sexo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "usr_data_nascimento")
	@JsonView(View.UsuarioSemSenha.class)
	private Date dataNascimento;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@JsonView(View.UsuarioSemSenha.class)
	@JsonIgnoreProperties({ "usuario", "responsavel" })
	private Set<Telefone> telefones;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@JsonView(View.UsuarioSemSenha.class)
	@JsonIgnoreProperties({ "usuario", "responsavel" })
	private Set<Endereco> enderecos;

	public Usuario() {
	}

	public Usuario(String login, String senha, List<Permissao> permissoes, String email, String rg, String cpf,
			String nome, Sexo sexo, Date dataNascimento) {
		super();
		this.permissoes = permissoes;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(String login, String senha, String email, String rg, String cpf, String nome, Sexo sexo,
			Date dataNascimento) {
		super();
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void addPermissao(Permissao permissao) {
		if (Objects.isNull(this.permissoes)) {
			this.permissoes = Arrays.asList(permissao);
			return;
		}
		this.permissoes.add(permissao);
	}

	public void removerPermissao(Permissao permissao) {
		if (Objects.isNull(this.permissoes)) {
			throw new FalhaNaRemocao("O usuário não possui nenhuma permissão, não é possível remove-las");
		}
		for (int i = 0; i < this.permissoes.size(); i++) {
			if (permissoes.get(i).getId() == permissao.getId())
				this.permissoes.remove(i);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return this.senha;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		return this.login;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
}

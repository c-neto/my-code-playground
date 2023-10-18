package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Sets;

import br.org.celiolemos.model.Aluno;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.model.Turma.Periodo;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTeste {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired PermissaoRepository permissaoRepository;
	
	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	private Usuario usuario;
	private Responsavel responsavel;
	private Endereco endereco;
	private Aluno aluno;
	private Turma turma;
	private List<Permissao> permissoes;

	@Before
	public void setUp() {

		turma = new Turma(Periodo.Matutino, "T3020B");

		endereco = new Endereco("Rua da liberdade", 55, "Perto da pastelaria", "Jd Liberdade", "São Paulo", "12324777",
				"SP");

		turma = new Turma(Periodo.Matutino, "TA2019");
		aluno = new Aluno("Aluno Teste", Sexo.Feminino, "Preto", new Date(), 3);
		responsavel = new Responsavel(Sets.newHashSet(aluno), "111111", "5555", "IResponsavel", "Irmã", Sexo.Feminino, new Date(),
				"mau", "mau@ricio.com");

		permissoes = Arrays.asList(new Permissao("admin"));
		
		usuario = new Usuario("teste", "super secreta" , "teste@teste.teste",
				"12.345.678-9", "123.456.789-00", "Teste", Sexo.Masculino, new Date());
	}

	@After
	public void tearDown() {
		turma = null;
		endereco = null;
		aluno = null;
		responsavel = null;
		usuario = null;
	}

	@Test
	public void inserindoDadosEExcluindoApenasEndereco() {
		Endereco e = enderecoRepository.save(endereco);
		Optional<Endereco> enderecoDoBanco = enderecoRepository.findById(e.getId());

		assertTrue(enderecoDoBanco.isPresent());
		assertNotNull(enderecoDoBanco.get());

		enderecoRepository.deleteById(e.getId());
	}

	@Test
	public void testeDeRelacionamentoEntreEnderecoEResponsavel() {

		Turma t = turmaRepository.save(turma);
		aluno.setTurma(t);

		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		alunoRepository.save(aluno);

		endereco.setResponsavel(responsavel);

		Endereco e = enderecoRepository.save(endereco);
		Optional<Endereco> enderecoDoBanco = enderecoRepository.findById(e.getId());

		assertTrue(enderecoDoBanco.isPresent());
		assertNotNull(enderecoDoBanco.get());
		assertNotNull(enderecoDoBanco.get().getResponsavel());

		enderecoRepository.deleteById(e.getId());
		alunoRepository.delete(aluno);
		responsavelRepository.deleteById(r.getId());
		turmaRepository.delete(t);
	}

	@Test
	public void testeDeRelacionamentoEntreEnderecoEUsuario() {
		Permissao p = permissaoRepository.save(permissoes.get(0));
		usuario.addPermissao(p);
		Usuario u = usuarioRepository.save(usuario);
		endereco.setUsuario(usuario);

		Endereco e = enderecoRepository.save(endereco);
		Optional<Endereco> enderecoDoBanco = enderecoRepository.findById(e.getId());

		assertTrue(enderecoDoBanco.isPresent());
		assertNotNull(enderecoDoBanco.get());
		assertNotNull(enderecoDoBanco.get().getUsuario());

		enderecoRepository.deleteById(e.getId());
		usuarioRepository.deleteById(u.getId());
	}
}

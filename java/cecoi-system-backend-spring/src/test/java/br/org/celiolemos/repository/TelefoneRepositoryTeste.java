package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
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
import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.model.Turma.Periodo;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelefoneRepositoryTeste {
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	private Telefone telefone;
	private Responsavel responsavel;
	private Usuario usuario;
	private Aluno aluno;
	private Turma turma;


	@Before
	public void setUp() {

		turma = new Turma(Periodo.Noturno, "TC2018");

		telefone = new Telefone(Telefone.Tipo.Profissional, "12-982014764");

		aluno = new Aluno("Aluno Teste", Sexo.Feminino, "Preto", new Date(), 3);
		responsavel = new Responsavel(Sets.newHashSet(aluno), "111111", "33333", "IResponsavel", "Irmã", Sexo.Feminino, new Date(),
				"mau", "mau@ricio.com");

		usuario = new Usuario("teste", "super secreta", "teste@teste.teste", "12.345.678-9",
				"123.456.789-00", "Teste", Sexo.Masculino, new Date());
	}

	@After
	public void tearDown() {
		telefone = null;
		aluno = null;
		responsavel = null;
		usuario = null;
		turma = null;
	}

	@Test
	public void inserindoDadosEExcluindoApenasTelefone() {
		Telefone t = telefoneRepository.save(telefone);
		Optional<Telefone> telefoneDoBanco = telefoneRepository.findById(t.getId());

		assertTrue(telefoneDoBanco.isPresent());
		assertNotNull(telefoneDoBanco.get());

		telefoneRepository.deleteById(t.getId());
	}

	@Test
	public void testeDeRelacionamentoEntreTelefoneEResponsavel() {
		Turma t = turmaRepository.save(turma);
		aluno.setTurma(t);
		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		alunoRepository.save(aluno);

		telefone.setResponsavel(responsavel);

		Telefone tel = telefoneRepository.save(telefone);
		Optional<Telefone> telefoneDoBanco = telefoneRepository.findById(tel.getId());

		assertTrue(telefoneDoBanco.isPresent());
		assertNotNull(telefoneDoBanco.get());
		assertNotNull(telefoneDoBanco.get().getResponsavel());

		telefoneRepository.deleteById(tel.getId());
		alunoRepository.delete(aluno);
		responsavelRepository.deleteById(r.getId());
		turmaRepository.delete(t);
	}

	@Test
	public void testeDeRelacionamentoEntreTelefoneEUsuario() {
		Permissao p = permissaoRepository.save(new Permissao("admin"));
		usuario.addPermissao(p);
		Usuario u = usuarioRepository.save(usuario);
		telefone.setUsuario(usuario);

		Telefone t = telefoneRepository.save(telefone);
		Optional<Telefone> telefoneDoBanco = telefoneRepository.findById(t.getId());

		assertTrue(telefoneDoBanco.isPresent());
		assertNotNull(telefoneDoBanco.get());
		assertNotNull(telefoneDoBanco.get().getUsuario());

		telefoneRepository.deleteById(t.getId());
		usuarioRepository.deleteById(u.getId());
	}
}

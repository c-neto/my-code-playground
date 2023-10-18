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

import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTeste {

	// repositories
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	private Usuario mockUsuario;

	@Before
	public void setUp() {
		mockUsuario = new Usuario("teste", "super secreta", "teste@teste.teste", "12.345.678-9", "123.456.789-00",
				"Teste", Sexo.Masculino, new Date());
	}

	@After
	public void tearDown() {
		mockUsuario = null;
	}

	@Test
	public void test() {
		Permissao p = permissaoRepository.save(new Permissao("admin"));
		mockUsuario.addPermissao(p);
		Usuario usuario = usuarioRepository.save(mockUsuario);
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario.getId());

		assertTrue(usuarioEncontrado.isPresent());
		assertNotNull(usuarioEncontrado.get());

		usuarioRepository.deleteById(usuario.getId());
	}
}

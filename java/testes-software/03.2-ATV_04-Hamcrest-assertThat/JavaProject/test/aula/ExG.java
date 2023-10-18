package aula;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 getSena(12) use uma @Rule para testar se a mensagem da exceção possui o texto "Máximo 12";
 */

public class ExG {

	@Rule
	public ExpectedException excecaoEsperada = ExpectedException.none();

	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}

	@After
	public void tearDown() {
		s = null;
	}

	@Test
	public void teste() throws Exception {
		excecaoEsperada.expectMessage("Maximo 12");
		s.getSena(13);
	}
}

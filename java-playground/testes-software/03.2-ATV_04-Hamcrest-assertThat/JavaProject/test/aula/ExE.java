package aula;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
e) getSena(null) neste caso o indicado seria usar o atributo expected=Exception.class na anotação @Test. Porém aqui
será obrigatório usar uma @Rule para ExpectedException;
*/

public class ExE {

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
	public void testeNull() throws Exception {
		excecaoEsperada.expect(NullPointerException.class);
		s.getSena(null);
	}

}

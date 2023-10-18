package aula;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;;

@RunWith(Parameterized.class)
public class TestesParametrizados03 {

	private Operacao op;
	private Object obj;
	private boolean esperado;
	
	public TestesParametrizados03(Object obj, boolean esperado) {
		this.obj = obj;
		this.esperado = esperado;
	}

	@Before
	public void setUp() {
		op = new Operacao();
	}

	@After
	public void tearDown() {
		op = null;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {

		Object[][] v = new Object[][] {
			{12, true},
			{12.0, true},
			{(char)12.0, false},
			{"12", false},
			{new Object(), false},
			{null, false}
		};

		return Arrays.asList(v);
	}

	@Test
	public void teste() throws Exception {
		assertTrue(op.isNumber(obj));
	}
}
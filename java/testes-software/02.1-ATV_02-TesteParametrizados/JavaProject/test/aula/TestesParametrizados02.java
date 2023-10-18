package aula;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;;

@RunWith(Parameterized.class)
public class TestesParametrizados02 {

	private Operacao op;
	private double a;
	private double b;
	private double saida;

	public TestesParametrizados02(double b, double a, double saida) {
		this.a = a;
		this.b = b;
		this.saida = saida;
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
			{ 0, 0, 0 }, 	// red - nao lanca execessao
			{-1, 0, -1},	// green
			{0, -1, -1},	// green
			{-1, -1, 1},	// green
			{5, 5, 5}		// red - nao lanca excessao (esperado nao coeso)
		};

		return Arrays.asList(v);
	}
//O que retornar exceção eh "verde"
	@Test(expected = Exception.class)
	public void teste() throws Exception {
			assertEquals(saida, op.areaRetangulo(b, a), 0);

	}
}


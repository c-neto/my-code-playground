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
public class TestesParametrizados01 {

	private Operacao op;
	private double a;
	private double b;
	private double saida;

	public TestesParametrizados01(double b, double a, double saida) {
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
				{ 0, 0, 0 }, // green
				{ 1, 1, 1 }, // green
				{ 2, 0, 0 }, // green
				{ 0, 2, 0 }, // green
				{ 1, 1, 10 }, // red
		};

		return Arrays.asList(v);
	}

	@Test
	public void teste() throws Exception {
		System.out.println("TESTE: " + "A=" + a + " B=" + b + " SAIDA=" + saida);
			assertEquals(saida, op.areaRetangulo(b, a), 0);

	}
}

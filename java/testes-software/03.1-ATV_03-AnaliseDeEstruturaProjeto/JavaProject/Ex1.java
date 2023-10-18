package aula;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Ex1 {

	private Operacao op;
	double a, b;
	double esperado;

	public Ex1(double a, double b, double esperado) {
		this.b = b;
		this.a = a;
		this.esperado = esperado;
	}

	@Before
	public void setUp() {
		op = new Operacao();
	}

	@Parameters
		public static Collection<Object[]> argumentos(){
			return Arrays.asList(new Object[][]{{0, 0, 0},
							{1, 1, 1},
							{2, 0, 0},
							{0, 2, 0}}
					);

		}

	@Test
	public void areaRetanguloTest() throws Exception {
		assertEquals(op.areaRetangulo(b, a), esperado,0.5);
	}
}

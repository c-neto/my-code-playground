package aula;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Ex2 {

	Operacao op;
	double a, b, esperado;

	public Ex2(double a, double b, double esperado) {
		this.a = a;
		this.b = b;
		this.esperado = esperado;
	}
	
	@Before
	public void setUp() {
		op = new Operacao();
	}
	
	@Parameters
	public static Collection<Object[]> areaRetTest() {
		return Arrays.asList(new Object[][]
				{{-1, 0, -1},
				{0, -1, -1},
				{-1, -1, 1}});
	}
	
	@Test(expected=Exception.class)
	public void areaRetanguloTest() throws Exception {
		assertNotEquals(op.areaRetangulo(b, a), esperado,1.5);
	}
}

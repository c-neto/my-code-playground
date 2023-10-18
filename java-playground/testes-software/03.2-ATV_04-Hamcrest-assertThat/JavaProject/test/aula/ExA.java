package aula;

import org.junit.Before;
import org.junit.Test;

/*
 * getSena(6) retorna um array com 6 elementos. Use o método hasSize da classe IsCollectionWithSize;
 * 
*/

public class ExA {

	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}

	@Test
	public void hasSizeTest() throws Exception {

		System.out.println();

		Integer[] listaInt = new Integer[5];
		for (int i = 0; i < listaInt.length; i++) {
			listaInt[i] = (int) (Math.random() * 2);
		}

		Float[] listaFloat = new Float[5];
		for (int i = 0; i < listaInt.length; i++) {
			listaFloat[i] = (float) (Math.random() * 1.115);
		}

		System.out.println("Lista FLOAT");
		for (float k : listaInt) {
			System.out.println(k);
		}

		System.out.println("Lista INT");
		for (int k : listaInt) {
			System.out.println(k);
		}

	}

}

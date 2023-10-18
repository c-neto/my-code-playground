package aula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PontoTest {

	@Test
	public void test() {
		/* cria um objeto da classe externa */
		Geometria g = new Geometria();

		/* cria um objeto da classe interna */
		Geometria.Ponto p = g.new Ponto(2, 2);
		
		/* cria um objeto da classe interna */
		Geometria.Ponto pZero = g.new Ponto(0, 0);
		
		/* testa o método distancia */
		assertEquals(2.82, p.distancia(pZero), 0.01);
	}
}

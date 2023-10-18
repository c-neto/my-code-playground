package aula;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.Before;
import org.junit.Test;

/*
 * getSena(10) retorna um array onde cada elemento possui valor no intervalo [1,60]. Para fazer esse teste será necessário 
 * combinar os métodos everyItem (classe CoreMatchers), allOf, greaterThanOrEqualTo e lessThanOrEqualTo da
 * classe Matchers;
*/

public class ExB {

	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}

	@Test
	public void allOfTest() throws Exception {

		for (int k : s.getSena(10)) {
			System.out.println(k);
		}
		
		assertThat(s.getSena(10), everyItem(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(60))));

	}
}

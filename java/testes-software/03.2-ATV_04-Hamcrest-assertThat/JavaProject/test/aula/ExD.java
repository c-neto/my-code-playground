package aula;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;

/*

d) getSena(10) retorna um array sem elementos duplicados. Será necessário criar um método para comparar os elementos
usando uma implementação da classe abstrata TypeSafeMatcher;

 */

public class ExD {

	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}

	@Test
	public void checarElementosDuplicados() throws Exception {
		assertThat( s.getSena(10), checkDuplicate() );
	}

	/* matcher para testar o 2o caracter da string */
	private TypeSafeMatcher<List<Integer>> checkDuplicate() {

		return new TypeSafeMatcher<List<Integer>>() {
			protected boolean matchesSafely(List<Integer> str) {
				int tam = 0;
				while (tam < str.size()) {
					for (int i = tam + 1; i < str.size(); i++) {
						if (str.get(tam) == str.get(i)) {
							return false;
						}
					}
					tam++;
				}
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}

		};
	}
}

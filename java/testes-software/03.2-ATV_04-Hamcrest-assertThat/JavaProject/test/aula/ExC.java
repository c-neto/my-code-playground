package aula;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;

/*
getSena(10) retorna um array onde todos os elementos estão ordenados. Será necessário criar um método para
comparar os elementos usando uma implementação da classe abstrata TypeSafeMatcher (
https://junit.org/junit4/javadoc/4.12/org/hamcrest/TypeSafeMatcher.html), que por usa vez herda a classe abstrata
BaseMatcher (https://junit.org/junit4/javadoc/4.12/org/hamcrest/BaseMatcher.html) e esta implementa a interface
Matcher;
*/

public class ExC {


	Sena s;

	@Before
	public void setUp() {
		s = new Sena();
	}

	@Test
	public void checarElementosDuplicados() throws Exception {
		assertThat( s.getSena(10), checkOrdenate() );
	}

	/* matcher para testar o 2o caracter da string */
	private TypeSafeMatcher<List<Integer>> checkOrdenate() {

		return new TypeSafeMatcher< List<Integer> >() {
			protected boolean matchesSafely(List<Integer> str) {
				int tam = 0;
				while (tam < str.size()) {
					for (int i = tam + 1; i < str.size(); i++) {
						if (str.get(tam) > str.get(i)) {
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

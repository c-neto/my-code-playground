package aula;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/* A classe precisa ser anotada com @RunWith(Parameterized.class) */

@RunWith(Parameterized.class)
public class TestesClasseParametrizada {

	/*
	 * A classe precisa ter os atributos que serão usados no teste, que são a
	 * entrada e esperado.
	 */
	private int entrada;
	private boolean esperado;
	private Operacao02 op;

	@Before
	public void initialize() {
		op = new Operacao02();
	}

	/*
	 * Construtor que recebe cada elemento do array retornado pelo método
	 * parametros.
	 */
	public TestesClasseParametrizada(int entrada, boolean esperado) {
		/*
		 * Quem passa o valor para essas variaveis "(int entrada, boolean esperado)"
		 * é a classe anotada como @Parameterized.Parameters
		 * ele executa passando um indice de sua matriz
		 * pega os valores e atribui para atributo desta classe 
		 * (this.entrada = entrada; this.esperado = esperado)
		 * 
		 */
				
		this.entrada = entrada;
		this.esperado = esperado;
	}

	/*
	 * Método estático anotado por @Parameters, que retorna uma coleção de
	 * objetos (como Array) // * com os parâmetros de teste (entrada) 
	 * e resultado (esperado).
	 */

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		// É object porque tem que abranger variaveis de tipo distintos (no caso "int" e "boolean")
		
		/* É um vetor porque a classe constructor necessita de duas variaveis "(int entrada, boolean esperado)"
		 * para ser chamada...
		 */
		
		/* É um vetor de vetor para ter varios testes(cada teste é um vetor "{int, boolean}" )...
		 * assim, para ter varios testes, fazemos um vetor de testes...
		 * a anotação @Parameterized.Parameters faz com que o metodo execute por vez em vez, 
		 * um indice do vetor, e cada indice deste vetor é retornado para o metodo constructor
		 * da classe,
		 * o comportamento do metodo constructor da classe neste caso, insere valor aos atributos
		 * desta classe... 
		 * 
		 * metodo constructor{ 				
		 * 		this.entrada = entrada;
		 * 		this.esperado = esperado;
		 * }
		 *
		 * o metodo anotado como @Test, pega o valor do atributo desta classe e executa o teste
		*/
		
		Object[][] v = new Object[][] {
			{ 1, false }, 
			{ 2, true }, 
			{ 5, false }, 
			{ 10, true }, 
			{ 0, false } 
		};
		
		return Arrays.asList(v);
		
			
	}

	@Test
	public void test1() {
		System.out.println("Testando: " + entrada);
		assertEquals(esperado, op.isPar(entrada));
		
		/*
		* o valor de "entrado" e "esperado" é definido no método construtor desta
		* classe
		*/

		/*
		 * O método constructor, por sua vez, assume o valor do retorno da classe
		 * anotada como @Parameterized.Parameters
		 * cada interacao retorna um "int" e "boolean" e a iteracao da matriz "Object[][] v = new Object[][]" 
		 * e feita automaticamente por causa do @Parameterized.Parameters
		 */
	}
	
}

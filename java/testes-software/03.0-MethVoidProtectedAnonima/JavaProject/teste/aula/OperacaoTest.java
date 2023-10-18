package aula;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class OperacaoTest {
	private Operacao op;

	@Before
	public void setUp() {
		op = new Operacao();
	}

	@Test
	public void testSoma2() {
		try {
			
			/* o método getDeclaredMethod recebe como parâmetro o nome do método (soma) e a
			 * lista de parâmetros do método. No caso do método soma são dois parâmetros do
			 * tipo int. O método getDeclaredMethod retorna um objeto do tipo Method	*/
			 
			Method metodoSoma2 = Operacao.class.getDeclaredMethod("soma", int.class, int.class);
			/*
			 * o valor true indica que o objeto refletido deverá ter o modificador de
			 * visibilidade suprimido
			 */
			metodoSoma2.setAccessible(true);
			/*
			 * chama o método soma passando os parâmetros 12 e 20. É necessário fornecer um
			 * objeto do tipo Operacao
			 */
			int r = (int) metodoSoma2.invoke(op, 8, 12);
			/* checa se o resultado é 20 */
			assertEquals(20, r, 0);
		}

		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSoma3() {
		try {
			Method metodoSoma3 = Operacao.class.getDeclaredMethod("soma", int.class, int.class, int.class);
			metodoSoma3.setAccessible(true);
			int r = (int) metodoSoma3.invoke(op, 8, 12, 5);
			/* checa se o resultado é 25 */
			assertEquals(25, r, 0);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsPar() {
		try {
			Method metodoIsPar = Operacao.class.getDeclaredMethod("isPar", int.class);
			metodoIsPar.setAccessible(true);
			boolean r = (boolean) metodoIsPar.invoke(op, 11);
			/* checa se o resultado é false */
			assertFalse(r);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testComprimento() {
		try {
			Method metodoComprimento = Operacao.class.getDeclaredMethod("comprimento", String.class);
			metodoComprimento.setAccessible(true);
			/* quando é estático pode-se fornecer o argumento null */
			int r = (int) metodoComprimento.invoke(null, "Bom dia");
			/* checa se o resultado é 7 */
			assertEquals(7, r, 0);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}

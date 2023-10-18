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
public class Ex3 {

	Object obj;
	boolean esperado;
	Operacao op;
	
	public Ex3(Object obj, boolean esperado) {
		this.obj = obj;
		this.esperado = esperado;
	}
	
	@Before
	public void setUp() {
		op = new Operacao();
	}
	
	@Parameters
	public static Collection<Object[]> isNumberParam(){
		return Arrays.asList(new Object[][] 
		{{12, true},
		 {12.0, true},
		 {(char)12.0, false},
		 {"12", false},
		 {new Object(), false},
		 {null, false} });
	}
	
	@Test
	public void isNumberTest() throws Exception {
		assertEquals(op.isNumber(obj),esperado);
	}

}

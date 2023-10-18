package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class Ex02 {

	@Mock
	private A a = null;

	@Before
	public void setUp() throws NullPointerException, Exception {
		a = mock(A.class);
	}

	@Test(expected = Exception.class)
	public void test3() throws NullPointerException, Exception {
		doThrow(new Exception()).when(a).msg("Texto Aleatorio");
	}

}

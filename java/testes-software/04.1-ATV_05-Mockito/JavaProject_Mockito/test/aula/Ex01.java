package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class Ex01{

	@Mock
	private A a = null;
	
	
	@Before
	public void setUp() throws NullPointerException, Exception {
		a = mock(A.class);
		
		when(a.calc(2, 2)).thenReturn(4);
		when(a.calc("x", "y")).thenReturn("xy");
		when(a.calc(null, "y")).thenThrow(new NullPointerException());
		when(a.calc("2", 2)).thenThrow(new Exception());		
	}
	
	@Test
	public void test1() throws NullPointerException, Exception {
		//verify(a, times(0)).calc(2, 2);
		assertSame(4, a.calc(2, 2));
	}
	
	@Test
	public void test2() throws NullPointerException, Exception {
		//verify(a, times(0)).calc("x", "y");
		assertSame("xy", a.calc("x", "y"));
	}
	
	@Test(expected=Exception.class)
	public void test3() throws NullPointerException, Exception{
		//verify(a, times(0)).calc("x", "y");
		doThrow(new NullPointerException()).when(a.calc(null,"y"));
	}
	
	@Test(expected=Exception.class)
	public void test4() throws NullPointerException, Exception{
		//verify(a, times(0)).calc("x", "y");
		doThrow(new Exception()).when(a.calc("2",2));
	}		
	
}
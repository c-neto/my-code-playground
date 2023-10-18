package aula;

public class Operacao {
	private int soma(int a, int b) {
		return a + b;
	}

	private int soma(int a, int b, int c) {
		return a + b + c;
	}

	private boolean isPar(int a) {
		return a % 2 == 0;
	}

	private static int comprimento(String a) {
		return a.length();
	}
	
}

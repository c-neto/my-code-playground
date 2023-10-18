package aulax;

public class VetorMetodosProtect {
	private static Object[] lista = new Object[3];

	public static void add(Object obj) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {
				lista[i] = obj;
				break;
			}
		}
	}

	protected static boolean existe(Object obj) {
		for (int i = 0; i < lista.length; i++) {
			if (obj.equals(lista[i])) {
				return true;
			}
		}
		return false;
	}
}

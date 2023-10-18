package aula;

public class Vetor {

	private static Object[] lista = new Object[3];

//	/* procura a 1a posição vazia no array e coloca o obj nel */
//	public static void add(Object obj) {
//		for (int i = 0; i < lista.length; i++) {
//			if (lista[i] == null) {
//				lista[i] = obj;
//				break;
//			}
//		}
//	}
//
//	/* retorna true se o obj existe na lista */
//	public static boolean existe(Object obj) {
//		for (int i = 0; i < lista.length; i++) {
//			if (obj.equals(lista[i])) {
//				return true;
//			}
//		}
//		return false;
//	}
//

	protected static void add(Object obj) {
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

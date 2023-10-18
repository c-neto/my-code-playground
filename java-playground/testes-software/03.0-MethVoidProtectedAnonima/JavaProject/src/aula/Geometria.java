package aula;

import java.util.ArrayList;
import java.util.List;

public class Geometria {

	private List<Ponto> lista = new ArrayList<>();

	public void add(Ponto p) {
		lista.add(p);
	}

	public void imprimir() {
		for (Ponto p : lista) {
			System.out.println(p);
		}
	}

	public class Ponto {
		private double x, y;

		public Ponto(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double distancia(Ponto p) {
			return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
		}

		@Override
		public String toString() {
			return x + "," + y;
		}
	}

}

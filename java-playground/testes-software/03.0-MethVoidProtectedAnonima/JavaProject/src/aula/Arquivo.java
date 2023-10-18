package aula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
	public static boolean escrever(File arquivo, String linha) throws IOException {
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(linha);
		bw.close();
		return true;
	}

	public static boolean imprimir(File arquivo) throws IOException {
		/* abre o arquivo para leitura */
		FileReader reader = new FileReader(arquivo);
		BufferedReader b = new BufferedReader(reader);
		String linha = null;
		do {
			linha = b.readLine();
			if (linha != null) {
				System.out.println(linha);
			}
		} while (linha != null);

		b.close();
		reader.close();
		return true;
	}
}
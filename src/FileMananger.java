import java.io.BufferedReader;
import java.io.FileReader;

public class FileMananger {
	public static char[] open_file(String name) {
		try {
			FileReader file = new FileReader(name);
			BufferedReader read_file = new BufferedReader(file);

			String linha = read_file.readLine();
			String linhaConcat = linha;
			
			char [] vetorTodasLinhas = null;
			
			while (linha != null) {
				linha = read_file.readLine();
				if (linha != null) {
					linhaConcat += linha;
				}
			}
			
			vetorTodasLinhas = linhaConcat.toCharArray();
			
			file.close();
			
			for (int i = 0; i < vetorTodasLinhas.length; i++) {
				System.out.println(vetorTodasLinhas[i]);
			}
			return vetorTodasLinhas;
			
		} catch (Exception e) {
			System.out.println("error " + e);
		}
		return null;
	}
	/*
	 * Abrir arquivo Fechar arquivo Ler arquivo => retorno é um array de caracteres
	 */
}

import java.io.BufferedReader;
import java.io.FileReader;

public class FileMananger {
	public static String open_file(String name) {
		try {
			FileReader file = new FileReader(name);
			BufferedReader read_file = new BufferedReader(file);

			String linha = read_file.readLine();
			String linhaConcat = linha;
			
			while (linha != null) {
				linha = read_file.readLine();
				if (linha != null) {
					linhaConcat += linha;
				}
			}

			file.close();
			
			return linhaConcat;
			
		} catch (Exception e) {
			System.out.println("error " + e);
		}
		return null;
	}
	/*
	 * Abrir arquivo Fechar arquivo Ler arquivo => retorno � um array de caracteres
	 */
}

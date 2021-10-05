import java.io.BufferedReader;
import java.io.FileReader;

public class FileMananger {
	public static void open_file(String name) {
		try {
			FileReader file = new FileReader(name);
			BufferedReader read_file = new BufferedReader(file);

			String linha = read_file.readLine();

			while (linha != null) {
				System.out.printf("%s\n", linha);

				linha = read_file.readLine();
			}
			file.close();
		} catch (Exception e) {
			System.out.println("error " + e);
			// TODO: handle exception
		}
	}
	/*
	 * Abrir arquivo Fechar arquivo Ler arquivo => retorno é um array de caracteres
	 */
}

import java.util.ArrayList;

public class AppSystem {
	
	public static void initialize() {
		String vetorChar;
		ArrayList<Token> alToken;
		
		vetorChar 	= FileMananger.open_file("archive.txt");
		alToken 	= TokenMananger.generateTokens(vetorChar);
	
		for (Token token : alToken) {
			if(token.getType() == Token.TYPE_ENDLINE) {
				System.out.println(" "+token.getValue()+" {"+token.getType()+"}");
			}else{
				System.out.print(" "+token.getValue()+" {"+token.getType()+"}");
			}
		}
		
		TokenMananger.analLex(alToken);
		
	}

}

import java.util.ArrayList;

public class TokenMananger {

	public static ArrayList<Token> generateTokens(String fileData){
	
		String cmdLine[];
		String cmdWord[];
			
		ArrayList<Token> listToken = new ArrayList<>();

		cmdLine = fileData.split(";");
		
		for (String strToAnalise : cmdLine) {
			
			cmdWord = strToAnalise.split(" ");
			for (String cmdWord_str : cmdWord) {
				listToken.add(discoverTypeToken(cmdWord_str));
			}
			listToken.add(discoverTypeToken(";"));
			
		}
		
		return listToken;	
	}
	
	public static int analLex(ArrayList<Token> alToken) {
		
		int countLine = 0;
		
		
		
		return countLine;
	}
	
	public static Token discoverTypeToken(String value) {
		
		String regex_nmb = "[0-9]+";
		String regex_str = "";
		
		switch (value) { 
		
			case "int": case "float": case "string": case "char": 
			case "if": case "while": case "for": case "print":
				return new Token(value, Token.TYPE_RESERVADA);
			
			case "*": case "+": case "/": case "-": case "^":
				return new Token(value, Token.TYPE_OPERADOR);
				
			case "=":
				return new Token(value, Token.TYPE_ATRIBUICAO);
				
			case ";":
				return new Token(value, Token.TYPE_ENDLINE);
				
		}

		if(value.matches(regex_nmb))
			return new Token(value, Token.TYPE_NUMERICO);
		
		if(value.matches(regex_str))
			return new Token(value, Token.TYPE_LITERAL);
		
		return new Token(value, Token.TYPE_IDENTIFICADOR);
	}
	
}
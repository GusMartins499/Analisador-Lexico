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
	
	public static void analLex(ArrayList<Token> alToken) {
		
		int countLine = 1;
		
		for(int i = 0; i < alToken.size(); i++) {
			
			///////////////////////////
			// VERIFICACOES COM ATRIBUIBUICAO
			///////////////////////////
			if(alToken.get(i).getType() == Token.TYPE_ATRIBUICAO) {
				
				if(alToken.get(i+1).getType() != Token.TYPE_NUMERICO && 
						alToken.get(i+1).getType() != Token.TYPE_LITERAL &&
						alToken.get(i+1).getType() != Token.TYPE_IDENTIFICADOR &&
						alToken.get(i+1).getType() != Token.TYPE_LOGICA) {
					System.err.println("Erro | Atribuindo um valor incorreto | Linha: "+ countLine);
				}

				if(alToken.get(i-1).getType() != Token.TYPE_IDENTIFICADOR) {
					System.err.println("Erro | Atribuição incorreta | Linha: "+ countLine);
				}
				
				if(alToken.get(i-1).getType() != Token.TYPE_IDENTIFICADOR) {
					System.err.println("Erro | Atribuição incorreta | Linha: "+ countLine);
				}

			}

			///////////////////////////
			// VERIFICACOES DE OPERACOES
			///////////////////////////
			if(alToken.get(i).getType() == Token.TYPE_OPERADOR) {
				
				if(alToken.get(i+1).getType() != Token.TYPE_NUMERICO &&
						alToken.get(i+1).getType() != Token.TYPE_IDENTIFICADOR) {
					System.err.println("Erro | Operacação incorreta | Linha: "+ countLine);
				}

				if(alToken.get(i-1).getType() != Token.TYPE_NUMERICO &&
						alToken.get(i-1).getType() != Token.TYPE_IDENTIFICADOR) {
					System.err.println("Erro | Operacação incorreta | Linha: "+ countLine);
				}
				
			}
			
			///////////////////////////
			// VERIFICACOES DE RESERVADAS
			///////////////////////////
			if(alToken.get(i).getType() == Token.TYPE_RESERVADA) {
				if(alToken.get(i).getType() != Token.TYPE_IDENTIFICADOR) {
					System.err.println("Erro | Declaração de variavel invalida | Linha: "+ countLine);
				}
			}
			
			if(alToken.get(i).getValue() == ";") {
				countLine++;
			}
			
		}

	}
	
	public static Token discoverTypeToken(String value) {
		
		String regex_nmb = "[0-9]+";

		switch (value) { 
		
			case "int": case "float": case "string": case "char": case "bool":
				return new Token(value, Token.TYPE_RESERVADA);
			
			case "*": case "+": case "/": case "-": case "^":
				return new Token(value, Token.TYPE_OPERADOR);
				
			case "=":
				return new Token(value, Token.TYPE_ATRIBUICAO);
				
			case ";":
				return new Token(value, Token.TYPE_ENDLINE);
				
			case "true": case "false":
				return new Token(value, Token.TYPE_LOGICA);
		}

		if(value.matches(regex_nmb))
			return new Token(value, Token.TYPE_NUMERICO);
		
		if(value.contains("\""))
			return new Token(value, Token.TYPE_LITERAL);
		
		return new Token(value, Token.TYPE_IDENTIFICADOR);
	}
	
}

/**
 * 1 = value;
value =;
1 =;
= 1;
= *;
value = *;
* 1;
1 * true;
2 + "teste";
value * = ;
1234 = 1;
int 123;
 */



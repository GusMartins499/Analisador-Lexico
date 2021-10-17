
public class Token {

	public static final String TYPE_IDENTIFICADOR 	= "Identificador";
	public static final String TYPE_RESERVADA 		= "Reservada";
	public static final String TYPE_OPERADOR  		= "Operador";
	public static final String TYPE_ATRIBUICAO  	= "Atribuicao";
	public static final String TYPE_ENDLINE			= "EOL";
	public static final String TYPE_NUMERICO  		= "Numerico";
	public static final String TYPE_LITERAL 		= "Literal";
	public static final String TYPE_LOGICA 			= "Logico";

	String value;
	String type;
	
	public Token(String value, String type) {
		super();
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}

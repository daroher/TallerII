package sistema.excepciones;

public class ValorInvalidoException extends RuntimeException {

	public ValorInvalidoException() {
		super();
	}

	public ValorInvalidoException(String message) {
		super(message);
	}
}

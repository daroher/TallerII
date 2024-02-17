package sistema.excepciones;

public class NoHayAsignaturasException extends RuntimeException {

	public NoHayAsignaturasException() {
		super();
	}

	public NoHayAsignaturasException(String message) {
		super(message);
	}
	
}

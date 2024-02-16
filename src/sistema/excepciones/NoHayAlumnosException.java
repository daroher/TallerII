package sistema.excepciones;

public class NoHayAlumnosException extends RuntimeException {

	public NoHayAlumnosException() {
		super();
	}

	public NoHayAlumnosException(String message) {
		super(message);
	}
	
}

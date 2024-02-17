package sistema.excepciones;

public class AlumnoNoExisteException extends RuntimeException {

	public AlumnoNoExisteException() {
		super();
	}

	public AlumnoNoExisteException(String message) {
		super(message);
	}
}

package sistema.excepciones;

public class AlumnoExistenteException extends RuntimeException {

	public AlumnoExistenteException() {
		super();
	}

	public AlumnoExistenteException(String message) {
		super(message);
	}
}

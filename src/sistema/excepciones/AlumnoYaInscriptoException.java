package sistema.excepciones;

public class AlumnoYaInscriptoException extends RuntimeException {

	public AlumnoYaInscriptoException() {
		super();
	}

	public AlumnoYaInscriptoException(String message) {
		super(message);
	}
}

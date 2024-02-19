package sistema.excepciones;

public class AlumnoSinInscripcionesException extends RuntimeException {
	public AlumnoSinInscripcionesException() {
		super();
	}

	public AlumnoSinInscripcionesException(String message) {
		super(message);
	}
}

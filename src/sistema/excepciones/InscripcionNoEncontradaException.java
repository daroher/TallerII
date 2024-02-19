package sistema.excepciones;

public class InscripcionNoEncontradaException extends RuntimeException {
	public InscripcionNoEncontradaException() {
		super();
	}

	public InscripcionNoEncontradaException(String message) {
		super(message);
	}
}

package sistema.excepciones;

public class AsignaturaNoExisteException extends RuntimeException {

	public AsignaturaNoExisteException() {
		super();
	}

	public AsignaturaNoExisteException(String message) {
		super(message);
	}
}

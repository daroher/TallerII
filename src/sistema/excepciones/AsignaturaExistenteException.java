package sistema.excepciones;

public class AsignaturaExistenteException extends RuntimeException {
	public AsignaturaExistenteException() {
		super();
	}

	public AsignaturaExistenteException(String message) {
		super(message);
	}
}

package sistema.excepciones;

public class CalificacionYaIngresadaException extends RuntimeException {
	public CalificacionYaIngresadaException() {
		super();
	}

	public CalificacionYaIngresadaException(String message) {
		super(message);
	}
}

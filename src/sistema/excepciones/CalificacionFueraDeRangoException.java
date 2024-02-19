package sistema.excepciones;

public class CalificacionFueraDeRangoException extends RuntimeException {
	public CalificacionFueraDeRangoException() {
		super();
	}

	public CalificacionFueraDeRangoException(String message) {
		super(message);
	}
}

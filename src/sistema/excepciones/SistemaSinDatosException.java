package sistema.excepciones;

public class SistemaSinDatosException extends RuntimeException {

	public SistemaSinDatosException() {
		super();
	}

	public SistemaSinDatosException(String message) {
		super(message);
	}
	
}

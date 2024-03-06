package sistema.excepciones;

public class NoHayEgresadosException extends RuntimeException {

	public NoHayEgresadosException() {
		super();
	}

	public NoHayEgresadosException(String message) {
		super(message);
	}
	
}

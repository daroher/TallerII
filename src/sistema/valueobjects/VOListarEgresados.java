package sistema.valueobjects;

public class VOListarEgresados {

	private String modoListado;	
	
	
	public VOListarEgresados (String modoListado) {
		
		this.modoListado = modoListado;
	}


	public String getModoListado() {
		return modoListado;
	}


	public void setModoListado(String modoListado) {
		this.modoListado = modoListado;
	}
	
		
	
}

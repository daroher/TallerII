package sistema.valueobjects;

public class VOCalcularMontoRecaudado {

	private int cedula;
	private int anioLec;
	
	public VOCalcularMontoRecaudado(int ced, int anioLec) {
		this.cedula = ced;
		this.anioLec = anioLec;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getAnioLec() {
		return anioLec;
	}

	public void setAnioLec(int anioLec) {
		this.anioLec = anioLec;
	}
}

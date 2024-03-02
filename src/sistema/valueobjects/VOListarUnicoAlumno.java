package sistema.valueobjects;

import java.io.Serializable;

public class VOListarUnicoAlumno implements Serializable{
	
	private int cedula;
	
	public VOListarUnicoAlumno (int cedula) {
		this.cedula = cedula;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
}
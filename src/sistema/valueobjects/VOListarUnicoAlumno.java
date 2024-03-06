package sistema.valueobjects;

import java.io.Serializable;

public class VOListarUnicoAlumno implements Serializable{
	
	private Integer cedula;
	
	public VOListarUnicoAlumno (Integer cedula) {
		this.cedula = cedula;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
}
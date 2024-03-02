package sistema.valueobjects;

import java.io.Serializable;

public class VOListarAlumnos implements Serializable{
	
	private String apellido;
	
	public VOListarAlumnos (String apellido) {
		
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}

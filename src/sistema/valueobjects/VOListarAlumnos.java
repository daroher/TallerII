package sistema.valueobjects;

public class VOListarAlumnos {
	
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

package sistema.valueobjects;

public class VOListarUnicoAlumno {
	
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
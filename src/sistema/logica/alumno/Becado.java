package sistema.logica.alumno;

public class Becado extends Alumno {
	
	private int porcentajeBeca;
	private String razonBeca;
	
	public Becado(int cedula, String nombre, String apellido, String domicilio, String telefono, int porcentajeBeca, String razonBeca) {
		super(cedula, nombre, apellido, domicilio, telefono);
		this.porcentajeBeca = porcentajeBeca;
		this.razonBeca = razonBeca;
	}

	public int getPorcentajeBeca() {
		return porcentajeBeca;
	}

	public void setPorcentajeBeca(int porcentajeBeca) {
		this.porcentajeBeca = porcentajeBeca;
	}

	public String getRazonBeca() {
		return razonBeca;
	}

	public void setRazonBeca(String razonBeca) {
		this.razonBeca = razonBeca;
	}
}

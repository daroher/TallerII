package sistema.valueobjects;

import sistema.logica.alumno.TipoAlumno;

public class VOAlumnoRegistro extends VOAlumno {
	
	private String domicilio;
	private String telefono;
	private int porcentajeBeca;
	private String razonBeca;

	public VOAlumnoRegistro(int cedula, String nombre, String apellido, TipoAlumno tipoAlumno, String domicilio, String telefono, int porcentajeBeca, String razonBeca) {
		super(cedula, nombre, apellido, tipoAlumno);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.porcentajeBeca = porcentajeBeca;
		this.razonBeca = razonBeca;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

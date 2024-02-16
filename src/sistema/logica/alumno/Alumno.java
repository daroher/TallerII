package sistema.logica.alumno;

import sistema.logica.inscripcion.Inscripciones;

public class Alumno {
	
	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private int cantAsignaturasAprobadas;
	private Inscripciones inscripciones;

	public Alumno(int cedula, String nombre, String apellido, String domicilio, String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	public int getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public int getCantAsignaturasAprobadas() {
		return cantAsignaturasAprobadas;
	}

	public Inscripciones getInscripciones() {
		return inscripciones;
	}
	
	public void incrementarCantAsignaturasAprobadas() {
		this.cantAsignaturasAprobadas++;
	}
	
	public void inscribirEnAsignatura(String cod, int anioLec, float monto) {
		
	}
}

package sistema.valueobjects;

import java.io.Serializable;

import sistema.logica.alumno.TipoAlumno;

public class VOAlumno implements Serializable{

	private int cedula;
	private String nombre;
	private String apellido;
	private TipoAlumno tipoAlumno;
	
	public VOAlumno(int cedula, String nombre, String apellido, TipoAlumno tipoAlumno) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoAlumno = tipoAlumno;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
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

	public TipoAlumno getTipoAlumno() {
		return tipoAlumno;
	}

	public void setTipoAlumno(TipoAlumno tipoAlumno) {
		this.tipoAlumno = tipoAlumno;
	}
}

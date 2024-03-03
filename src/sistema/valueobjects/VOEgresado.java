package sistema.valueobjects;

import java.io.Serializable;

public class VOEgresado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cedula;
	private String nombre;
	private String apellido;

	public VOEgresado(int cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
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
}

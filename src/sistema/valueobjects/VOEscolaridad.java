package sistema.valueobjects;

import java.io.Serializable;

public class VOEscolaridad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numInscripcion;
	private String nombreAsignatura;
	private int anioLectivo;
	private int calificacion;

	public VOEscolaridad(int num, String nom, int anio, int calif) {
		this.numInscripcion = num;
		this.nombreAsignatura = nom;
		this.anioLectivo = anio;
		this.calificacion = calif;
	}

	public int getNumInscripcion() {
		return numInscripcion;
	}

	public void setNumInscripcion(int numInscripcion) {
		this.numInscripcion = numInscripcion;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public int getAnioLectivo() {
		return anioLectivo;
	}

	public void setAnioLectivo(int anioLectivo) {
		this.anioLectivo = anioLectivo;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}

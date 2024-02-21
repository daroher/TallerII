package sistema.logica.inscripcion;

import java.io.Serializable;

import sistema.logica.asignatura.Asignatura;

public class Inscripcion implements Serializable{

	int numeroInscripcion;
	int anioLectivo;
	float montoBase;
	int calificacion;
	Asignatura asignatura;

	public Inscripcion(int anioLectivo, float montoBase, Asignatura asignatura) {
		this.numeroInscripcion = -1;
		this.anioLectivo = anioLectivo;
		this.montoBase = montoBase;
		this.calificacion = 0;
		this.asignatura = asignatura;
	}
	
	public int getNumeroInscripcion() {
		return numeroInscripcion;
	}

	public void setNumeroInscripcion(int numeroInscripcion) {
		this.numeroInscripcion = numeroInscripcion;
	}

	public int getAnioLectivo() {
		return anioLectivo;
	}

	public void setAnioLectivo(int anioLectivo) {
		this.anioLectivo = anioLectivo;
	}

	public float getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(float montoBase) {
		this.montoBase = montoBase;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}	
}

package sistema.logica.inscripcion;

import sistema.logica.asignatura.Asignatura;

public class Inscripcion {

	int numeroInscripcion;
	int anioLectivo;
	int montoBase;
	int calificacion;
	Asignatura asignatura;

	public Inscripcion() {
		super();
	}

	public Inscripcion(int numeroInscripcion, int anioLectivo, int montoBase, int calificacion, Asignatura asignatura) {
		super();
		this.numeroInscripcion = numeroInscripcion;
		this.anioLectivo = anioLectivo;
		this.montoBase = montoBase;
		this.calificacion = calificacion;
		this.asignatura = asignatura;
	}

	public void registrarResultado(int nota) {
		// TODO: falta implementar
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

	public int getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(int montoBase) {
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

package sistema.valueobjects;

import java.io.Serializable;

public class VORegistrarResultado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cedula;
	private int nota;
	private int numInscripcion;

	public VORegistrarResultado(int ced, int nota, int numInsc) {
		this.cedula = ced;
		this.nota = nota;
		this.numInscripcion = numInsc;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getNumInscripcion() {
		return numInscripcion;
	}

	public void setNumInscripcion(int numInscripcion) {
		this.numInscripcion = numInscripcion;
	}
}

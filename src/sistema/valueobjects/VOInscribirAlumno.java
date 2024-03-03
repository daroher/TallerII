package sistema.valueobjects;

import java.io.Serializable;

public class VOInscribirAlumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private int cedula;
	private int anioLec;
	private float monto;
	
	public VOInscribirAlumno(String codigo, int cedula, int anioLec, float monto) {
		
		this.codigo = codigo;
		this.cedula = cedula;
		this.anioLec = anioLec;
		this.monto = monto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getAnioLec() {
		return anioLec;
	}

	public void setAnioLec(int anioLec) {
		this.anioLec = anioLec;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

}

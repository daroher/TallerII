package sistema.valueobjects;

import java.io.Serializable;

public class VOAsignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;	
	private String descripcion;		
	
	
	public VOAsignatura (String codigo, String nombre, String descripcion) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;		
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





}
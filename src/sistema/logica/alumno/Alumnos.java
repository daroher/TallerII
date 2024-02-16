package sistema.logica.alumno;

import java.util.TreeMap;

import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOAlumno;

public class Alumnos {
	
	private TreeMap<Integer, Alumno> abbAlumnos;
	
	public Alumnos() {
		
	}

	public boolean member(String ced) {
		return true;
	}
	
	public void insert(Alumno alumno) {
		
	}
	
	public Alumno find(String ced) {
		return null;
	}
	
	public boolean empty() {
		return true;
	}
	
	public void registrarAlumno(Alumno alumno) {
		
	}
	
	public VOAlumno[] listarAlumnos() {
		return null;
	}
	
	public VOAlumno listarUnicoAlumno(int ced) {
		return null;
	}
	
	public VOEscolaridad[] consultarEscolaridad(int ced, TipoListado modoListado) {
		return null;
	}
	
	public VOEgresados[] listarEgresados(TipoListado modoListado) {
		return null;
	}
}

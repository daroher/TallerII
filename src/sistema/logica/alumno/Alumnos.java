package sistema.logica.alumno;

import java.util.TreeMap;

import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOAlumno;

public class Alumnos {
	
	private TreeMap<Integer, Alumno> abbAlumnos;
	
	public Alumnos() {
		abbAlumnos = new TreeMap<Integer, Alumno>();
	}

	public boolean member(int ced) {
		return abbAlumnos.containsKey(ced);
	}
	
	public void insert(Alumno alumno) {
		abbAlumnos.put(alumno.getCedula(), alumno);
	}
	
	public Alumno find(int ced) {
		return abbAlumnos.get(ced);
	}
	
	public boolean empty() {
		return abbAlumnos.size() == 0;
	}
	
	//TODO: Muy probable que no vaya esto, se resuelve directamente con la primitiva de insert.
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
	
	public VOEgresado[] listarEgresados(TipoListado modoListado) {
		return null;
	}
}

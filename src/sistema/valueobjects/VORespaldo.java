package sistema.valueobjects;

import java.util.ArrayList;
import java.util.TreeMap;

import sistema.logica.alumno.Alumno;
import sistema.logica.asignatura.Asignatura;

public class VORespaldo {
	
	private TreeMap<Integer, Alumno> respaldoAlumnos;
	private ArrayList<Asignatura> respaldoAsignaturas;
	
	public VORespaldo() {
		
	}

	public TreeMap<Integer, Alumno> getRespaldoAlumnos() {
		return respaldoAlumnos;
	}

	public void setRespaldoAlumnos(TreeMap<Integer, Alumno> respaldoAlumnos) {
		this.respaldoAlumnos = respaldoAlumnos;
	}

	public ArrayList<Asignatura> getRespaldoAsignaturas() {
		return respaldoAsignaturas;
	}

	public void setRespaldoAsignaturas(ArrayList<Asignatura> respaldoAsignaturas) {
		this.respaldoAsignaturas = respaldoAsignaturas;
	}
}

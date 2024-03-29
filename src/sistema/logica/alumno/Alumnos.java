package sistema.logica.alumno;

import java.util.ArrayList;
import java.util.TreeMap;

import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOEgresadoCompleto;
import sistema.valueobjects.VOEscolaridad;

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
	
	public VOAlumno[] listarAlumnos(String apellido) {
		ArrayList<VOAlumno> voAlumnos = new ArrayList<VOAlumno>();
		
		abbAlumnos.forEach((k,v) -> {
			if(v.getApellido().startsWith(apellido)) {
				TipoAlumno tipoAlumno = v instanceof Becado ? TipoAlumno.BECADO : TipoAlumno.NORMAL; 
				VOAlumno voAlumno = new VOAlumno(v.getCedula(), v.getNombre(), v.getApellido(), tipoAlumno);
				
				voAlumnos.add(voAlumno);
			}
		});
		
		return voAlumnos.toArray(new VOAlumno[voAlumnos.size()]);
	}
	
	public VOAlumnoCompleto listarUnicoAlumno(int ced) {
		Alumno alumno = this.find(ced);
		TipoAlumno tipoAlumno = alumno instanceof Becado ? TipoAlumno.BECADO : TipoAlumno.NORMAL;
		int porcentajeBeca = alumno instanceof Becado ? ((Becado)alumno).getPorcentajeBeca() : 0;
		String razonBeca = alumno instanceof Becado ? ((Becado)alumno).getRazonBeca() : null;
		
		return new VOAlumnoCompleto(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), tipoAlumno, alumno.getDomicilio(), alumno.getTelefono(), porcentajeBeca, razonBeca, alumno.getCantAsignaturasAprobadas());
	}
	
	public VOEscolaridad[] consultarEscolaridad(int ced, TipoListado modoListado) {
		return null;
	}
	
	public VOEgresado[] listarEgresados(TipoListado modoListado) {
		ArrayList<VOEgresado> voEgresados = new ArrayList<VOEgresado>();

		switch (modoListado) {
		case PARCIAL: {
			abbAlumnos.forEach((k, v) -> {
				if (v.getCantAsignaturasAprobadas() == 10) {
					VOEgresado egresado = new VOEgresado(v.getCedula(), v.getNombre(), v.getApellido());
					voEgresados.add(egresado);
				}
			});
		}
			break;
		case COMPLETO: {
			abbAlumnos.forEach((k, v) -> {
				if (v.getCantAsignaturasAprobadas() == 10) {
					VOEgresadoCompleto egresado = new VOEgresadoCompleto(v.getCedula(), v.getNombre(), v.getApellido(), v.getInscripciones().promedioTotal(), v.getInscripciones().promedioAprobadas());
					voEgresados.add(egresado);
				}
			});
		}
			break;
		}

		return voEgresados.toArray(new VOEgresado[voEgresados.size()]);
	}

	public TreeMap<Integer, Alumno> getAbbAlumnos() {
		return abbAlumnos;
	}

	public void setAbbAlumnos(TreeMap<Integer, Alumno> abbAlumnos) {
		this.abbAlumnos = abbAlumnos;
	}
}

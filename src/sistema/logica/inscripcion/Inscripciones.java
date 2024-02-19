package sistema.logica.inscripcion;

import java.util.LinkedList;

import sistema.valueobjects.VOMontoRecaudado;

public class Inscripciones {

	LinkedList<Inscripcion> inscripciones;

	public Inscripciones() {
		this.inscripciones = new LinkedList<Inscripcion>();
	}

	public boolean member(int numInscripcion) {
		return inscripciones.get(numInscripcion - 1) != null;
	}
	
	public void insert(Inscripcion inscripcion) {
		inscripcion.setNumeroInscripcion(largo() + 1);
		inscripciones.add(inscripcion);
	}
	
	public Inscripcion find(int numInscripcion) {
		return inscripciones.get(numInscripcion - 1);
	}
	
	public boolean empty() {
		return inscripciones.size() == 0;
	}
	
	public int largo() {
		return inscripciones.size();
	}
	
	public Inscripcion getUltimaInscripcion() {
		return inscripciones.getLast();
	}
	
	public float calcularMontoRecaudado(int anioLectivoDado) {
		float total = 0;
		int anioLectivoIteracion = anioLectivoDado;
		int index = 0;
		
		while (this.inscripciones.get(index) != null && anioLectivoIteracion <= anioLectivoDado) {
			Inscripcion inscripcionIterada = this.inscripciones.get(index);
			
			if (inscripcionIterada.getAnioLectivo() == anioLectivoDado) {
				total = total + (inscripcionIterada.getMontoBase() * 9);
			}
			
			anioLectivoIteracion = inscripcionIterada.getAnioLectivo();
			index++;
		}
	
		return total;
	}
	
	public boolean estaLaAsignaturaAprobada(String codigo) {
		for (Inscripcion inscripcion : inscripciones) {
			if(codigo.equals(inscripcion.getAsignatura().getCodigo()) && inscripcion.getCalificacion() >= 6) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean estaLaAsignaturaEnCurso(String codigo) {
		for (Inscripcion inscripcion : inscripciones) {
			if(codigo.equals(inscripcion.getAsignatura().getCodigo()) && inscripcion.getCalificacion() == 0) {
				return true;
			}
		}
		
		return false;
	}
}

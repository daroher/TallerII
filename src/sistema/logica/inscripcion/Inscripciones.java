package sistema.logica.inscripcion;

import java.util.LinkedList;

import sistema.logica.asignatura.Asignatura;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOEscolaridad;
import sistema.valueobjects.VOEscolaridadCompleta;
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
		
		while ((index < this.inscripciones.size()) && (anioLectivoIteracion <= anioLectivoDado)) {
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
	
	public VOEscolaridad[] listarInscripcionesModoParcial() {
		VOEscolaridad[] voEscolaridad = new VOEscolaridad[this.inscripciones.size()];
		
		for (int i = 0; i < voEscolaridad.length; i++) {
			Inscripcion inscripcionIterada = this.inscripciones.get(i);
			
			if (inscripcionIterada.getCalificacion() > 0) {
				voEscolaridad[i] = new VOEscolaridad(inscripcionIterada.getNumeroInscripcion(), inscripcionIterada.getAsignatura().getNombre(), inscripcionIterada.getAnioLectivo(), inscripcionIterada.getCalificacion());
			}
		}
		
		return voEscolaridad;
	}
	
	public VOEscolaridadCompleta[] listarInscripcionesModoCompleto() {
		VOEscolaridadCompleta[] voEscolaridad = new VOEscolaridadCompleta[this.inscripciones.size()];
		
		for (int i = 0; i < voEscolaridad.length; i++) {
			Inscripcion inscripcionIterada = this.inscripciones.get(i);
			
			voEscolaridad[i] = new VOEscolaridadCompleta(inscripcionIterada.getNumeroInscripcion(), inscripcionIterada.getAsignatura().getNombre(), inscripcionIterada.getAnioLectivo(), inscripcionIterada.getCalificacion(), inscripcionIterada.getMontoBase());
		}
		
		return voEscolaridad;
	}
}
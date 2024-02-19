package sistema.logica.inscripcion;

import java.util.LinkedList;

public class Inscripciones {

	LinkedList<Inscripcion> inscripciones;

	public Inscripciones() {
		super();
	}

	public Inscripciones(LinkedList<Inscripcion> inscripciones) {
		super();
		this.inscripciones = inscripciones;
	}

	public boolean member(int numInscripcion) {
		//resto 1 porque las inscripciones arrancan en 1 y los indices en 0
		return inscripciones.get(numInscripcion - 1) != null ? true : false;
	}
	
	public void insert(Inscripcion inscripcion) {
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
	
	public float calcularMontoRecaudado(int ced, int anioLectivo) {
		// TODO: falta implementar
		return 0;
	}


	public LinkedList<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(LinkedList<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}


}

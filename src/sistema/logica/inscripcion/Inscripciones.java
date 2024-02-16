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

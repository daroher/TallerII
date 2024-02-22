package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOListarUnicoAlumno;

public class R5Test {

	public void test(CapaLogica capaLogica) {
		VOListarUnicoAlumno voListarUnicoAlumno = null;
		VOAlumnoCompleto alumnoCompleto = null;
		// consulto uno normal
		voListarUnicoAlumno = new VOListarUnicoAlumno(12223334);
		try {
			alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
			System.out.println("Listado de alumno normal OK");
		} catch (Exception e) {
			System.out.println("Error listando alumno normal");
		}

		// consulto uno becado
		try {
			voListarUnicoAlumno = new VOListarUnicoAlumno(12223335);
			alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
			System.out.println("Listado de alumno becado OK");
		} catch (Exception e) {
			System.out.println("Error listando alumno becado");
		}

		// consulto uno que no exista
		try {
			voListarUnicoAlumno = new VOListarUnicoAlumno(99999999);
			alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
			System.out.println("Error, devolvio datos de una cedula inexistente");
		} catch (Exception e) {
			System.out.println("Validacion de listado de alumno inexistente OK");
		}

		// prueba de coleccion vacia
		try {
			// me creo un objeto de capa logica vacio
			CapaLogica capaLogicavacia = new CapaLogica();
			voListarUnicoAlumno = new VOListarUnicoAlumno(12223334);
			alumnoCompleto = capaLogicavacia.listarUnicoAlumno(voListarUnicoAlumno);
			System.out.println("Error en validacion de coleccion de alumnos vacia");
		} catch (Exception e) {
			System.out.println("Validacion de coleccion de alumnos vacia OK");
		}
	}
}

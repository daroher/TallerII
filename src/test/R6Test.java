package test;

import sistema.logica.Fachada;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VORegistrarResultado;

public class R6Test {

	public void test(Fachada capaLogica) {

		VOInscribirAlumno voInscribirAlumno;
		VORegistrarResultado voRegistrarResultado;
		// agrego inscripcion al alumno normal
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Inscripcion de alumno a asignatura OK");
		} catch (Exception e) {
			System.out.println("Error inscribiendo alumno a asignatura");
		}

		// prueba de inscripcion a materia ya cursando
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Error validando inscripcion a asignatura aun en curso");
		} catch (Exception e) {
			System.out.println("Validacion de inscripcion a asignatura aun en curso OK");
		}
		
		// prueba de asignatura inexistente
		voInscribirAlumno = new VOInscribirAlumno("asigNo", 12223335, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Error validando asignatura inexistente");
		} catch (Exception e) {
			System.out.println("Validacion de asignatura inexistente OK");
		}

		// prueba de alumno inexistente
		voInscribirAlumno = new VOInscribirAlumno("asig1", 99999999, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Error validando alumno inexistente");
		} catch (Exception e) {
			System.out.println("Validacion de alumno inexistente OK");
		}

		// prueba que el año lectivo no sea menor al de la ultima inscripcion
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 1900, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Error validando anio lectivo");
		} catch (Exception e) {
			System.out.println("Validacion de anio lectivo OK");
		}

		// prueba de inscripcion a materia ya aprobada
		voRegistrarResultado = new VORegistrarResultado(12223334, 6, 1);
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 1900, 10000);
		try {

			capaLogica.registrarResultado(voRegistrarResultado);
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			System.out.println("Error validando inscripcion a asignatura aprobada");
		} catch (Exception e) {
			System.out.println("Validacion de inscripcion a asignatura aprobada OK");
		}

	}

}

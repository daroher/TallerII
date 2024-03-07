package test;

import sistema.logica.Fachada;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VORegistrarResultado;

public class R7Test {

	public void test(Fachada capaLogica) {

		VORegistrarResultado voRegistrarResultado;
		VOInscribirAlumno voInscribirAlumno;

		// inscribo a asignaturas de prueba
		try {
			voInscribirAlumno = new VOInscribirAlumno("asig2", 12223334, 2024, 20000);
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			voInscribirAlumno = new VOInscribirAlumno("asig3", 12223334, 2024, 30000);
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		} catch (Exception e) {
			System.out.println("Error inscribiendo alumno a asignaturas de prueba");
		}

		// prueba de registrar resultado aprobado
		voRegistrarResultado = new VORegistrarResultado(12223334, 6, 2);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
			System.out.println("Registro de resultado aprobado OK");
		} catch (Exception e) {
			System.out.println("Error registrando resultado aprobado");
		}

		// prueba de registrar resultado no aprobado
		voRegistrarResultado = new VORegistrarResultado(12223334, 2, 3);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
			System.out.println("Registro de resultado NO aprobado OK");
		} catch (Exception e) {
			System.out.println("Error registrando resultado NO aprobado");
		}

		// prueba de alumno inexistente
		voRegistrarResultado = new VORegistrarResultado(9999999, 12, 1);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
			System.out.println("Error validando registro en alumno inexistente");
		} catch (Exception e) {
			System.out.println("validacion de registro en alumno inexistente OK");
		}

		// prueba de inscripcion inexistente
		voRegistrarResultado = new VORegistrarResultado(12223334, 12, 6);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
			System.out.println("Error validando inscripcion inexistente");
		} catch (Exception e) {
			System.out.println("validacion de inscripcion inexistente OK");
		}

		// prueba de inscripcion en materia ya aprobada
		voRegistrarResultado = new VORegistrarResultado(12223334, 12, 1);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
			System.out.println("Error validando inscripcion en materia aprobada");
		} catch (Exception e) {
			System.out.println("validacion de inscripcion en materia aprobada OK");
		}
	}

}

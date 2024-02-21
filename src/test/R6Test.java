package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOInscribirAlumno;

public class R6Test {

	public void test(CapaLogica capaLogica) {
		
		VOInscribirAlumno voInscribirAlumno;
		//agrego inscripcion al alumno normal
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//agrego inscripcion a alumno becado
		voInscribirAlumno = new VOInscribirAlumno("asig1", 12223335, 2024, 10000);
		try {
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

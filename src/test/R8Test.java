package test;

import sistema.logica.Fachada;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOMontoRecaudado;

public class R8Test {

	public void test(Fachada capaLogica) {

		VOCalcularMontoRecaudado voCalcularMontoRecaudado;
		VOMontoRecaudado voMontoRecaudado;
		VOInscribirAlumno voInscribirAlumno;
		
		//inscribo un becado a algunas asignaturas
		try {
			voInscribirAlumno = new VOInscribirAlumno("asig1", 12223335, 2024, 10000);
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
			voInscribirAlumno = new VOInscribirAlumno("asig2", 12223335, 2024, 20000);
			capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		} catch (Exception e) {
			System.out.println("Error inscribiendo alumno becado a asignaturas de prueba");
		}
		
		try {
			// calculo monto de normal
			voCalcularMontoRecaudado = new VOCalcularMontoRecaudado(12223334, 2024);
			voMontoRecaudado = capaLogica.calcularMontoRecaudado(voCalcularMontoRecaudado);
			System.out.println("Monto recaudado de cedula " + voCalcularMontoRecaudado.getCedula() + ": " + voMontoRecaudado.getMontoRecaudado());

			// calculo monto de becado
			voCalcularMontoRecaudado = new VOCalcularMontoRecaudado(12223335, 2024);
			voMontoRecaudado = capaLogica.calcularMontoRecaudado(voCalcularMontoRecaudado);
			System.out.println("Monto recaudado de cedula " + voCalcularMontoRecaudado.getCedula() + ": " + voMontoRecaudado.getMontoRecaudado());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

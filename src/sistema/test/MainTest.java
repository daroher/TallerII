package sistema.test;

import sistema.logica.CapaLogica;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOInscribirAlumno;

public class MainTest {

	public static void main(String[] args) {

		CapaLogica capaLogica = new CapaLogica();

		// prueba de registrar Alumno
		VOAlumnoRegistro voAlumnoRegistro = new VOAlumnoRegistro(12223334, "nombre", "apellido", TipoAlumno.NORMAL, "domicilio", "099111222", 0, null);
		capaLogica.registrarAlumno(voAlumnoRegistro);

		//prueba de calcular monto
		VOCalcularMontoRecaudado voCalcularMontoRecaudado = new VOCalcularMontoRecaudado(12223334, 2024);
		capaLogica.calcularMontoRecaudado(voCalcularMontoRecaudado);
		
		//prueba de inscribir alumno en asignatura
		VOInscribirAlumno voInscribirAlumno = new VOInscribirAlumno("codigo", 12223334, 2024, 10000);
		capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		
		//TODO: esto va a dar error hasta que se solucione lo del voRespaldo
		capaLogica.respaldarSistema();
		capaLogica.recuperarSistema();
	}

}

package test;

import sistema.logica.Fachada;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;

public class R3Test {

	public void test(Fachada capaLogica) {
		VOAlumnoRegistro voAlumnoRegistro = null;

		// prueba de registro de un alumno Normal
		try {
			voAlumnoRegistro = new VOAlumnoRegistro(12223334, "nombreNormal", "apellidoNormal", TipoAlumno.NORMAL, "domicilioNornmal", "099111222", 0, null);
			capaLogica.registrarAlumno(voAlumnoRegistro);
			System.out.println("Registro de nuevo alumno normnal OK");
		} catch (Exception e) {
			System.out.println("Error registrando alumno normal");
		}
		
		// prueba de registro de un alumno Normal
		try {
			voAlumnoRegistro = new VOAlumnoRegistro(12223335, "nombreBecado", "apellidoBecado", TipoAlumno.BECADO, "domicilioBecado", "099111223", 10, "Beca de 10%");
			capaLogica.registrarAlumno(voAlumnoRegistro);
			System.out.println("Registro de nuevo alumno becado OK");
		} catch (Exception e) {
			System.out.println("Error registrando alumno becado");
		}
		

		// prueba de validacion de cedula repetida
		try {
			//se podia reutilizar voAlumnoRegistro, creo otro para claridad del codigo
			voAlumnoRegistro = new VOAlumnoRegistro(12223334, "nombreNorma2", "apellidoNorma3", TipoAlumno.NORMAL, "domicilioNornma4", "099111224", 0, null);
			capaLogica.registrarAlumno(voAlumnoRegistro);
			System.out.println("Error validando cedula repetida");
		} catch (Exception e) {
			System.out.println("Validacion de cedula repetida OK");
		}
	}

}

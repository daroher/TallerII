package test;

import sistema.logica.CapaLogica;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;

public class R3Test {

	public void test(CapaLogica capaLogica) {
		VOAlumnoRegistro voAlumnoRegistro = new VOAlumnoRegistro(12223334, "nombre", "apellido", TipoAlumno.NORMAL, "domicilio", "099111222", 0, null);
		try {
			capaLogica.registrarAlumno(voAlumnoRegistro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

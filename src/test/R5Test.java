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

			System.out.println("Nombre Alumno: " + alumnoCompleto.getNombre() + ", Tipo alumno: " + alumnoCompleto.getTipoAlumno().name());

			// consulto uno becado
			voListarUnicoAlumno = new VOListarUnicoAlumno(12223335);
			alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nombre Alumno: " + alumnoCompleto.getNombre() + ", Tipo alumno: " + alumnoCompleto.getTipoAlumno().name() + ", porcentaje beca: "
				+ alumnoCompleto.getPorcentajeBeca() + ", razon: " + alumnoCompleto.getRazonBeca());
	}

}

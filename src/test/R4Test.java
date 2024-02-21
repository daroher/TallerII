package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class R4Test {

	public void test(CapaLogica capaLogica) {
		VOListarAlumnos voListarAlumnos = new VOListarAlumnos("ape");
		VOAlumno[] listaAlumnos = null;
		try {
			listaAlumnos = capaLogica.listarAlumnos(voListarAlumnos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("La lista tiene " + listaAlumnos.length + " alumnos");
		for (VOAlumno vo : listaAlumnos) {
			System.out.println(vo.getApellido());
		}
	}

}

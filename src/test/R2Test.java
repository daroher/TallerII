package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOAsignatura;

public class R2Test {
	
	public void test(CapaLogica capaLogica) {
		VOAsignatura[] listaAsignaturas = null;
		try {
			listaAsignaturas = capaLogica.listarAsignaturas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("La lista tiene " + listaAsignaturas.length +" asignaturas");
		for (VOAsignatura vo : listaAsignaturas) {
			System.out.println(vo.getNombre());
		}
	}

}

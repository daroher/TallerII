package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOAsignatura;

public class R1Test {
	
	public void test(CapaLogica capaLogica) {
		VOAsignatura voAsignatura = new VOAsignatura("asig1", "asignatura 1", "asignatura de prueba 1");
		try {
			capaLogica.registrarAsignatura(voAsignatura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

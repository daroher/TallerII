package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VORegistrarResultado;

public class R7Test {

	public void test(CapaLogica capaLogica) {

		VORegistrarResultado voRegistrarResultado = new VORegistrarResultado(12223334, 6, 1);
		try {
			capaLogica.registrarResultado(voRegistrarResultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

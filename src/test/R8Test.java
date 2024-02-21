package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOMontoRecaudado;

public class R8Test {

	public void test(CapaLogica capaLogica) {

		VOCalcularMontoRecaudado voCalcularMontoRecaudado;
		VOMontoRecaudado voMontoRecaudado;
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

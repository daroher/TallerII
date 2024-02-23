package test;

import sistema.logica.CapaLogica;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOListarEgresados;

public class R10Test {

	public void test(CapaLogica capaLogica) {

		VOListarEgresados voListarEgresados = new VOListarEgresados(TipoListado.PARCIAL);
		VOEgresado[] listaEgresados = null;
		
		try {
			listaEgresados = capaLogica.listarEgresados(voListarEgresados);
			for (VOEgresado voEgresado : listaEgresados) {
				System.out.println(voEgresado.getApellido());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

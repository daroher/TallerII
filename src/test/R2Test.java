package test;

import sistema.logica.Fachada;
import sistema.valueobjects.VOAsignatura;

public class R2Test {

	public void test(Fachada capaLogica) {

		// prueba de listar asignaturas
		VOAsignatura[] listaAsignaturas = null;
		try {
			listaAsignaturas = capaLogica.listarAsignaturas();
			// se que tiene 10 porque las inserte en el test de R1
			if (listaAsignaturas.length != 10) {
				System.out.println("Error listando asignaturas, no trajo 10 asignaturas");
			}
			System.out.println("Listando de asignaturas OK");
		} catch (Exception e) {
			System.out.println("Error listando asignaturas");
		}

		//prueba de coleccion vacia
		try {
			//me creo un objeto de capa logica vacio
			Fachada capaLogicavacia = new Fachada();
			capaLogicavacia.listarAsignaturas();
			System.out.println("Error en validacion de coleccion de asignaturas vacia");
		} catch (Exception e) {
			System.out.println("Validacion de coleccion de asignaturas vacia OK");
		}
	}

}

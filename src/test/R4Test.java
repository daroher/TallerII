package test;

import sistema.logica.Fachada;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class R4Test {

	public void test(Fachada capaLogica) {

		// prueba listar alumnos
		VOListarAlumnos voListarAlumnos = new VOListarAlumnos("ape");
		VOAlumno[] listaAlumnos = null;
		try {
			listaAlumnos = capaLogica.listarAlumnos(voListarAlumnos);
			// se que tiene 2 porque las inserte en el test de R3
			if (listaAlumnos.length != 2) {
				System.out.println("Error listando alumnos, no trajo 2 alumnos");
			}
			System.out.println("Listado de alumnos OK");
		} catch (Exception e) {
			System.out.println("Error listando alumnos");
		}

		// prueba apellido no existente
		voListarAlumnos = new VOListarAlumnos("esteNoExiste");
		try {
			listaAlumnos = capaLogica.listarAlumnos(voListarAlumnos);
			if (listaAlumnos.length != 0) {
				System.out.println("Error listado alumnos por apellido que no existe, trajo alumnos");
			}
			System.out.println("Listado por apellido que no existe OK");
		} catch (Exception e) {
			System.out.println("Error listado alumnos por apellido que no existe");
		}

		// prueba de coleccion vacia
		try {
			// me creo un objeto de capa logica vacio
			Fachada capaLogicavacia = new Fachada();
			capaLogicavacia.listarAlumnos(voListarAlumnos);
			System.out.println("Error en validacion de coleccion de alumnos vacia");
		} catch (Exception e) {
			System.out.println("Validacion de coleccion de alumnos vacias OK");
		}

	}

}

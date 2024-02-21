package test;

import sistema.logica.CapaLogica;
import sistema.valueobjects.VOAsignatura;

public class R1Test {

	public void test(CapaLogica capaLogica) {
		VOAsignatura voAsignatura = null;

		// prueba de insertar una nueva asignatura
		try {
			voAsignatura = new VOAsignatura("asig1", "asignatura 1", "asignatura de prueba 1");
			capaLogica.registrarAsignatura(voAsignatura);
			System.out.println("registro de nueva asignatura OK");
		} catch (Exception e) {
			System.out.println("Error en registro de nueva asignatura");
		}

		// prueba de control de codigo de asignatura
		try {
			// intento insertar otra con mismo codigo
			voAsignatura = new VOAsignatura("asig1", "asignatura 2", "asignatura de prueba 2");
			capaLogica.registrarAsignatura(voAsignatura);
			System.out.println("Error en validacion de codigo de asignatura repetido");
		} catch (Exception e) {
			System.out.println("Validacion de codigo de asignatura repetido OK");
		}

		// prueba de collecion de asignaturas llena
		// inserto hasta 10
		try {
			voAsignatura = new VOAsignatura("asig2", "asignatura 2", "asignatura de prueba 2");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig3", "asignatura 3", "asignatura de prueba 3");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig4", "asignatura 4", "asignatura de prueba 4");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig5", "asignatura 5", "asignatura de prueba 5");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig6", "asignatura 6", "asignatura de prueba 6");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig7", "asignatura 7", "asignatura de prueba 7");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig8", "asignatura 8", "asignatura de prueba 8");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig9", "asignatura 9", "asignatura de prueba 9");
			capaLogica.registrarAsignatura(voAsignatura);
			voAsignatura = new VOAsignatura("asig10", "asignatura 10", "asignatura de prueba 10");
			capaLogica.registrarAsignatura(voAsignatura);
			System.out.println("Inserccion hasta 10 asignaturas OK");
		} catch (Exception e) {
			System.out.println("Error insertando hasta 10 asignaturas");
		}

		// esta es la 11, deberia dar error
		try {
			voAsignatura = new VOAsignatura("asig11", "asignatura 11", "asignatura de prueba 11");
			capaLogica.registrarAsignatura(voAsignatura);
			System.out.println("Error, me permitio insertar 11 asignaturas");
		} catch (Exception e) {
			System.out.println("Validacion de no mas de 10 asignaturas OK");
		}

	}

}

package test;

import sistema.logica.Fachada;

public class MainTest {

	public static void main(String[] args) throws Exception {

		// Pruebas de la capa logica *************************************

		Fachada capaLogica = new Fachada();

		// R1
		System.out.println("Inicio tests de R1");
		R1Test r1Test = new R1Test();
		r1Test.test(capaLogica);
		System.out.println("Fin Test de R1\n");

		// R2
		System.out.println("Inicio tests de R2");
		R2Test r2Test = new R2Test();
		r2Test.test(capaLogica);
		System.out.println("Fin Test de R2\n");

		// R3
		System.out.println("Inicio tests de R3");
		R3Test r3Test = new R3Test();
		r3Test.test(capaLogica);
		System.out.println("Fin Test de R3\n");

		// R4
		System.out.println("Inicio tests de R4");
		R4Test r4Test = new R4Test();
		r4Test.test(capaLogica);
		System.out.println("Fin Test de R4\n");
//		
		// R5
		System.out.println("Inicio tests de R5");
		R5Test r5Test = new R5Test();
		r5Test.test(capaLogica);
		System.out.println("Fin Test de R5\n");

		// R6
		System.out.println("Inicio tests de R6");
		R6Test r6Test = new R6Test();
		r6Test.test(capaLogica);
		System.out.println("Fin Test de R6\n");

		// R7
		System.out.println("Inicio tests de R7");
		R7Test r7Test = new R7Test();
		r7Test.test(capaLogica);
		System.out.println("Fin Test de R7\n");

		// R8
		System.out.println("Inicio tests de R8");
		R8Test r8Test = new R8Test();
		r8Test.test(capaLogica);
		System.out.println("Fin Test de R8\n");

		// R9
		System.out.println("Inicio tests de R9");
		R9Test r9Test = new R9Test();
		r9Test.test(capaLogica);
		System.out.println("Fin Test de R9\n");

		// R9
		System.out.println("Inicio tests de R10");
		R10Test r10Test = new R10Test();
		r10Test.test(capaLogica);
		System.out.println("Fin Test de R10\n");

		// R11
		System.out.println("Inicio tests de R11");
		capaLogica.respaldarSistema();
		System.out.println("Fin Test de R11\n");

		// R12
		System.out.println("Inicio tests de R12");
		capaLogica.recuperarSistema();
		System.out.println("Fin Test de R12\n");
		// ******************************************************************
	}

}

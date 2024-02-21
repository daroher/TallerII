package test;

import sistema.logica.CapaLogica;

public class MainTest {

	public static void main(String[] args) throws Exception {

		// Pruebas de la capa logica *************************************

		CapaLogica capaLogica = new CapaLogica();

		// R1
		R1Test r1Test = new R1Test();
		r1Test.test(capaLogica);
		System.out.println("R1 OK");

		// R2
		R2Test r2Test = new R2Test();
		r2Test.test(capaLogica);
		System.out.println("R2 OK");

		// R3
		R3Test r3Test = new R3Test();
		r3Test.test(capaLogica);
		System.out.println("R3 OK");

		// R4
		R4Test r4Test = new R4Test();
		r4Test.test(capaLogica);
		System.out.println("R4 OK");
//		
		// R5
		R5Test r5Test = new R5Test();
		r5Test.test(capaLogica);
		System.out.println("R5 OK");

		// R6
		R6Test r6Test = new R6Test();
		r6Test.test(capaLogica);
		System.out.println("R6 OK");

		// R6
		R7Test r7Test = new R7Test();
		r7Test.test(capaLogica);
		System.out.println("R7 OK");

		// R8
		R8Test r8Test = new R8Test();
		r8Test.test(capaLogica);
		System.out.println("R8 OK");

		// R11
		capaLogica.respaldarSistema();
		System.out.println("R11 OK");

		// R12
		capaLogica.recuperarSistema();
		System.out.println("R12 OK");
		// ******************************************************************
	}

}

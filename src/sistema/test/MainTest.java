package sistema.test;

import sistema.persistencia.Respaldo;
import sistema.valueobjects.VORespaldo;

public class MainTest {

	public static void main(String[] args) {
		VORespaldo vo = new VORespaldo();
		Respaldo res = new Respaldo();
		res.respaldarSistema(vo);
		
		VORespaldo vo2 = res.recuperarSistema();
		

	}

}

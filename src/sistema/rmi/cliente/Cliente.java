package sistema.rmi.cliente;

import java.rmi.Naming;

import sistema.rmi.servidor.IPruebaRMI;

public class Cliente {

	public static void main(String[] args) throws Exception {
		try {
			IPruebaRMI pruebaRMI = (IPruebaRMI) Naming.lookup("//localhost:1099/prueba");
			pruebaRMI.sumar(1500);
			pruebaRMI.restar(500);
			System.out.println(pruebaRMI.getTotal());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}

package sistema.rmi.cliente;

import java.rmi.Naming;

import sistema.logica.IFachada;
import sistema.utilidades.GetProperties;

public class Cliente {

	private static IFachada instancia;

	private Cliente() {

		try {
			String host = GetProperties.getInstancia().getString("ipServidor");
			String puerto = GetProperties.getInstancia().getString("puertoServidor");

			instancia = (IFachada) Naming.lookup("//" + host + ":" + puerto + "/logica");
		} catch (Exception e) {
			// TODO:crear excepcion de conexion al servidor
		}
	}

	public static IFachada conectar() {
		if (instancia == null) {
			instancia = new Cliente().instancia;
		}
		return instancia;
	}
}

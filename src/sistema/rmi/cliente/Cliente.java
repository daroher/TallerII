package sistema.rmi.cliente;

import java.rmi.Naming;

import sistema.excepciones.NoSePudoConectarServidorException;
import sistema.logica.IFachada;
import sistema.utilidades.GetProperties;

public class Cliente {

	private static IFachada instancia;

	private Cliente() throws Exception {

		try {
			String host = GetProperties.getInstancia().getString("ipServidor");
			String puerto = GetProperties.getInstancia().getString("puertoServidor");

			instancia = (IFachada) Naming.lookup("//" + host + ":" + puerto + "/logica");
		} catch (Exception e) {
			throw new NoSePudoConectarServidorException("Error conectando con el servidor");
		}
	}

	public static IFachada conectar() throws Exception {
		if (instancia == null) {
			instancia = new Cliente().instancia;
		}
		return instancia;
	}
}

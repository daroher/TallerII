package sistema.rmi.cliente;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import sistema.logica.IFachada;
import sistema.utilidades.GetProperties;

public class Cliente {

	private static IFachada instancia;

	private Cliente() {

		try {
			String host = GetProperties.getInstancia().getString("ipServidor");
			String puerto = GetProperties.getInstancia().getString("puertoServidor");

			instancia = (IFachada) Naming.lookup("//" + host + ":" + puerto + "/logica");
		} catch (NotBoundException e) {
			System.out.print(e.getMessage());
		} catch (AccessException e) {
			System.out.print(e.getMessage());
		} catch (RemoteException e) {
			System.out.print(e.getMessage());
		} catch (MalformedURLException e) {
			System.out.print(e.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static IFachada conectar() {
		if (instancia == null) {
			instancia = new Cliente().instancia;
		}
		return instancia;
	}
}

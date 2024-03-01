package sistema.rmi.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import sistema.logica.Fachada;
import sistema.utilidades.GetProperties;

public class Servidor {

	public static void main(String[] args) {
		try {
			String host = GetProperties.getInstancia().getString("ipServidor");
			String puerto = GetProperties.getInstancia().getString("puertoServidor");

			// Pongo a correr el rmiregistry y reservo el puerto para el objeto remoto.
			LocateRegistry.createRegistry(Integer.valueOf(puerto));

			// Instancio el objeto remoto a publicar.
			Fachada fachada = new Fachada();

			// Publico el objeto remoto en la direccion provista.
			System.out.println("Encendiendo servidor, espere...");
			Naming.rebind("//" + host + ":" + puerto + "/logica", fachada);
			System.out.println("Servidor encendido.");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

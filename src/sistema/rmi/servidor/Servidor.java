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
			
			// pongo a correr el rmiregistry
			LocateRegistry.createRegistry(Integer.valueOf(puerto));
			// instancio mi Objeto Remoto y lo publico
			Fachada fachada = new Fachada();
			System.out.println("Antes de publicarlo");
			Naming.rebind("//" + host + ":" + puerto + "/logica", fachada); 
			System.out.println("Luego de publicarlo");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

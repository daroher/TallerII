package sistema.rmi.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import sistema.logica.CapaLogica;

public class Servidor {

	public static void main(String[] args) {
		try { // pongo a correr el rmiregistry
			LocateRegistry.createRegistry(1099);
			// instancio mi Objeto Remoto y lo publico
			CapaLogica capaLogica = new CapaLogica();
			System.out.println("Antes de publicarlo");
			Naming.rebind("//localhost:1099/logica", capaLogica);
			System.out.println("Luego de publicarlo");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

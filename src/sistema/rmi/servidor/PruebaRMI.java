package sistema.rmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PruebaRMI extends UnicastRemoteObject implements IPruebaRMI {

	private int total;

	public PruebaRMI() throws RemoteException {
		total = 0;
	}

	@Override
	public void sumar(int cantidad) throws RemoteException {
		total = total + cantidad;

	}

	@Override
	public void restar(int cantidad) throws RemoteException {
		total = total - cantidad;

	}

	@Override
	public int getTotal() throws RemoteException {
		return total;
	}

}

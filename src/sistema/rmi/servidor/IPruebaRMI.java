package sistema.rmi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPruebaRMI extends Remote {

	public void sumar(int cantidad) throws RemoteException;

	public void restar(int cantidad) throws RemoteException;

	public int getTotal() throws RemoteException;

}

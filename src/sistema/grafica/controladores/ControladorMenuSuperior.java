package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;

public class ControladorMenuSuperior {

	private IFachada fachada;

	public ControladorMenuSuperior() throws Exception {
		// TODO:esta levantando la conexion cuando se instancia, deberia hacerlo solo en
		// los metodos de abajo, cuando la necesite
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void recuperarSistema() throws Exception {
		fachada.recuperarSistema();
	}

	public void respaldarSistema() throws Exception {
		fachada.respaldarSistema();
	}
}
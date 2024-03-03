package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;

public class ControladorMenuSuperior {

	private IFachada fachada;

	public ControladorMenuSuperior() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void recuperarSistema() throws Exception {
		fachada.recuperarSistema();
	}

	public void respaldarSistema() throws Exception {
		fachada.respaldarSistema();
	}
}
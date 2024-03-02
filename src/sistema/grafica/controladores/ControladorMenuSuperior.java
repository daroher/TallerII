package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;

public class ControladorMenuSuperior {

	private IFachada fachada;

	public ControladorMenuSuperior() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void recuperar() throws Exception {
		fachada.recuperarSistema();
	}
	
	public void respaldar() throws Exception {
		fachada.respaldarSistema();
	}

}

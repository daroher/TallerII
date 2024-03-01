package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAsignatura;

public class ControladorListadoAsignaturas {

	private IFachada fachada;

	public ControladorListadoAsignaturas() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAsignatura[] listarAsignaturas() throws Exception {
		return fachada.listarAsignaturas();		
	}

}
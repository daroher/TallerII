package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAsignatura;

public class ControladorRegistrarAsignatura {

	private IFachada fachada;

	public ControladorRegistrarAsignatura() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void registrarAsignatura(VOAsignatura vo) throws Exception {
		fachada.registrarAsignatura(vo);
	}

}

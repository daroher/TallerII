package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VORegistrarResultado;

public class ControladorRegistrarResultado {
	private IFachada fachada;

	public ControladorRegistrarResultado() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void registrarResultado(VORegistrarResultado vo) throws Exception {
		fachada.registrarResultado(vo);
	}
}
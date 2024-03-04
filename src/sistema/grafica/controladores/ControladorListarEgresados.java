package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOListarEgresados;

public class ControladorListarEgresados {

	private IFachada fachada;

	public ControladorListarEgresados() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOEgresado[] listarEgresados(VOListarEgresados vo) throws Exception {
		return fachada.listarEgresados(vo);
	}
}
package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOMontoRecaudado;

public class ControladorCalcularMontoRecaudado {
	private IFachada fachada;

	public ControladorCalcularMontoRecaudado() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOMontoRecaudado calcularMontoRecaudado(VOCalcularMontoRecaudado vo) throws Exception {
		return fachada.calcularMontoRecaudado(vo);
	}
}

package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOConsultarEscolaridad;
import sistema.valueobjects.VOEscolaridad;

public class ControladorConsultarEscolaridad {

	private IFachada fachada;

	public ControladorConsultarEscolaridad() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOEscolaridad[] consultarEscolaridad(VOConsultarEscolaridad vo) throws Exception {
		return fachada.consultarEscolaridad(vo);
	}
}
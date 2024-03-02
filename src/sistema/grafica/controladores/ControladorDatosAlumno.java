package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOListarUnicoAlumno;

public class ControladorDatosAlumno {

	private IFachada fachada;

	public ControladorDatosAlumno() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumnoCompleto buscarDatosAlumno(VOListarUnicoAlumno vo) throws Exception {
		return fachada.listarUnicoAlumno(vo);
	}
}

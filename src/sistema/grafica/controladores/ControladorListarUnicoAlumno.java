package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOListarUnicoAlumno;

public class ControladorListarUnicoAlumno {

	private IFachada fachada;

	public ControladorListarUnicoAlumno() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumnoCompleto listarUnicoAlumno(VOListarUnicoAlumno vo) throws Exception {
		return fachada.listarUnicoAlumno(vo);
	}
}
package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class ControladorListarAlumnos {

	private IFachada fachada;

	public ControladorListarAlumnos() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumno[] listarAlumnos(VOListarAlumnos vo) throws Exception {
		return fachada.listarAlumnos(vo);
	}
}

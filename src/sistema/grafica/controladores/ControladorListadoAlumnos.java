package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class ControladorListadoAlumnos {

	private IFachada fachada;

	public ControladorListadoAlumnos() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumno[] listarAsignaturas(VOListarAlumnos vo) throws Exception {
		return fachada.listarAlumnos(vo);
	}
}

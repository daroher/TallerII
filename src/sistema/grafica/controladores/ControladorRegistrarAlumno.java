package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumnoRegistro;

public class ControladorRegistrarAlumno {

	private IFachada fachada;

	public ControladorRegistrarAlumno() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void registrarAlumno(VOAlumnoRegistro vo) throws Exception {
		fachada.registrarAlumno(vo);
	}
}

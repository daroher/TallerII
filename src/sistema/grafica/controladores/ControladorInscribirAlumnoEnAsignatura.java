package sistema.grafica.controladores;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOInscribirAlumno;

public class ControladorInscribirAlumnoEnAsignatura {
	private IFachada fachada;

	public ControladorInscribirAlumnoEnAsignatura() {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno vo) throws Exception {
		fachada.inscribirAlumnoEnAsignatura(vo);
	}
}
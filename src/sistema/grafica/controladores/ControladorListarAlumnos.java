package sistema.grafica.controladores;

import sistema.excepciones.NoHayAlumnosException;
import sistema.excepciones.ValorInvalidoException;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class ControladorListarAlumnos {

	private IFachada fachada;

	public ControladorListarAlumnos() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumno[] listarAlumnos(String prefijo) throws Exception {
		camposValidos(prefijo);
		VOListarAlumnos vo = new VOListarAlumnos(prefijo);
		VOAlumno[] alumnos = fachada.listarAlumnos(vo);

		if (alumnos != null && alumnos.length == 0) {
			String msg = "No se encontraron alumnos con el apellido o prefijo ingresado.";
			throw new NoHayAlumnosException(msg);
		}

		return alumnos;

	}

	// valido los datos ingresador
	private void camposValidos(String prefijo) {
		if (prefijo.isEmpty()) {
			String msg = "El apellido o prefijo no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		}

	}
}

package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.grafica.componentes.FormularioListarUnicoAlumno;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOListarUnicoAlumno;

public class ControladorListarUnicoAlumno {

	private IFachada fachada;
	private FormularioListarUnicoAlumno panelFormulario;

	public ControladorListarUnicoAlumno() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumnoCompleto listarUnicoAlumno(String cedula) throws Exception {
		VOAlumnoCompleto alumno = null;
		camposValidos(cedula);
		VOListarUnicoAlumno vo = new VOListarUnicoAlumno(Integer.valueOf(cedula));
		alumno = fachada.listarUnicoAlumno(vo);

		return alumno;
	}

	// valido los datos ingresador
	private void camposValidos(String cedula) {

		if (cedula.isEmpty()) {
			String msg = "La cédula no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		}

	}
}
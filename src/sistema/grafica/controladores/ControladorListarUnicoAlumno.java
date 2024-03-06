package sistema.grafica.controladores;

import javax.swing.JOptionPane;

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

	public VOAlumnoCompleto listarUnicoAlumno(VOListarUnicoAlumno vo) throws Exception {
		VOAlumnoCompleto alumno = null;
		if (camposValidos(vo))
			alumno = fachada.listarUnicoAlumno(vo);

		return alumno;
	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos(VOListarUnicoAlumno vo) {
		boolean valido = true;

		if (vo.getCedula() == null) {
			String msg = "La cédula no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}
}
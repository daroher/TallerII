package sistema.grafica.controladores;

import javax.swing.JOptionPane;

import sistema.grafica.componentes.FormularioRegistrarAlumno;
import sistema.logica.IFachada;
import sistema.logica.alumno.TipoAlumno;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumnoRegistro;

public class ControladorRegistrarAlumno {

	private IFachada fachada;
	private FormularioRegistrarAlumno panelFormulario;

	public ControladorRegistrarAlumno() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void registrarAlumno(VOAlumnoRegistro vo) throws Exception {
		if(camposValidos(vo))
			fachada.registrarAlumno(vo);
	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos(VOAlumnoRegistro vo) {
		boolean valido = true;

		// TODO:psaar a Integer para poder ver si es null
		if (vo.getCedula() == 0) {
			String msg = "La cedula no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getNombre().isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getApellido().isEmpty()) {
			String msg = "El apellido no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getDomicilio().isEmpty()) {
			String msg = "El domicilio no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getTelefono().isEmpty()) {
			String msg = "El telefono no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getPorcentajeBeca() == 0 && vo.getTipoAlumno() == TipoAlumno.BECADO) {
			String msg = "El porcentaje de la beca no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getRazonBeca().isEmpty() && vo.getTipoAlumno() == TipoAlumno.BECADO) {
			String msg = "La razon de la beca no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}
}

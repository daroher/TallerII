package sistema.grafica.controladores;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAsignatura;

public class ControladorRegistrarAsignatura {

	private IFachada fachada;
	private JPanel panelFormulario;

	public ControladorRegistrarAsignatura() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public void registrarAsignatura(VOAsignatura vo) throws Exception {
		if(camposValidos(vo))
			fachada.registrarAsignatura(vo);
	}
	

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos(VOAsignatura vo) {
		boolean valido = true;

		if (vo.getCodigo().isEmpty()) {
			String msg = "El código no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getNombre().isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (vo.getDescripcion().isEmpty()) {
			String msg = "La descripción no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}
}

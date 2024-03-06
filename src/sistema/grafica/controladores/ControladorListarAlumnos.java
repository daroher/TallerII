package sistema.grafica.controladores;

import javax.swing.JOptionPane;

import sistema.grafica.componentes.FormularioListarAlumnos;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOListarAlumnos;

public class ControladorListarAlumnos {

	private IFachada fachada;
	private FormularioListarAlumnos panelFormulario;

	public ControladorListarAlumnos() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOAlumno[] listarAlumnos(VOListarAlumnos vo) throws Exception {
		VOAlumno[] alumnos = null;
		if(camposValidos(vo)) 
			alumnos = fachada.listarAlumnos(vo);
		
		if(alumnos != null && alumnos.length == 0) {
			String msg = "No se encontraron alumnos con el apellido o prefijo ingresado.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return alumnos;
		
		
	}
	
	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
		// boolean que indica si se debe seguir adelante con el registro
		private boolean camposValidos(VOListarAlumnos vo) {
			boolean valido = true;

			if (vo.getApellido().isEmpty()) {
				String msg = "El apellido o prefijo no puede ser vacío.";
				JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				valido = false;
			}

			return valido;
		}
}

package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.grafica.utilidades.Validador;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOAsignatura;

public class ControladorRegistrarAsignatura {

	private IFachada fachada;

	public ControladorRegistrarAsignatura() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public String registrarAsignatura(String codigo, String nombre, String descripcion) throws Exception {

		camposValidos(codigo, nombre, descripcion);
		VOAsignatura vo = new VOAsignatura(codigo, nombre, descripcion);
		fachada.registrarAsignatura(vo);
		String msg = "Se registró satisfactoriamente la Asignatura.";
		return msg;
	}

	// valido los datos ingresador
	private void camposValidos(String codigo, String nombre, String descripcion) {

		if (codigo.isEmpty()) {
			String msg = "El código no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		}else if (!Validador.validarAlfaNumerico(codigo)) {
			String msg = "El código debe ser alfanumérico.";
			throw new ValorInvalidoException(msg);
		}else if (nombre.isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (descripcion.isEmpty()) {
			String msg = "La descripción no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		}

	}
}

package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VORegistrarResultado;

public class ControladorRegistrarResultado {
	private IFachada fachada;

	public ControladorRegistrarResultado() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public String registrarResultado(String cedula, String nota, String numInscripcion) throws Exception {

		camposValidos(cedula, nota, numInscripcion);
		VORegistrarResultado vo = new VORegistrarResultado(Integer.parseInt(cedula), Integer.parseInt(nota), Integer.parseInt(numInscripcion));
		fachada.registrarResultado(vo);
		String msg = "La nota ha sido registrada exitosamente.";
		return msg;
	}

	// valido los datos ingresador
	private void camposValidos(String cedula, String nota, String numInscripcion) {

		if (cedula.isEmpty()) {
			String msg = "La cedula no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		} else if (nota.isEmpty()) {
			String msg = "La nota no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		} else if (numInscripcion.isEmpty()) {
			String msg = "El número de inscripción no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		}

	}
}
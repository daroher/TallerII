package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.grafica.utilidades.Validador;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOMontoRecaudado;

public class ControladorCalcularMontoRecaudado {
	private IFachada fachada;

	public ControladorCalcularMontoRecaudado() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOMontoRecaudado calcularMontoRecaudado(String cedula, String anioLectivo) throws Exception {
		camposValidos(cedula, anioLectivo);
		VOCalcularMontoRecaudado vo = new VOCalcularMontoRecaudado(Integer.parseInt(cedula), Integer.parseInt(anioLectivo));
		return fachada.calcularMontoRecaudado(vo);
	}
	
	// valido los datos ingresador
		private void camposValidos(String cedula, String anioLectivo) {

			if (cedula.isEmpty()) {
				String msg = "La cédula no puede ser vacía.";
				throw new ValorInvalidoException(msg);
			}else if (!Validador.validarNumerico(cedula)) {
				String msg = "La cédula debe ser numérica.";
				throw new ValorInvalidoException(msg);
			}else if (anioLectivo.isEmpty()) {
				String msg = "El año lectivo no puede ser vacío.";
				throw new ValorInvalidoException(msg);
			}else if (Validador.validarNumerico(anioLectivo)) {
				String msg = "El año lectivo debe ser numérico.";
				throw new ValorInvalidoException(msg);
			}

		}
}

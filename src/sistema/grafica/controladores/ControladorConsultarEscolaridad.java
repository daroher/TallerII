package sistema.grafica.controladores;

import sistema.excepciones.AlumnoSinInscripcionesException;
import sistema.excepciones.NoHayAlumnosException;
import sistema.excepciones.ValorInvalidoException;
import sistema.grafica.utilidades.Validador;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOConsultarEscolaridad;
import sistema.valueobjects.VOEscolaridad;

public class ControladorConsultarEscolaridad {

	private IFachada fachada;

	public ControladorConsultarEscolaridad() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOEscolaridad[] consultarEscolaridad(String cedula, TipoListado modoListado) throws Exception {
		camposValidos(cedula);
		VOConsultarEscolaridad vo = new VOConsultarEscolaridad(Integer.parseInt(cedula), modoListado);
		VOEscolaridad[] escolaridad = fachada.consultarEscolaridad(vo);

		if (escolaridad != null && escolaridad.length == 0) {
			//TODO:ver si aplica mensaje diferente segun modo de listado
			String msg = "El alumno no tiene inscripciones validas.";
			throw new AlumnoSinInscripcionesException(msg);
		}

		return escolaridad;
	}

	// valido los datos ingresador
	private void camposValidos(String cedula) {

		if (cedula.isEmpty()) {
			String msg = "La cédula no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		}else if (!Validador.validarNumerico(cedula)) {
			String msg = "La cédula debe ser numérica.";
			throw new ValorInvalidoException(msg);
		}

	}
}
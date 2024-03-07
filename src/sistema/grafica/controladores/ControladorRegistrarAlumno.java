package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.grafica.componentes.FormularioRegistrarAlumno;
import sistema.logica.IFachada;
import sistema.logica.alumno.TipoAlumno;
import sistema.rmi.cliente.Cliente;
import sistema.utilidades.Validador;
import sistema.valueobjects.VOAlumnoRegistro;

public class ControladorRegistrarAlumno {

	private IFachada fachada;
	private FormularioRegistrarAlumno panelFormulario;

	public ControladorRegistrarAlumno() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public String registrarAlumno(String cedula, String nombre, String apellido, TipoAlumno tipoAlumno, String domicilio, String telefono, String descuento,
			String razonBeca) throws Exception {
		camposValidos(cedula, nombre, apellido, tipoAlumno, domicilio, telefono, descuento, razonBeca);
		VOAlumnoRegistro vo;
		if (tipoAlumno == TipoAlumno.BECADO) {
			vo = new VOAlumnoRegistro(Integer.parseInt(cedula), nombre, apellido, tipoAlumno, domicilio, telefono, Integer.parseInt(descuento), razonBeca);
		} else {
			vo = new VOAlumnoRegistro(Integer.parseInt(cedula), nombre, apellido, tipoAlumno, domicilio, telefono, 0, null);
		}

		fachada.registrarAlumno(vo);
		String msg = "Se registró satisfactoriamente el Alumno.";
		return msg;
	}

	// valido los datos ingresador
	private void camposValidos(String cedula, String nombre, String apellido, TipoAlumno tipoAlumno, String domicilio, String telefono, String descuento,
			String razonBeca) {

		if (cedula.isEmpty()) {
			String msg = "La cedula no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		} else if (!Validador.validarNumerico(cedula)) {
			String msg = "La cédula debe ser numérica.";
			throw new ValorInvalidoException(msg);
		} else if (nombre.isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (apellido.isEmpty()) {
			String msg = "El apellido no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (domicilio.isEmpty()) {
			String msg = "El domicilio no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (telefono.isEmpty()) {
			String msg = "El telefono no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (!Validador.validarNumerico(telefono)) {
			String msg = "El telefono debe ser numérico.";
			throw new ValorInvalidoException(msg);
		} else if (tipoAlumno == TipoAlumno.BECADO && descuento.isEmpty()) {
			String msg = "El porcentaje de la beca no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (tipoAlumno == TipoAlumno.BECADO && !Validador.validarNumerico(descuento)) {
			String msg = "El porcentaje de la beca debe ser numérico.";
			throw new ValorInvalidoException(msg);
		} else if (tipoAlumno == TipoAlumno.BECADO && !Validador.validarPositivo(descuento)) {
			String msg = "El porcentaje de la beca debe ser positivo.";
			throw new ValorInvalidoException(msg);
		} else if (tipoAlumno == TipoAlumno.BECADO && razonBeca.isEmpty()) {
			String msg = "La razon de la beca no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		}

	}
}

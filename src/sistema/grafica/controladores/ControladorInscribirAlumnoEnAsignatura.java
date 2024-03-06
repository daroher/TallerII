package sistema.grafica.controladores;

import sistema.excepciones.ValorInvalidoException;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOInscribirAlumno;

public class ControladorInscribirAlumnoEnAsignatura {
	private IFachada fachada;

	public ControladorInscribirAlumnoEnAsignatura() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public String inscribirAlumnoEnAsignatura(String codigoAsignatura, String cedula, String anioLectivo, String montoBase) throws Exception {
		camposValidos(codigoAsignatura, cedula, anioLectivo, montoBase);
		VOInscribirAlumno vo = new VOInscribirAlumno(codigoAsignatura, Integer.parseInt(cedula), Integer.parseInt(anioLectivo), Float.parseFloat(montoBase));
		fachada.inscribirAlumnoEnAsignatura(vo);
		String msg = "Se ha inscripto en la asignatura exitosamente.";
		return msg;
	}

	// valido los datos ingresador
	private void camposValidos(String codigoAsignatura, String cedula, String anioLectivo, String montoBase) {

		if (codigoAsignatura.isEmpty()) {
			String msg = "El código de asignatura no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (cedula.isEmpty()) {
			String msg = "La cedula no puede ser vacía.";
			throw new ValorInvalidoException(msg);
		} else if (anioLectivo.isEmpty()) {
			String msg = "El año lectivo no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		} else if (montoBase.isEmpty()) {
			String msg = "El monto base no puede ser vacío.";
			throw new ValorInvalidoException(msg);
		}

	}
}
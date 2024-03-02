package sistema.valueobjects;

import java.io.Serializable;

import sistema.logica.alumno.TipoAlumno;

public class VOAlumnoCompleto extends VOAlumnoRegistro{
	
	private int cantAprobadas;
	
	public VOAlumnoCompleto(int cedula, String nombre, String apellido, TipoAlumno tipoAlumno, String domicilio, String telefono, int porcentajeBeca, String razonBeca, int cantAprobadas) {
		super(cedula, nombre, apellido, tipoAlumno, domicilio, telefono, porcentajeBeca, razonBeca);
		this.cantAprobadas = cantAprobadas;
	}

	public int getCantAprobadas() {
		return cantAprobadas;
	}

	public void setCantAprobadas(int cantAprobadas) {
		this.cantAprobadas = cantAprobadas;
	}
}

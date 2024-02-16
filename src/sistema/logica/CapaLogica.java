package sistema.logica;

import sistema.excepciones.AlumnoExistenteException;
import sistema.excepciones.NoHayAlumnosException;
import sistema.logica.alumno.Alumno;
import sistema.logica.alumno.Alumnos;
import sistema.logica.alumno.Becado;
import sistema.logica.asignatura.Asignaturas;
import sistema.valueobjects.VOAlumnoRegistro;

public class CapaLogica {
	
	private Alumnos diccioAlumnos;
	private Asignaturas diccioAsignaturas;
	
	public CapaLogica() {
		
	}
	
	//R3 = Registrar alumno en la universidad.
	public void registrarAlumno(VOAlumnoRegistro alumno) {
		if(diccioAlumnos.empty()) {
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			if(diccioAlumnos.member(alumno.getCedula())) {
				throw new AlumnoExistenteException("Un alumno con esa cedula ya se encuentra registrado.");
			} else {
				switch(alumno.getTipoAlumno()) {
					case BECADO:
						Becado nuevoBecado = new Becado(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono(), alumno.getPorcentajeBeca(), alumno.getRazonBeca());
						diccioAlumnos.insert(nuevoBecado);
						break;
					case NORMAL:
						Alumno nuevoAlumno = new Alumno(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono());
						diccioAlumnos.insert(nuevoAlumno);
						break;
				}
			}
		}
	}

}

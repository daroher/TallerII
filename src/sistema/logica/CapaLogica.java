package sistema.logica;

import java.util.Iterator;

import sistema.excepciones.AlumnoExistenteException;
import sistema.excepciones.AlumnoNoExisteException;
import sistema.excepciones.AlumnoYaInscriptoException;
import sistema.excepciones.AnioLectivoInscripcionException;
import sistema.excepciones.AnioLectivoMontoException;
import sistema.excepciones.AsignaturaAprobadaException;
import sistema.excepciones.AsignaturaNoExisteException;
import sistema.excepciones.NoHayAlumnosException;
import sistema.excepciones.NoHayAsignaturasException;
import sistema.logica.alumno.Alumno;
import sistema.logica.alumno.Alumnos;
import sistema.logica.alumno.Becado;
import sistema.logica.asignatura.Asignaturas;
import sistema.logica.inscripcion.Inscripcion;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOMontoRecaudado;

public class CapaLogica {

	private Alumnos diccioAlumnos;
	private Asignaturas diccioAsignaturas;

	public CapaLogica() {

	}

	// R3 = Registrar alumno en la universidad.
	public void registrarAlumno(VOAlumnoRegistro alumno) {
		if (diccioAlumnos.empty()) {
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			if (diccioAlumnos.member(alumno.getCedula())) {
				throw new AlumnoExistenteException("Un alumno con esa cedula ya se encuentra registrado.");
			} else {
				switch (alumno.getTipoAlumno()) {
				case BECADO:
					Becado nuevoBecado = new Becado(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono(),
							alumno.getPorcentajeBeca(), alumno.getRazonBeca());
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

	// R6 = Inscripción de un alumno a una asignatura
	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno  vo ) {
		Inscripcion ultimaInscripcion;
		Alumno alumno;
		//TODO:falta agregar esta validacion en el pseudocodigo
		if(diccioAsignaturas.empty()) {
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		}else {
			if(!diccioAsignaturas.member(vo.getCodigo()) {
				throw new AsignaturaNoExisteException("No existe asignatura con el código dado.");
			} else {
				//TODO: deberiamos agregar validacion de que el abb no esta vacio?
				if(!diccioAlumnos.member(vo.getCedula())) {
					throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
				} else {
					alumno = diccioAlumnos.find(vo.getCedula());
					if(alumno.getInscripciones().largo() != 0) {
						ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();
						if(ultimaInscripcion.getAnioLectivo() > vo.getAnioLec()) {
							throw new AnioLectivoInscripcionException("El año lectivo de la inscripción no puede ser menor que el último año lectivo del alumno.");
						}else {
							for (Inscripcion inscripcion : alumno.getInscripciones().getInscripciones()) {
								String codigoAsignatura = inscripcion.getAsignatura().getCodigo();
								if(codigoAsignatura.trim().equals(vo.getCodigo().trim())) {
									int calificiacionInscripcion = inscripcion.getCalificacion();
									if(calificiacionInscripcion >= 6) {
										throw new AsignaturaAprobadaException("El alumno ya aprobó esta materia..");
									}else {
										if(calificiacionInscripcion == 0) {
											throw new AlumnoYaInscriptoException("La calificación final de la inscripción es 0, el alumno se encuentra cursando o la calificación nunca fue ingresada.");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		//Si pasa todas las validacion registro la inscripcion
		alumno.inscribirEnAsignatura(vo.getCodigo(),vo.getAnioLec(),vo.getMonto());
		
	}

	// R8 - Monto recaudado por inscripciones

	public VOMontoRecaudado calcularMontoRecaudado(VOCalcularMontoRecaudado vo) {
		float total = 0;
		Inscripcion ultimaInscripcion;
		Alumno alumno;

		if (!diccioAlumnos.member(vo.getCedula())) {
			throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
		} else {
			alumno = diccioAlumnos.find(vo.getCedula());
			ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();
			if (ultimaInscripcion.getAnioLectivo() >= vo.getAnioLec()) {
				//TODO: la logica que suma deberia ir en inscripciones
				Iterator<Inscripcion> it = alumno.getInscripciones().getInscripciones().iterator();
				// TODO: probar que cada next no se mueve al proximo objeto
				while (it.hasNext() && it.next().getAnioLectivo() <= vo.getAnioLec()) {
					if (it.next().getAnioLectivo() == vo.getAnioLec()) {
						// TODO: esto deberia ser por 9
						total = total + it.next().getMontoBase();
					}
				}
				if (alumno instanceof Becado) {
					total = (total * ((Becado) alumno).getPorcentajeBeca()) / 100;
				}

			} else {
				throw new AnioLectivoMontoException("El año lectivo ingresado es superior al último año lectivo del alumno.");
			}
		}

		return new VOMontoRecaudado(total);

	}

}

package sistema.logica;

import java.util.Iterator;

import sistema.excepciones.AlumnoExistenteException;
import sistema.excepciones.AlumnoNoExisteException;
import sistema.excepciones.AlumnoYaInscriptoException;
import sistema.excepciones.AnioLectivoInscripcionException;
import sistema.excepciones.AnioLectivoMontoException;
import sistema.excepciones.AsignaturaAprobadaException;
import sistema.excepciones.AsignaturaExistenteException;
import sistema.excepciones.AsignaturaNoExisteException;
import sistema.excepciones.MaximoDeAsignaturasAlcanzadoException;
import sistema.excepciones.NoHayAlumnosException;
import sistema.excepciones.NoHayAsignaturasException;
import sistema.excepciones.SistemaSinDatosException;
import sistema.logica.alumno.Alumno;
import sistema.logica.alumno.Alumnos;
import sistema.logica.alumno.Becado;
import sistema.logica.asignatura.Asignatura;
import sistema.logica.asignatura.Asignaturas;
import sistema.logica.inscripcion.Inscripcion;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.persistencia.Respaldo;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOListarAlumnos;
import sistema.valueobjects.VOListarUnicoAlumno;
import sistema.valueobjects.VOMontoRecaudado;
import sistema.valueobjects.VORespaldo;

public class CapaLogica {

	private Alumnos diccioAlumnos = new Alumnos();
	private Asignaturas diccioAsignaturas = new Asignaturas();

	public CapaLogica() {

	}
	
	//R1 = Registrar asignatura;
	public void registrarAsignatura(VOAsignatura asignatura) throws Exception {
		if(diccioAsignaturas.estaLleno()) {
			throw new MaximoDeAsignaturasAlcanzadoException("No es posible ingresar mas de 10 asignaturas en el sistema.");
		} else {
			if(diccioAsignaturas.member(asignatura.getCodigo())) {
				throw new AsignaturaExistenteException("Ya existe una asignatura con ese codigo.");
			} else {
				Asignatura nuevaAsignatura = new Asignatura(asignatura.getCodigo(), asignatura.getNombre(), asignatura.getDescripcion());
				
				diccioAsignaturas.insert(nuevaAsignatura);
			}
		}
	}
	
	//R2 = Listar asignaturas.
	public VOAsignatura[] listarAsignaturas() throws Exception {
		if(diccioAsignaturas.empty()) {
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		} else {
			return diccioAsignaturas.listarAsignaturas();
		}
	}

	// R3 = Registrar alumno en la universidad.
	public void registrarAlumno(VOAlumnoRegistro alumno) throws Exception {
		//TODO:esta validacion no deberia ir creo, deberia permitirme registrar un alumno aunque no haya nadie registrado
//		if (diccioAlumnos.empty()) {
//			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
//		} else {
			if (diccioAlumnos.member(alumno.getCedula())) {
				throw new AlumnoExistenteException("Un alumno con esa cedula ya se encuentra registrado.");
			} else {
				switch (alumno.getTipoAlumno()) {
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
//		}
	}
	
	//R4 = Listado de alumnos por apellido.
	public VOAlumno[] listarAlumnos(VOListarAlumnos vo) throws Exception {
		if(diccioAlumnos.empty()) {
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			return diccioAlumnos.listarAlumnos(vo.getApellido());
		}
	}
	
	//R5 = Listar un unico alumno mediante cedula.
	public VOAlumnoCompleto listarUnicoAlumno(VOListarUnicoAlumno vo) throws Exception {
		if (diccioAlumnos.empty()) {
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			if (!diccioAlumnos.member(vo.getCedula())) {
				throw new AlumnoNoExisteException("No existe ningun alumno con la cedula dada.");
			} else {
				return diccioAlumnos.listarUnicoAlumno(vo.getCedula());
			}
		}
	}

	// R6 = Inscripción de un alumno a una asignatura
	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno vo) {
		Inscripcion ultimaInscripcion;
		Alumno alumno;
		// TODO:falta agregar esta validacion en el pseudocodigo
		if (diccioAsignaturas.empty()) {
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		} else {
			if (!diccioAsignaturas.member(vo.getCodigo())) {
				throw new AsignaturaNoExisteException("No existe asignatura con el código dado.");
			} else {
				// TODO: deberiamos agregar validacion de que el abb no esta vacio?
				if (!diccioAlumnos.member(vo.getCedula())) {
					throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
				} else {
					alumno = diccioAlumnos.find(vo.getCedula());
					if (alumno.getInscripciones() != null && alumno.getInscripciones().largo() != 0) {
						ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();
						if (ultimaInscripcion.getAnioLectivo() > vo.getAnioLec()) {
							throw new AnioLectivoInscripcionException(
									"El año lectivo de la inscripción no puede ser menor que el último año lectivo del alumno.");
						} else {
							for (Inscripcion inscripcion : alumno.getInscripciones().getInscripciones()) {
								String codigoAsignatura = inscripcion.getAsignatura().getCodigo();
								if (codigoAsignatura.trim().equals(vo.getCodigo().trim())) {
									int calificiacionInscripcion = inscripcion.getCalificacion();
									if (calificiacionInscripcion >= 6) {
										throw new AsignaturaAprobadaException("El alumno ya aprobó esta materia..");
									} else {
										if (calificiacionInscripcion == 0) {
											throw new AlumnoYaInscriptoException(
													"La calificación final de la inscripción es 0, el alumno se encuentra cursando o la calificación nunca fue ingresada.");
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// Si pasa todas las validacion registro la inscripcion
		alumno.inscribirEnAsignatura(vo.getCodigo(), vo.getAnioLec(), vo.getMonto());

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
			// TODO:falta validar si no tiene inscripciones y agregarlo al pseudocodigo
			if(alumno.getInscripciones() != null && !alumno.getInscripciones().empty()) {
				ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();
				if (ultimaInscripcion.getAnioLectivo() >= vo.getAnioLec()) {
					// TODO: la logica que suma deberia ir en inscripciones
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
		}

		return new VOMontoRecaudado(total);

	}

	// R11 - Respaldo de datos
	public void respaldarSistema() {
		if (diccioAlumnos.empty() && diccioAsignaturas.empty()) {
			throw new SistemaSinDatosException("No hay nada para respaldar de momento.");
		} else {
			// Creo el VO que voy a pasar a la capa de persistencia
			// TODO: agregar constructor con parametros al VORespaldo y ver si no tengo
			// getters como obtengo los datos de los diccionarios, depende de duda ya
			// planteada
			VORespaldo voRespaldo = new VORespaldo();
			// TODO: clase respaldo podria ser static, no manipula datos, lo que recibe lo
			// guarda tal cual
			Respaldo res = new Respaldo();
			res.respaldarSistema(voRespaldo);
		}

	}

	// R12 - Recuperación de datos
	public void recuperarSistema() {
		// levanto la informacion en el VO
		VORespaldo voRespaldo = new VORespaldo();
		Respaldo res = new Respaldo();
		voRespaldo = res.recuperarSistema();

		// TODO:Aca pasaria del vo a los diccionarios, pero no tengo setters aun

	}

}

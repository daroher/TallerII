package sistema.logica;

import java.util.Iterator;

import sistema.excepciones.*;
import sistema.logica.alumno.*;
import sistema.logica.asignatura.*;
import sistema.logica.inscripcion.*;
import sistema.valueobjects.*;
import sistema.persistencia.Respaldo;

public class CapaLogica {

	private Alumnos diccioAlumnos = new Alumnos();
	private Asignaturas diccioAsignaturas = new Asignaturas();

	public CapaLogica() {

	}
	
	//R1 = Registrar asignatura;
	public void registrarAsignatura(VOAsignatura vo) throws Exception {
		if(diccioAsignaturas.estaLleno()) {
			throw new MaximoDeAsignaturasAlcanzadoException("No es posible ingresar mas de 10 asignaturas en el sistema.");
		} else {
			if(diccioAsignaturas.member(vo.getCodigo())) {
				throw new AsignaturaExistenteException("Ya existe una asignatura con ese codigo.");
			} else {
				Asignatura nuevaAsignatura = new Asignatura(vo.getCodigo(), vo.getNombre(), vo.getDescripcion());
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
	public void registrarAlumno(VOAlumnoRegistro vo) throws Exception {
		if (diccioAlumnos.member(vo.getCedula())) {
			throw new AlumnoExistenteException("Un alumno con esa cedula ya se encuentra registrado.");
		} else {
			switch (vo.getTipoAlumno()) {
			case BECADO:
				Becado nuevoBecado = new Becado(vo.getCedula(), vo.getNombre(), vo.getApellido(), vo.getDomicilio(), vo.getTelefono(), vo.getPorcentajeBeca(), vo.getRazonBeca());
				diccioAlumnos.insert(nuevoBecado);
				break;
			case NORMAL:
				Alumno nuevoAlumno = new Alumno(vo.getCedula(), vo.getNombre(), vo.getApellido(), vo.getDomicilio(), vo.getTelefono());
				diccioAlumnos.insert(nuevoAlumno);
				break;
			}
		}
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
	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno vo) throws Exception {
		int anioLectivoUltimaInscripcion;
		Alumno alumno;
		
		if (diccioAsignaturas.empty()) {
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		} else {
			if (!diccioAsignaturas.member(vo.getCodigo())) {
				throw new AsignaturaNoExisteException("No existe asignatura con el código dado.");
			} else {
				if(diccioAlumnos.empty()) {
					throw new NoHayAlumnosException("No hay alumnos en el sistema.");
				} else {
					if (!diccioAlumnos.member(vo.getCedula())) {
						throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
					} else {
						alumno = diccioAlumnos.find(vo.getCedula());
						
						if (alumno.getInscripciones().largo() > 0) {
							anioLectivoUltimaInscripcion = alumno.getInscripciones().getUltimaInscripcion().getAnioLectivo();
							
							if (anioLectivoUltimaInscripcion > vo.getAnioLec()) {
								throw new AnioLectivoInscripcionException("El año lectivo de la inscripción no puede ser menor que el último año lectivo del alumno.");
							} else {
								if(alumno.getInscripciones().estaLaAsignaturaAprobada(vo.getCodigo())) {
									throw new AsignaturaAprobadaException("El alumno ya aprobó esta materia.");
								} else if(alumno.getInscripciones().estaLaAsignaturaEnCurso(vo.getCodigo())) {
									throw new AlumnoYaInscriptoException("La calificación final de la inscripción es 0, el alumno se encuentra cursando o la calificación nunca fue ingresada.");
								}
							}
						}
					}	
				}
			}
		}
		
		Inscripcion nuevaInscripcion = new Inscripcion(vo.getAnioLec(), vo.getMonto(), diccioAsignaturas.find(vo.getCodigo()));	
		alumno.inscribirEnAsignatura(nuevaInscripcion);
	}
	
	//R7 = Registrar resultado en inscripcion.
	public void registrarResultado(VORegistrarResultado vo) {
		Alumno alumno;
		Inscripcion inscripcion;
		
		if (vo.getNota() < 1 || vo.getNota() > 12) {
			throw new CalificacionFueraDeRangoException("La nota ingresada debe estar entre 1 y 12.");
		} else  {
			if (!diccioAlumnos.member(vo.getCedula())) {
				throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
			} else {
				alumno = diccioAlumnos.find(vo.getCedula());
				
				if (!alumno.getInscripciones().member(vo.getNumInscripcion())) {
					throw new InscripcionNoEncontradaException("No existe una inscripción con el código proporcionado para ese alumno.");
				} else {
					inscripcion = alumno.getInscripciones().find(vo.getNumInscripcion());
					
					if (inscripcion.getCalificacion() != 0) {
						throw new CalificacionYaIngresadaException("La inscripcion ya tiene una nota ingresada.");
					} else {
						inscripcion.setCalificacion(vo.getNota());
						
						if (vo.getNota() >= 6) {
							alumno.incrementarCantAsignaturasAprobadas();
						}
					}
				}
			}
		}
	}

	// R8 - Monto recaudado por inscripciones en un anio lectivo dado.
	public VOMontoRecaudado calcularMontoRecaudado(VOCalcularMontoRecaudado vo) {
		Inscripcion ultimaInscripcion;
		Alumno alumno;
		float total;

		if (!diccioAlumnos.member(vo.getCedula())) {
			throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
		} else {
			alumno = diccioAlumnos.find(vo.getCedula());
			
			if (alumno.getInscripciones().empty()) {
				throw new AlumnoSinInscripcionesException("El alumno no posee ninguna inscripcion hasta el momento.");
			} else {
				ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();
				
				if (ultimaInscripcion.getAnioLectivo() >= vo.getAnioLec()) {
					total = alumno.getInscripciones().calcularMontoRecaudado(vo.getAnioLec());
	
					if (alumno instanceof Becado) {
						total = total * (((Becado)alumno).getPorcentajeBeca()) / 100;
					}				
				} else {
					throw new AnioLectivoMontoException("El año lectivo ingresado es superior al último año lectivo del alumno.");
				}
			}
		}
		
		return new VOMontoRecaudado(total);
	}
	
	// R9 = Consulta de escolaridad, parcial o completa.
	public VOEscolaridad[] consultarEscolaridad(VOConsultarEscolaridad vo) {
		Alumno alumno;
		
		if (!diccioAlumnos.member(vo.getCedula())) {
			throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
		} else {
			alumno = diccioAlumnos.find(vo.getCedula());
			
			if (alumno.getInscripciones().empty()) {
				throw new AlumnoSinInscripcionesException("El alumno no posee ninguna inscripcion hasta el momento.");
			} else {
				return alumno.listarEscolaridad(vo.getModoListado());
			}
		}
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

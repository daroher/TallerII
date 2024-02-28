package sistema.logica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import sistema.excepciones.AlumnoExistenteException;
import sistema.excepciones.AlumnoNoExisteException;
import sistema.excepciones.AlumnoSinInscripcionesException;
import sistema.excepciones.AlumnoYaInscriptoException;
import sistema.excepciones.AnioLectivoInscripcionException;
import sistema.excepciones.AnioLectivoMontoException;
import sistema.excepciones.AsignaturaAprobadaException;
import sistema.excepciones.AsignaturaExistenteException;
import sistema.excepciones.AsignaturaNoExisteException;
import sistema.excepciones.CalificacionFueraDeRangoException;
import sistema.excepciones.CalificacionYaIngresadaException;
import sistema.excepciones.InscripcionNoEncontradaException;
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
import sistema.logica.monitor.Monitor;
import sistema.persistencia.Respaldo;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOConsultarEscolaridad;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOEscolaridad;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOListarAlumnos;
import sistema.valueobjects.VOListarEgresados;
import sistema.valueobjects.VOListarUnicoAlumno;
import sistema.valueobjects.VOMontoRecaudado;
import sistema.valueobjects.VORegistrarResultado;
import sistema.valueobjects.VORespaldo;

public class Fachada extends UnicastRemoteObject implements IFachada {

	private Alumnos diccioAlumnos = new Alumnos();
	private Asignaturas diccioAsignaturas = new Asignaturas();

	public Fachada() throws RemoteException {

	}

	// R1 = Registrar asignatura;
	public void registrarAsignatura(VOAsignatura vo) throws Exception {
		Monitor.getInstancia().comenzarEscritura();
		System.out.println("Registrando");
		if (diccioAsignaturas.estaLleno()) {
			Monitor.getInstancia().terminarEscritura();
			
			throw new MaximoDeAsignaturasAlcanzadoException("No es posible ingresar mas de 10 asignaturas en el sistema.");
		} else {
			if (diccioAsignaturas.member(vo.getCodigo())) {
				Monitor.getInstancia().terminarEscritura();
				
				throw new AsignaturaExistenteException("Ya existe una asignatura con ese codigo.");
			} else {
				Asignatura nuevaAsignatura = new Asignatura(vo.getCodigo(), vo.getNombre(), vo.getDescripcion());
				diccioAsignaturas.insert(nuevaAsignatura);
				
				Monitor.getInstancia().terminarEscritura();			
			}
		}
	}

	// R2 = Listar asignaturas.
	public VOAsignatura[] listarAsignaturas() throws Exception {
		Monitor.getInstancia().comenzarLectura();
		
		if (diccioAsignaturas.empty()) {
			Monitor.getInstancia().terminarLectura();
			
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		} else {
			Monitor.getInstancia().terminarLectura();
			
			return diccioAsignaturas.listarAsignaturas();		
		}
	}

	// R3 = Registrar alumno en la universidad.
	public void registrarAlumno(VOAlumnoRegistro vo) throws Exception {
		Monitor.getInstancia().comenzarEscritura();
		
		if (diccioAlumnos.member(vo.getCedula())) {
			Monitor.getInstancia().terminarEscritura();
			
			throw new AlumnoExistenteException("Un alumno con esa cedula ya se encuentra registrado.");
		} else {
			switch (vo.getTipoAlumno()) {
			case BECADO:
				Becado nuevoBecado = new Becado(vo.getCedula(), vo.getNombre(), vo.getApellido(), vo.getDomicilio(), vo.getTelefono(), vo.getPorcentajeBeca(),
						vo.getRazonBeca());
				diccioAlumnos.insert(nuevoBecado);
				break;
			case NORMAL:
				Alumno nuevoAlumno = new Alumno(vo.getCedula(), vo.getNombre(), vo.getApellido(), vo.getDomicilio(), vo.getTelefono());
				diccioAlumnos.insert(nuevoAlumno);
				break;
			}
			
			Monitor.getInstancia().terminarEscritura();
		}
	}

	// R4 = Listado de alumnos por apellido.
	public VOAlumno[] listarAlumnos(VOListarAlumnos vo) throws Exception {
		Monitor.getInstancia().comenzarLectura();
		
		if (diccioAlumnos.empty()) {
			Monitor.getInstancia().terminarLectura();
			
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			Monitor.getInstancia().terminarLectura();
			
			return diccioAlumnos.listarAlumnos(vo.getApellido());
		}
	}

	// R5 = Listar un unico alumno mediante cedula.
	public VOAlumnoCompleto listarUnicoAlumno(VOListarUnicoAlumno vo) throws Exception {
		Monitor.getInstancia().comenzarLectura();
		
		if (diccioAlumnos.empty()) {
			Monitor.getInstancia().terminarLectura();
			
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			if (!diccioAlumnos.member(vo.getCedula())) {
				Monitor.getInstancia().terminarLectura();
				
				throw new AlumnoNoExisteException("No existe ningun alumno con la cedula dada.");
			} else {
				Monitor.getInstancia().terminarLectura();
				
				return diccioAlumnos.listarUnicoAlumno(vo.getCedula());
			}
		}
	}

	// R6 = Inscripción de un alumno a una asignatura
	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno vo) throws Exception {		
		int anioLectivoUltimaInscripcion;
		Alumno alumno;
		
		Monitor.getInstancia().comenzarEscritura();

		if (diccioAsignaturas.empty()) {
			Monitor.getInstancia().terminarEscritura();
			
			throw new NoHayAsignaturasException("No hay asignaturas en el sistema.");
		} else {
			if (!diccioAsignaturas.member(vo.getCodigo())) {
				Monitor.getInstancia().terminarEscritura();
				
				throw new AsignaturaNoExisteException("No existe asignatura con el código dado.");
			} else {
				if (diccioAlumnos.empty()) {
					Monitor.getInstancia().terminarEscritura();
					
					throw new NoHayAlumnosException("No hay alumnos en el sistema.");
				} else {
					if (!diccioAlumnos.member(vo.getCedula())) {
						Monitor.getInstancia().terminarEscritura();
						
						throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
					} else {
						alumno = diccioAlumnos.find(vo.getCedula());

						if (alumno.getInscripciones().largo() > 0) {
							anioLectivoUltimaInscripcion = alumno.getInscripciones().getUltimaInscripcion().getAnioLectivo();

							if (anioLectivoUltimaInscripcion > vo.getAnioLec()) {
								Monitor.getInstancia().terminarEscritura();
							
								throw new AnioLectivoInscripcionException(
										"El año lectivo de la inscripción no puede ser menor que el último año lectivo del alumno.");
							} else {
								if (alumno.getInscripciones().estaLaAsignaturaAprobada(vo.getCodigo())) {
									Monitor.getInstancia().terminarEscritura();
									
									throw new AsignaturaAprobadaException("El alumno ya aprobó esta materia.");
								} else if (alumno.getInscripciones().estaLaAsignaturaEnCurso(vo.getCodigo())) {
									Monitor.getInstancia().terminarEscritura();
									
									throw new AlumnoYaInscriptoException(
											"La calificación final de la inscripción es 0, el alumno se encuentra cursando o la calificación nunca fue ingresada.");
								}
							}
						}
					}
				}				
			}
		}

		Inscripcion nuevaInscripcion = new Inscripcion(vo.getAnioLec(), vo.getMonto(), diccioAsignaturas.find(vo.getCodigo()));
		alumno.inscribirEnAsignatura(nuevaInscripcion);
		
		Monitor.getInstancia().terminarEscritura();
	}

	// R7 = Registrar resultado en inscripcion.
	public void registrarResultado(VORegistrarResultado vo) throws Exception {
		Alumno alumno;
		Inscripcion inscripcion;

		Monitor.getInstancia().comenzarEscritura();
		// TODO: esta validacion se deberia mover a la capa grafica
		if (vo.getNota() < 1 || vo.getNota() > 12) {
			throw new CalificacionFueraDeRangoException("La nota ingresada debe estar entre 1 y 12.");
		} else {
			if (!diccioAlumnos.member(vo.getCedula())) {
				Monitor.getInstancia().terminarEscritura();
				
				throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
			} else {
				alumno = diccioAlumnos.find(vo.getCedula());
				if (!alumno.getInscripciones().member(vo.getNumInscripcion())) {
					Monitor.getInstancia().terminarEscritura();
					
					throw new InscripcionNoEncontradaException("No existe una inscripción con el código proporcionado para ese alumno.");
				} else {
					inscripcion = alumno.getInscripciones().find(vo.getNumInscripcion());

					if (inscripcion.getCalificacion() != 0) {
						Monitor.getInstancia().terminarEscritura();
						
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
		
		Monitor.getInstancia().terminarEscritura();
	}

	// R8 - Monto recaudado por inscripciones en un anio lectivo dado.
	public VOMontoRecaudado calcularMontoRecaudado(VOCalcularMontoRecaudado vo) throws Exception {
		Inscripcion ultimaInscripcion;
		Alumno alumno;
		float total;
		
		Monitor.getInstancia().comenzarLectura();
		
		if (!diccioAlumnos.member(vo.getCedula())) {
			Monitor.getInstancia().terminarLectura();
			
			throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
		} else {
			alumno = diccioAlumnos.find(vo.getCedula());

			if (alumno.getInscripciones().empty()) {
				Monitor.getInstancia().terminarLectura();
				
				throw new AlumnoSinInscripcionesException("El alumno no posee ninguna inscripcion hasta el momento.");
			} else {
				ultimaInscripcion = alumno.getInscripciones().getUltimaInscripcion();

				if (ultimaInscripcion.getAnioLectivo() >= vo.getAnioLec()) {
					total = alumno.getInscripciones().calcularMontoRecaudado(vo.getAnioLec());

					if (alumno instanceof Becado) {
						float montoDescuento = (total * ((Becado) alumno).getPorcentajeBeca()) / 100;
						total = total - montoDescuento;
					}
				} else {
					Monitor.getInstancia().terminarLectura();
					
					throw new AnioLectivoMontoException("El año lectivo ingresado es superior al último año lectivo del alumno.");
				}
			}
		}
		
		Monitor.getInstancia().terminarLectura();
		
		return new VOMontoRecaudado(total);
	}

	// R9 = Consulta de escolaridad, parcial o completa.
	public VOEscolaridad[] consultarEscolaridad(VOConsultarEscolaridad vo) throws Exception {
		Alumno alumno;
		
		Monitor.getInstancia().comenzarLectura();

		if (!diccioAlumnos.member(vo.getCedula())) {
			Monitor.getInstancia().terminarLectura();
			
			throw new AlumnoNoExisteException("No existe alumno con esa cédula registrado.");
		} else {
			alumno = diccioAlumnos.find(vo.getCedula());

			if (alumno.getInscripciones().empty()) {
				Monitor.getInstancia().terminarLectura();
				
				throw new AlumnoSinInscripcionesException("El alumno no posee ninguna inscripcion hasta el momento.");
			} else {
				Monitor.getInstancia().terminarLectura();
				
				return alumno.listarEscolaridad(vo.getModoListado());
			}
		}
	}

	// R10 = Listado de egresados.
	public VOEgresado[] listarEgresados(VOListarEgresados vo) throws Exception {
		Monitor.getInstancia().comenzarLectura();		
		
		if (diccioAlumnos.empty()) {
			Monitor.getInstancia().terminarLectura();
			
			throw new NoHayAlumnosException("No hay alumnos en el sistema.");
		} else {
			Monitor.getInstancia().terminarLectura();
			
			return diccioAlumnos.listarEgresados(vo.getModoListado());
		}
	}

	// R11 = Respaldo de datos del sistema en archivo.
	public void respaldarSistema() {
		Monitor.getInstancia().comenzarEscritura();
		
		if (diccioAlumnos.empty() && diccioAsignaturas.empty()) {
			Monitor.getInstancia().terminarEscritura();
			
			throw new SistemaSinDatosException("No hay nada para respaldar de momento.");
		} else {
			VORespaldo voRespaldo = new VORespaldo();

			voRespaldo.setRespaldoAlumnos(diccioAlumnos.getAbbAlumnos());
			voRespaldo.setRespaldoAsignaturas(diccioAsignaturas.getAsignaturas());

			Respaldo respaldo = new Respaldo();
			respaldo.respaldarSistema(voRespaldo);
		}

		Monitor.getInstancia().terminarEscritura();
	}

	// R12 = Recuperación de datos desde archivo a sistema.
	public void recuperarSistema() {
		VORespaldo voRespaldo = new VORespaldo();

		Monitor.getInstancia().comenzarLectura();	
		
		Respaldo respaldo = new Respaldo();
		voRespaldo = respaldo.recuperarSistema();
		
		diccioAlumnos.setAbbAlumnos(voRespaldo.getRespaldoAlumnos());
		diccioAsignaturas.setAsignaturas(voRespaldo.getRespaldoAsignaturas());
		
		Monitor.getInstancia().terminarLectura();
	}
}

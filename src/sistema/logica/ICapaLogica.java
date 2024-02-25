package sistema.logica;

import java.rmi.Remote;

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

public interface ICapaLogica extends Remote {

	// R1 = Registrar asignatura;
	public void registrarAsignatura(VOAsignatura vo) throws Exception;

	// R2 = Listar asignaturas.
	public VOAsignatura[] listarAsignaturas() throws Exception;

	// R3 = Registrar alumno en la universidad.
	public void registrarAlumno(VOAlumnoRegistro vo) throws Exception;

	// R4 = Listado de alumnos por apellido.
	public VOAlumno[] listarAlumnos(VOListarAlumnos vo) throws Exception;

	// R5 = Listar un unico alumno mediante cedula.
	public VOAlumnoCompleto listarUnicoAlumno(VOListarUnicoAlumno vo) throws Exception;

	// R6 = Inscripción de un alumno a una asignatura
	public void inscribirAlumnoEnAsignatura(VOInscribirAlumno vo) throws Exception;

	// R7 = Registrar resultado en inscripcion.
	public void registrarResultado(VORegistrarResultado vo) throws Exception;

	// R8 - Monto recaudado por inscripciones en un anio lectivo dado.
	public VOMontoRecaudado calcularMontoRecaudado(VOCalcularMontoRecaudado vo) throws Exception;

	// R9 = Consulta de escolaridad, parcial o completa.
	public VOEscolaridad[] consultarEscolaridad(VOConsultarEscolaridad vo) throws Exception;

	// R10 = Listado de egresados.
	public VOEgresado[] listarEgresados(VOListarEgresados vo) throws Exception;

	// R11 = Respaldo de datos del sistema en archivo.
	public void respaldarSistema() throws Exception;

	// R12 = Recuperación de datos desde archivo a sistema.
	public void recuperarSistema() throws Exception;

}

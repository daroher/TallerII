package sistema.test;

import sistema.logica.CapaLogica;
import sistema.logica.alumno.Alumno;
import sistema.logica.alumno.TipoAlumno;
import sistema.logica.asignatura.Asignatura;
import sistema.logica.inscripcion.Inscripcion;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOListarAlumnos;
import sistema.valueobjects.VOListarUnicoAlumno;
import sistema.valueobjects.VOMontoRecaudado;

public class MainTest {

	public static void main(String[] args) throws Exception {

		//Pruebas de la capa logica *************************************
		
		CapaLogica capaLogica = new CapaLogica();
		
		//R1
		VOAsignatura voAsignatura = new VOAsignatura("asig1", "asignatura 1", "asignatura de prueba 1");
		capaLogica.registrarAsignatura(voAsignatura);
		System.out.println("R1 OK");
		
		//R2
		VOAsignatura[] listaAsignaturas = capaLogica.listarAsignaturas();
		System.out.println("La lista tiene " + listaAsignaturas.length +" asignaturas");
		for (VOAsignatura vo : listaAsignaturas) {
			System.out.println(vo.getNombre());
		}
		System.out.println("R2 OK");
		
		//R3
		VOAlumnoRegistro voAlumnoRegistro = new VOAlumnoRegistro(12223334, "nombre", "apellido", TipoAlumno.NORMAL, "domicilio", "099111222", 0, null);
		capaLogica.registrarAlumno(voAlumnoRegistro);
		System.out.println("R3 OK");
	
		//R4
		VOListarAlumnos voListarAlumnos = new VOListarAlumnos("ape"); 
		VOAlumno[] listaAlumnos = capaLogica.listarAlumnos(voListarAlumnos);
		System.out.println("La lista tiene " + listaAlumnos.length +" alumnos");
		for (VOAlumno vo : listaAlumnos) {
			System.out.println(vo.getApellido());
		}
		System.out.println("R4 OK");
//		
		//R5
		VOListarUnicoAlumno voListarUnicoAlumno;
		VOAlumnoCompleto alumnoCompleto;
		//consulto uno normal
		voListarUnicoAlumno = new VOListarUnicoAlumno(12223334); 
		alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
		System.out.println("Nombre Alumno: " + alumnoCompleto.getNombre() + ", Tipo alumno: " + alumnoCompleto.getTipoAlumno().name());
		
		//registro uno becado
		VOAlumnoRegistro voAlumnoRegistro2 = new VOAlumnoRegistro(12223335, "nombre", "apellido", TipoAlumno.BECADO, "domicilio", "099111222", 10, "Beca de 10%");
		capaLogica.registrarAlumno(voAlumnoRegistro2);
		//consulto uno becado		
		voListarUnicoAlumno = new VOListarUnicoAlumno(12223335); 
		alumnoCompleto = capaLogica.listarUnicoAlumno(voListarUnicoAlumno);
		System.out.println("Nombre Alumno: " + alumnoCompleto.getNombre() + ", Tipo alumno: " + alumnoCompleto.getTipoAlumno().name() + ", porcentaje beca: " + alumnoCompleto.getPorcentajeBeca() + ", razon: " + alumnoCompleto.getRazonBeca());
		System.out.println("R5 OK");
		
		
		//R6
		VOInscribirAlumno voInscribirAlumno = new VOInscribirAlumno("asig1", 12223334, 2024, 10000);
		capaLogica.inscribirAlumnoEnAsignatura(voInscribirAlumno);
		System.out.println("R6 OK");

		//R8
		VOCalcularMontoRecaudado voCalcularMontoRecaudado;
		VOMontoRecaudado voMontoRecaudado;
		//calculo monto de normal
		voCalcularMontoRecaudado = new VOCalcularMontoRecaudado(12223334, 2024);
		voMontoRecaudado = capaLogica.calcularMontoRecaudado(voCalcularMontoRecaudado);
		System.out.println("Monto recaudado de cedula " + voCalcularMontoRecaudado.getCedula() + ": " + voMontoRecaudado.getMontoRecaudado());
		
		//calculo monto de becado
		voCalcularMontoRecaudado = new VOCalcularMontoRecaudado(12223335, 2024);
		voMontoRecaudado = capaLogica.calcularMontoRecaudado(voCalcularMontoRecaudado);
		System.out.println("Monto recaudado de cedula " + voCalcularMontoRecaudado.getCedula() + ": " + voMontoRecaudado.getMontoRecaudado());
		System.out.println("R8 OK");

				
		//R11
		capaLogica.respaldarSistema();
		System.out.println("R11 OK");
		
		//R12
		capaLogica.recuperarSistema();
		System.out.println("R12 OK");
		//******************************************************************
	}

}

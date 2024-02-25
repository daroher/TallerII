package test;

import sistema.logica.CapaLogica;
import sistema.logica.alumno.TipoAlumno;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOEgresadoCompleto;
import sistema.valueobjects.VOInscribirAlumno;
import sistema.valueobjects.VOListarEgresados;
import sistema.valueobjects.VORegistrarResultado;

public class R10Test {

	public void test(CapaLogica capaLogica) {

		VOInscribirAlumno voInscribirAlumno;
		VOAlumnoRegistro voAlumnoRegistro;
		VORegistrarResultado voRegistrarResultado;

		// creo un alumno y le ingreso 10 asignaturas aprobadas
		try {
			voAlumnoRegistro = new VOAlumnoRegistro(12223336, "nombreNorma2", "apellidoNorma2", TipoAlumno.NORMAL, "domicilioNornma2", "099111226", 0, null);
			capaLogica.registrarAlumno(voAlumnoRegistro);

			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig1", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig2", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig3", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig4", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig5", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig6", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig7", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig8", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig9", 12223336, 2024, 10000));
			capaLogica.inscribirAlumnoEnAsignatura(new VOInscribirAlumno("asig10", 12223336, 2024, 10000));

			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 1));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 2));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 3));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 4));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 5));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 6));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 7));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 8));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 9));
			capaLogica.registrarResultado(new VORegistrarResultado(12223336, 6, 10));

		} catch (Exception e) {
			e.printStackTrace();
		}

		VOListarEgresados voListarEgresados = new VOListarEgresados(TipoListado.COMPLETO);
		VOEgresado[] listaEgresados = null;

		try {
			listaEgresados = capaLogica.listarEgresados(voListarEgresados);
			for (VOEgresado voEgresado : listaEgresados) {
				System.out.println(voEgresado.getApellido());

				if (voEgresado instanceof VOEgresadoCompleto) {
					// Solo realiza el casting si es un VOEgresadoCompleto
					VOEgresadoCompleto egresadoCompleto = (VOEgresadoCompleto) voEgresado;
					System.out.println(egresadoCompleto.getPromedioTotal() + "," + egresadoCompleto.getPromedioAprobadas());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

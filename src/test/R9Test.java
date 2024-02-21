package test;

import sistema.logica.CapaLogica;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOConsultarEscolaridad;
import sistema.valueobjects.VOEscolaridad;
import sistema.valueobjects.VOEscolaridadCompleta;

public class R9Test {

	public void test(CapaLogica capaLogica) {

		VOConsultarEscolaridad voConsultarEscolaridad;
		VOEscolaridad[] escolaridad;
		VOEscolaridadCompleta[] escolaridadCompleta;
		try {
			// consulta parcial
			voConsultarEscolaridad = new VOConsultarEscolaridad(12223334, TipoListado.PARCIAL);
			escolaridad = capaLogica.consultarEscolaridad(voConsultarEscolaridad);
			System.out.println("Listado parcial:");
			for (VOEscolaridad voEscolaridad : escolaridad) {
				System.out.println("numInscripcion=" + voEscolaridad.getNumInscripcion() + ", nombreAsignatura=" + voEscolaridad.getNombreAsignatura()
						+ ", anioLectivo=" + voEscolaridad.getAnioLectivo() + ", calificacion=" + voEscolaridad.getCalificacion());
			}

			// consulto completa
			voConsultarEscolaridad = new VOConsultarEscolaridad(12223334, TipoListado.COMPLETO);
			escolaridadCompleta = (VOEscolaridadCompleta[]) capaLogica.consultarEscolaridad(voConsultarEscolaridad);
			
			System.out.println("\nListado Completo:");
			for (VOEscolaridadCompleta voEscolaridadCompleta : escolaridadCompleta) {
				System.out.println("numInscripcion=" + voEscolaridadCompleta.getNumInscripcion() + ", nombreAsignatura="
						+ voEscolaridadCompleta.getNombreAsignatura() + ", anioLectivo=" + voEscolaridadCompleta.getAnioLectivo() + ", calificacion="
						+ voEscolaridadCompleta.getCalificacion() + ", montoBase=" + voEscolaridadCompleta.getMontoBase());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

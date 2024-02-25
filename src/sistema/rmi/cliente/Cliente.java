package sistema.rmi.cliente;

import java.rmi.Naming;

import sistema.logica.ICapaLogica;
import sistema.valueobjects.VOAsignatura;

public class Cliente {

	public static void main(String[] args) throws Exception {
		try {
			ICapaLogica capaLogica = (ICapaLogica) Naming.lookup("//localhost:1099/logica");
			capaLogica.registrarAsignatura(new VOAsignatura("asig1", "asignatura 1", "asignatura de prueba 1"));
			
			// prueba de listar asignaturas
			VOAsignatura[] listaAsignaturas = null;
			listaAsignaturas = capaLogica.listarAsignaturas();
			
			for (VOAsignatura voAsignatura : listaAsignaturas) {
				System.out.println(voAsignatura.getNombre());
			}
				
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}

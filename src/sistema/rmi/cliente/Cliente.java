package sistema.rmi.cliente;

import java.rmi.Naming;

import sistema.logica.IFachada;
import sistema.utilidades.GetProperties;
import sistema.valueobjects.VOAsignatura;

public class Cliente {

	public static void main(String[] args) throws Exception {
		try {
			
			String host = GetProperties.getInstancia().getString("ipServidor");
			String puerto = GetProperties.getInstancia().getString("puertoServidor");
			
			IFachada capaLogica = (IFachada) Naming.lookup("//" + host + ":" + puerto + "/logica");
			
			
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

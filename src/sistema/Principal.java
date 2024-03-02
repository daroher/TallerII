package sistema;

import javax.swing.UIManager;

import sistema.grafica.pantallas.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		try {
			//seteo estilos para las panatallas
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//TODO:hacer excepcion cargando los estilos
		}

		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}

}

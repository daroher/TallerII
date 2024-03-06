package sistema.grafica.controladores;

import javax.swing.JOptionPane;

import sistema.grafica.componentes.FormularioListarEgresados;
import sistema.logica.IFachada;
import sistema.rmi.cliente.Cliente;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOListarEgresados;

public class ControladorListarEgresados {

	private IFachada fachada;
	private FormularioListarEgresados panelFormulario;

	public ControladorListarEgresados() throws Exception {
		this.fachada = (IFachada) Cliente.conectar();
	}

	public VOEgresado[] listarEgresados(VOListarEgresados vo) throws Exception {
		VOEgresado[] egresados = null;
		egresados = fachada.listarEgresados(vo);
	
		if(egresados != null && egresados.length == 0) {
			String msg = "No hay egresados en el sistema actualmente.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return egresados;

	}
}
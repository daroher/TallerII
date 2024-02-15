package sistema.grafica;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrueba {

	// etiquetas
	private JLabel labelMensaje;
	private JLabel labelTipo;
	// nombre y estado	
	private JTextField textFieldMensaje;
	private JCheckBox chkboxTipo;
	// botón
	private JButton btnIngresar;
	// marco de la ventana, que contendrá los componentes
	private JFrame frame;
 
	private void initialize() {
		// creo frame y seteo su color de fondo y título
		frame = new JFrame();
		Container panel = frame.getContentPane();
		panel.setBackground(new Color(240, 248, 255));
		frame.setTitle("Ingreso de Mensaje");
		// seteo coordenadas de la ventana, que no se pueda
		// redimensionar y que al cerrarla cierre la aplicación
		frame.setResizable(false);
		frame.setBounds(100, 100, 273, 128);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// le pongo AbsolutLayout como Layout Manager
		panel.setLayout(null);
		// creo etiqueta para mensaje, seteo sus coordenadas
		// y se la agrego al panel de fondo del JFrame
		labelMensaje = new JLabel("Mensaje:");
		labelMensaje.setBounds(10, 11, 83, 14);
		panel.add(labelMensaje);
		// hago lo mismo con la etiqueta para el tipo de mensaje
		labelTipo = new JLabel("Tipo Mensaje:");
		labelTipo.setBounds(10, 36, 83, 14);
		panel.add(labelTipo);
		// hago lo mismo con el TextField para el mensaje
		textFieldMensaje = new JTextField();
		textFieldMensaje.setBounds(103, 8, 148, 20);
		panel.add(textFieldMensaje);
		// hago lo mismo con el checkbox para el tipo de mensaje
		chkboxTipo = new JCheckBox("Es especial?");
		chkboxTipo.setBackground(new Color(240, 248, 255));
		chkboxTipo.setBounds(102, 32, 97, 23);
		panel.add(chkboxTipo);
		// hago lo mismo con el botón Ingresar
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Arial", Font.BOLD, 12));
		btnIngresar.setBackground(new Color(173, 216, 230));
		btnIngresar.setBounds(94, 65, 89, 23);
		panel.add(btnIngresar);
	} // fin del método initialize, el cual creó la ventana
		// instanció los componentes gráficos y se los agregó
		// El método anterior es privado, ya que se usa
		// solamente en forma interna a la clase. Los siguientes
		// métodos son públicos y son los únicos que se van a
		// invocar desde fuera de la clase

	public void setVisible(boolean b) {
		// setea si la ventana estará visible u oculta
		frame.setVisible(b);
	}

	public VentanaPrueba() {
		// llamo al método que instancia los componentes gráficos
		this.initialize();
		// por último, hago la ventana inicialmente invisible
		this.setVisible(false);
	}

}

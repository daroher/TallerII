package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorRegistrarAlumno;
import sistema.grafica.controladores.ControladorRegistrarAsignatura;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.logica.alumno.Becado;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOAsignatura;
import java.awt.Font;

public class FormularioRegistrarAlumno extends JPanel {

	private JTextField cedulaField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField domicilioField;
	private JTextField telefonoField;
	private JCheckBox becadoCheckBox;
	private JTextField descuentoField;
	private JTextArea razonBecaArea;
	private JButton registrarButton;

	private ControladorRegistrarAlumno controlador;

	// Panel del formulario
	JPanel panelFormulario = new JPanel(new GridLayout(8, 2)) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
		}
	};

	public FormularioRegistrarAlumno() {
		setLayout(new BorderLayout());

		// Crear componentes del formulario
		cedulaField = new JTextField(10);
		nombreField = new JTextField(20);
		apellidoField = new JTextField(20);
		domicilioField = new JTextField(20);
		telefonoField = new JTextField(10);
		becadoCheckBox = new JCheckBox("Becado");
		becadoCheckBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		descuentoField = new JTextField(10);
		razonBecaArea = new JTextArea(5, 20);
		razonBecaArea.setLineWrap(true);
		registrarButton = new JButton("Registrar");

		JLabel label = new JLabel("Cédula:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label);
		panelFormulario.add(cedulaField);
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_1);
		panelFormulario.add(nombreField);
		JLabel label_2 = new JLabel("Apellido:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_2);
		panelFormulario.add(apellidoField);
		JLabel label_3 = new JLabel("Domicilio:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_3);
		panelFormulario.add(domicilioField);
		JLabel label_4 = new JLabel("Teléfono:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_4);
		panelFormulario.add(telefonoField);
		JLabel label_5 = new JLabel("Becado:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_5);
		panelFormulario.add(becadoCheckBox);
		JLabel label_6 = new JLabel("Porcentaje de descuento:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_6);
		panelFormulario.add(descuentoField);
		JLabel label_7 = new JLabel("Razón de la beca:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_7);
		panelFormulario.add(new JScrollPane(razonBecaArea));

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Registro de Alumnos"), BorderLayout.NORTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				

				if (camposValidos()) {
				
					VOAlumnoRegistro vo;
					
					TipoAlumno tipoAlumno;
					if (becadoCheckBox.isSelected()) {
						vo = new VOAlumnoRegistro(Integer.parseInt(cedulaField.getText()), nombreField.getText(), apellidoField.getText(),
								TipoAlumno.BECADO, domicilioField.getText(), telefonoField.getText(), Integer.parseInt(descuentoField.getText()), razonBecaArea.getText());
					} else {
						vo = new VOAlumnoRegistro(Integer.parseInt(cedulaField.getText()), nombreField.getText(), apellidoField.getText(),
								TipoAlumno.NORMAL, domicilioField.getText(), telefonoField.getText(), 0, null);
					}
					
					

					try {
						controlador = new ControladorRegistrarAlumno();
						controlador.registrarAlumno(vo);
						String msg = "Se registró satisfactoriamente el Alumno.";
						JOptionPane.showMessageDialog(panelFormulario, msg);
						vaciarCampos();
					} catch (Exception ex) {
						String msg = ex.getMessage();
						JOptionPane.showMessageDialog(panelFormulario, msg);
					}
				}
			}
		});
	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos() {
		boolean valido = true;

		if (cedulaField.getText().isEmpty()) {
			String msg = "La cedula no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (nombreField.getText().isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (apellidoField.getText().isEmpty()) {
			String msg = "El apellido no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (domicilioField.getText().isEmpty()) {
			String msg = "El domicilio no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (telefonoField.getText().isEmpty()) {
			String msg = "El telefono no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (descuentoField.getText().isEmpty() && becadoCheckBox.isSelected()) {
			String msg = "El porcentaje de la beca.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (razonBecaArea.getText().isEmpty() && becadoCheckBox.isSelected()) {
			String msg = "La razon de la beca no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}

	private void vaciarCampos() {
		cedulaField.setText("");
		nombreField.setText("");
		apellidoField.setText("");
		domicilioField.setText("");
		telefonoField.setText("");
		descuentoField.setText("");
		razonBecaArea.setText("");
	}

}

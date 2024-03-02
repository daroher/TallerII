package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import sistema.logica.alumno.Becado;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;
import sistema.valueobjects.VOAsignatura;

public class FormularioRegistroAlumno extends JPanel {

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
	JPanel panelFormulario = new JPanel(new GridLayout(8, 2));
	
	
	public FormularioRegistroAlumno() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(8, 2));

		// Crear componentes del formulario
		cedulaField = new JTextField(10);
		nombreField = new JTextField(20);
		apellidoField = new JTextField(20);
		domicilioField = new JTextField(20);
		telefonoField = new JTextField(10);
		becadoCheckBox = new JCheckBox("Becado");
		descuentoField = new JTextField(10);
		razonBecaArea = new JTextArea(5, 20);
		razonBecaArea.setLineWrap(true);
		registrarButton = new JButton("Registrar");

		panelFormulario.add(new JLabel("Cédula:"));
		panelFormulario.add(cedulaField);
		panelFormulario.add(new JLabel("Nombre:"));
		panelFormulario.add(nombreField);
		panelFormulario.add(new JLabel("Apellido:"));
		panelFormulario.add(apellidoField);
		panelFormulario.add(new JLabel("Domicilio:"));
		panelFormulario.add(domicilioField);
		panelFormulario.add(new JLabel("Teléfono:"));
		panelFormulario.add(telefonoField);
		panelFormulario.add(new JLabel("Becado:"));
		panelFormulario.add(becadoCheckBox);
		panelFormulario.add(new JLabel("Porcentaje de descuento:"));
		panelFormulario.add(descuentoField);
		panelFormulario.add(new JLabel("Razón de la beca:"));
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

					controlador = new ControladorRegistrarAlumno();
					
					TipoAlumno tipoAlumno;
			        if (becadoCheckBox.isSelected()) {
			        	tipoAlumno = TipoAlumno.BECADO;
			        } else {
			        	tipoAlumno = TipoAlumno.NORMAL;
			        }
								        
			        if (camposValidos()) {			        	
						VOAlumnoRegistro vo = new VOAlumnoRegistro (cedulaField.getX(), nombreField.getText(), apellidoField.getText(), tipoAlumno , domicilioField.getText(), telefonoField.getText(),descuentoField.getX(), razonBecaArea.getText());		        

					try {
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
			} else if (descuentoField.getText().isEmpty()) {
				String msg = "El telefono no puede ser vacío.";
				JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				valido = false;										
			} else if (razonBecaArea.getText().isEmpty()) {
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

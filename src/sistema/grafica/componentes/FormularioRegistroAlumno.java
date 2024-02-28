package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
				// TODO: implementar la lógica de registro
			}
		});
	}

}

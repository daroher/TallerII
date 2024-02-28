package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioRegistroResultado extends JPanel {

	private JTextField cedulaAlumnoField;
	private JTextField notaField;
	private JTextField numInscripcionField;
	private JButton registrarButton;

	public FormularioRegistroResultado() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2));

		// Crear componentes del formulario
		cedulaAlumnoField = new JTextField(10);
		notaField = new JTextField(10);
		numInscripcionField = new JTextField(10);
		registrarButton = new JButton("Registrar Resultado");

		panelFormulario.add(new JLabel("Cédula del Alumno:"));
		panelFormulario.add(cedulaAlumnoField);
		panelFormulario.add(new JLabel("Nota (1 a 12):"));
		panelFormulario.add(notaField);
		panelFormulario.add(new JLabel("Número de Inscripción:"));
		panelFormulario.add(numInscripcionField);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Registro de Resultado de Asignatura"), BorderLayout.NORTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Implementar la lógica de registro de resultado
			}
		});
	}
}

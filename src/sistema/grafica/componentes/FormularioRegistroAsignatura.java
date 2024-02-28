package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormularioRegistroAsignatura extends JPanel {

	private JTextField codigoField;
	private JTextField nombreField;
	private JTextArea descripcionArea;
	private JButton registrarButton;

	public FormularioRegistroAsignatura() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2));

		// Crear componentes del formulario
		codigoField = new JTextField(10);
		nombreField = new JTextField(20);
		registrarButton = new JButton("Registrar");

		panelFormulario.add(new JLabel("Código:"));
		panelFormulario.add(codigoField);
		panelFormulario.add(new JLabel("Nombre:"));
		panelFormulario.add(nombreField);
		panelFormulario.add(new JLabel("Descripción:"));
		descripcionArea = new JTextArea(5, 20);
		descripcionArea.setLineWrap(true);
		panelFormulario.add(new JScrollPane(descripcionArea));

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Registro de Asignaturas"), BorderLayout.NORTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: implementar la lógica de registro
			}
		});
	}
}

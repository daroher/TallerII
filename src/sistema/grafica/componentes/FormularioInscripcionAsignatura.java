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

public class FormularioInscripcionAsignatura extends JPanel {

	private JTextField codigoAsignaturaField;
	private JTextField cedulaAlumnoField;
	private JTextField anioLectivoField;
	private JTextField montoBaseField;
	private JButton registrarButton;

	public FormularioInscripcionAsignatura() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(5, 2));

		// Crear componentes del formulario
		codigoAsignaturaField = new JTextField(10);
		cedulaAlumnoField = new JTextField(10);
		anioLectivoField = new JTextField(10);
		montoBaseField = new JTextField(10);
		registrarButton = new JButton("Registrar Inscripción");

		panelFormulario.add(new JLabel("Código de Asignatura:"));
		panelFormulario.add(codigoAsignaturaField);
		panelFormulario.add(new JLabel("Cédula del Alumno:"));
		panelFormulario.add(cedulaAlumnoField);
		panelFormulario.add(new JLabel("Año Lectivo:"));
		panelFormulario.add(anioLectivoField);
		panelFormulario.add(new JLabel("Monto Base:"));
		panelFormulario.add(montoBaseField);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Registro de Inscripción a Asignatura"), BorderLayout.NORTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Implementar la lógica de registro de inscripción
			}
		});
	}
}
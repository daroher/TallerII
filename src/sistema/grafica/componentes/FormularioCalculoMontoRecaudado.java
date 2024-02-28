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

public class FormularioCalculoMontoRecaudado extends JPanel {

	private JTextField anioLectivoField;
	private JTextField cedulaAlumnoField;
	private JButton calcularButton;
	private JTextField montoRecaudadoField;

	public FormularioCalculoMontoRecaudado() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2));

		// Crear componentes del formulario
		anioLectivoField = new JTextField(10);
		cedulaAlumnoField = new JTextField(10);
		calcularButton = new JButton("Calcular Monto Recaudado");
		montoRecaudadoField = new JTextField(10);
		montoRecaudadoField.setEditable(false);

		panelFormulario.add(new JLabel("Año Lectivo:"));
		panelFormulario.add(anioLectivoField);
		panelFormulario.add(new JLabel("Cédula del Alumno:"));
		panelFormulario.add(cedulaAlumnoField);
		panelFormulario.add(new JLabel("Monto Recaudado:"));
		panelFormulario.add(montoRecaudadoField);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(calcularButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Cálculo de Monto Recaudado por Inscripciones"), BorderLayout.NORTH);

		// Configurar ActionListener para el botón Calcular
		calcularButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Implementar la lógica de cálculo
			}
		});
	}
}

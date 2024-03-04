package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorRegistrarResultado;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VORegistrarResultado;

public class FormularioRegistrarResultado extends JPanel {

	private JTextField cedulaAlumnoField;
	private JTextField notaField;
	private JTextField numInscripcionField;
	private JButton registrarButton;
	private ControladorRegistrarResultado controlador;

	public FormularioRegistrarResultado() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2)){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
			}
		};

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
				controlador = new ControladorRegistrarResultado();
				VORegistrarResultado vo = new VORegistrarResultado(Integer.parseInt(cedulaAlumnoField.getText()), Integer.parseInt(notaField.getText()), Integer.parseInt(numInscripcionField.getText()));
				
				try {
					controlador.registrarResultado(vo);
					String msg = "La nota ha sido registrada exitosamente.";
					JOptionPane.showMessageDialog(panelFormulario, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}

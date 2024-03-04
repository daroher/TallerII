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

import sistema.grafica.controladores.ControladorInscribirAlumnoEnAsignatura;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VOInscribirAlumno;

public class FormularioInscribirAlumnoEnAsignatura extends JPanel {

	private JTextField codigoAsignaturaField;
	private JTextField cedulaAlumnoField;
	private JTextField anioLectivoField;
	private JTextField montoBaseField;
	private JButton registrarButton;
	private ControladorInscribirAlumnoEnAsignatura controlador;

	public FormularioInscribirAlumnoEnAsignatura() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(5, 2)){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
			}
		};

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
				
				VOInscribirAlumno vo = new VOInscribirAlumno(codigoAsignaturaField.getText(),
						Integer.parseInt(cedulaAlumnoField.getText()), Integer.parseInt(anioLectivoField.getText()),
						Float.parseFloat(montoBaseField.getText()));

				try {
					controlador = new ControladorInscribirAlumnoEnAsignatura();
					controlador.inscribirAlumnoEnAsignatura(vo);
					String msg = "Se ha inscripto en la asignatura exitosamente.";
					JOptionPane.showMessageDialog(panelFormulario, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
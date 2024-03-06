package sistema.grafica.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sistema.grafica.controladores.ControladorInscribirAlumnoEnAsignatura;
import sistema.valueobjects.VOInscribirAlumno;

public class FormularioInscribirAlumnoEnAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField codigoField;
	private JTextField cedulaAlumnoField;
	private JTextField anioLectivoField;
	private JTextField montoField;
	private ControladorInscribirAlumnoEnAsignatura controlador;

	public FormularioInscribirAlumnoEnAsignatura(Dimension frameDimension) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setSize(frameDimension);

		JPanel contentPanel = new JPanel();
		contentPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPanel.setAlignmentX(0.0f);
		mainPanel.add(contentPanel);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 5));

		JLabel tituloLabel = new JLabel("Por favor ingrese los datos para la nueva inscripcion.");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(tituloLabel);

		JPanel codigoPanel = new JPanel();
		contentPanel.add(codigoPanel);
		codigoPanel.setLayout(new BoxLayout(codigoPanel, BoxLayout.Y_AXIS));

		JPanel codigoLabelAligner = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) codigoLabelAligner.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		codigoPanel.add(codigoLabelAligner);

		JLabel codigoLabel = new JLabel("Codigo Asignatura");
		codigoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		codigoLabelAligner.add(codigoLabel);
		codigoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		codigoField = new JTextField();
		codigoField.setBackground(new Color(255, 255, 255));
		codigoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codigoField.setHorizontalAlignment(SwingConstants.LEFT);
		codigoPanel.add(codigoField);
		codigoField.setColumns(15);

		JPanel cedulaPanel = new JPanel();
		contentPanel.add(cedulaPanel);
		cedulaPanel.setLayout(new BoxLayout(cedulaPanel, BoxLayout.Y_AXIS));

		JPanel cedulaLabelAligner = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) cedulaLabelAligner.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		cedulaPanel.add(cedulaLabelAligner);

		JLabel cedulaLabel = new JLabel("Cedula");
		cedulaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cedulaLabelAligner.add(cedulaLabel);
		cedulaLabel.setHorizontalAlignment(SwingConstants.CENTER);

		cedulaAlumnoField = new JTextField();
		cedulaAlumnoField.setBackground(new Color(255, 255, 255));
		cedulaAlumnoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cedulaPanel.add(cedulaAlumnoField);
		cedulaAlumnoField.setHorizontalAlignment(SwingConstants.LEFT);
		cedulaAlumnoField.setColumns(15);

		JPanel anioLectivoPanel = new JPanel();
		contentPanel.add(anioLectivoPanel);
		anioLectivoPanel.setLayout(new BoxLayout(anioLectivoPanel, BoxLayout.Y_AXIS));

		JPanel anioLectivoLabelAligner = new JPanel();
		FlowLayout fl_anioLectivoLabelAligner = (FlowLayout) anioLectivoLabelAligner.getLayout();
		fl_anioLectivoLabelAligner.setAlignment(FlowLayout.LEFT);
		anioLectivoPanel.add(anioLectivoLabelAligner);

		JLabel anioLectivoLabel = new JLabel("Año Lectivo");
		anioLectivoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		anioLectivoLabelAligner.add(anioLectivoLabel);
		anioLectivoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		anioLectivoField = new JTextField();
		anioLectivoField.setBackground(new Color(255, 255, 255));
		anioLectivoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		anioLectivoPanel.add(anioLectivoField);
		anioLectivoField.setColumns(15);

		JPanel montoPanel = new JPanel();
		contentPanel.add(montoPanel);
		montoPanel.setLayout(new BoxLayout(montoPanel, BoxLayout.Y_AXIS));

		JPanel montoLabelAligner = new JPanel();
		FlowLayout fl_montoLabelAligner = (FlowLayout) montoLabelAligner.getLayout();
		fl_montoLabelAligner.setAlignment(FlowLayout.LEFT);
		montoPanel.add(montoLabelAligner);

		JLabel montoLabel = new JLabel("Monto Base");
		montoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		montoLabelAligner.add(montoLabel);
		montoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		montoField = new JTextField();
		montoField.setBackground(new Color(255, 255, 255));
		montoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		montoPanel.add(montoField);
		montoField.setColumns(15);

		JPanel botonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonPanel.getLayout();
		contentPanel.add(botonPanel);
		JButton registrarButton = new JButton("Registrar");
		registrarButton.setBackground(new Color(35, 35, 35));
		registrarButton.setForeground(new Color(255, 255, 255));
		registrarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		registrarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonPanel.add(registrarButton);

		codigoLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
		cedulaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		anioLectivoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		montoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		tituloLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));

		codigoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cedulaAlumnoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		anioLectivoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		montoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		codigoField.setPreferredSize(new Dimension(1, 25));
		cedulaAlumnoField.setPreferredSize(new Dimension(1, 25));
		anioLectivoField.setPreferredSize(new Dimension(1, 25));
		montoField.setPreferredSize(new Dimension(1, 25));

		registrarButton.setPreferredSize(new Dimension(120, 45));

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				VOInscribirAlumno vo = new VOInscribirAlumno(codigoField.getText(),
						Integer.parseInt(cedulaAlumnoField.getText()), Integer.parseInt(anioLectivoField.getText()),
						Float.parseFloat(montoField.getText()));

				try {
					controlador = new ControladorInscribirAlumnoEnAsignatura();
					controlador.inscribirAlumnoEnAsignatura(vo);
					String msg = "Se ha inscripto en la asignatura exitosamente.";
					JOptionPane.showMessageDialog(contentPanel, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
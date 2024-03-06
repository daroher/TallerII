package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sistema.grafica.controladores.ControladorRegistrarResultado;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VORegistrarResultado;

public class FormularioRegistrarResultado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField cedulaAlumnoField;
	private JTextField notaField;
	private JTextField numInscripcionField;
	private JButton registrarButton;
	private ControladorRegistrarResultado controlador;

	public FormularioRegistrarResultado(Dimension frameDimension) {
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

		JLabel tituloLabel = new JLabel("Por favor ingrese los datos para calificar asignatura.");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(tituloLabel);

		JPanel cedulaPanel = new JPanel();
		contentPanel.add(cedulaPanel);
		cedulaPanel.setLayout(new BoxLayout(cedulaPanel, BoxLayout.Y_AXIS));

		JPanel cedulaLabelAligner = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) cedulaLabelAligner.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		cedulaPanel.add(cedulaLabelAligner);

		JLabel cedulaLabel = new JLabel("Cedula");
		cedulaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cedulaLabelAligner.add(cedulaLabel);
		cedulaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cedulaAlumnoField = new JTextField();
		cedulaAlumnoField.setBackground(new Color(255, 255, 255));
		cedulaAlumnoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cedulaAlumnoField.setHorizontalAlignment(SwingConstants.LEFT);
		cedulaPanel.add(cedulaAlumnoField);
		cedulaAlumnoField.setColumns(15);

		JPanel notaPanel = new JPanel();
		contentPanel.add(notaPanel);
		notaPanel.setLayout(new BoxLayout(notaPanel, BoxLayout.Y_AXIS));

		JPanel notaLabelAligner = new JPanel();
		FlowLayout fl_notaLabelAligner = (FlowLayout) notaLabelAligner.getLayout();
		fl_notaLabelAligner.setAlignment(FlowLayout.LEFT);
		notaPanel.add(notaLabelAligner);

		JLabel notaLabel = new JLabel("Nota (1 a 12)");
		notaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		notaLabelAligner.add(notaLabel);
		notaLabel.setHorizontalAlignment(SwingConstants.CENTER);

		notaField = new JTextField();
		notaField.setBackground(new Color(255, 255, 255));
		notaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		notaPanel.add(notaField);
		notaField.setColumns(15);

		JPanel numInscripcionPanel = new JPanel();
		contentPanel.add(numInscripcionPanel);
		numInscripcionPanel.setLayout(new BoxLayout(numInscripcionPanel, BoxLayout.Y_AXIS));

		JPanel numInscripcionLabelAligner = new JPanel();
		FlowLayout fl_numInscripcionLabelAligner = (FlowLayout) numInscripcionLabelAligner.getLayout();
		fl_numInscripcionLabelAligner.setAlignment(FlowLayout.LEFT);
		numInscripcionPanel.add(numInscripcionLabelAligner);

		JLabel numInscripcionLabel = new JLabel("Numero de Inscripcion");
		numInscripcionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		numInscripcionLabelAligner.add(numInscripcionLabel);
		numInscripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);

		numInscripcionField = new JTextField();
		numInscripcionField.setBackground(new Color(255, 255, 255));
		numInscripcionField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numInscripcionPanel.add(numInscripcionField);
		numInscripcionField.setColumns(15);

		JPanel botonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonPanel.getLayout();
		contentPanel.add(botonPanel);
		registrarButton = new JButton("Registrar Resultado");
		registrarButton.setBackground(new Color(35, 35, 35));
		registrarButton.setForeground(new Color(255, 255, 255));
		registrarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		registrarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonPanel.add(registrarButton);

		cedulaLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
		notaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		numInscripcionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		tituloLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));

		cedulaAlumnoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		notaField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		numInscripcionField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		cedulaAlumnoField.setPreferredSize(new Dimension(1, 25));
		notaField.setPreferredSize(new Dimension(1, 25));
		numInscripcionField.setPreferredSize(new Dimension(1, 25));

		registrarButton.setPreferredSize(new Dimension(170, 45));

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				VORegistrarResultado vo = new VORegistrarResultado(Integer.parseInt(cedulaAlumnoField.getText()),
						Integer.parseInt(notaField.getText()), Integer.parseInt(numInscripcionField.getText()));

				try {
					controlador = new ControladorRegistrarResultado();
					controlador.registrarResultado(vo);
					String msg = "La nota ha sido registrada exitosamente.";
					JOptionPane.showMessageDialog(contentPanel, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}

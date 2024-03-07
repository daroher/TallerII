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

import sistema.grafica.controladores.ControladorCalcularMontoRecaudado;
import sistema.utilidades.Utilidades;
import sistema.valueobjects.VOMontoRecaudado;

public class FormularioCalcularMontoRecaudado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField anioLectivoField;
	private JTextField cedulaAlumnoField;
	private JButton calcularButton;
	private JTextField montoRecaudadoField;
	private JPanel montoPanel;
	private ControladorCalcularMontoRecaudado controlador;

	public FormularioCalcularMontoRecaudado(Dimension frameDimension) {
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

		JLabel tituloLabel = new JLabel("Por favor ingrese los datos para el calculo.");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(tituloLabel);

		JPanel anioLectivoPanel = new JPanel();
		contentPanel.add(anioLectivoPanel);
		anioLectivoPanel.setLayout(new BoxLayout(anioLectivoPanel, BoxLayout.Y_AXIS));

		JPanel anioLectivoLabelAligner = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) anioLectivoLabelAligner.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		anioLectivoPanel.add(anioLectivoLabelAligner);

		JLabel anioLectivoLabel = new JLabel("Año Lectivo");
		anioLectivoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		anioLectivoLabelAligner.add(anioLectivoLabel);
		anioLectivoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		anioLectivoField = new JTextField();
		anioLectivoField.setBackground(new Color(255, 255, 255));
		anioLectivoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		anioLectivoField.setHorizontalAlignment(SwingConstants.LEFT);
		anioLectivoPanel.add(anioLectivoField);
		anioLectivoField.setColumns(15);

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

		montoPanel = new JPanel();
		contentPanel.add(montoPanel);
		montoPanel.setLayout(new BoxLayout(montoPanel, BoxLayout.Y_AXIS));

		JPanel montoLabelAligner = new JPanel();
		FlowLayout fl_montoLabelAligner = (FlowLayout) montoLabelAligner.getLayout();
		fl_montoLabelAligner.setAlignment(FlowLayout.LEFT);
		montoPanel.add(montoLabelAligner);

		JLabel montoLabel = new JLabel("Monto Recaudado");
		montoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		montoLabelAligner.add(montoLabel);
		montoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		montoRecaudadoField = new JTextField();
		montoRecaudadoField.setHorizontalAlignment(SwingConstants.CENTER);
		montoRecaudadoField.setForeground(new Color(255, 255, 255));
		montoRecaudadoField.setBackground(new Color(0, 0, 0));
		montoRecaudadoField.setFont(new Font("Consolas", Font.BOLD, 18));
		montoPanel.add(montoRecaudadoField);
		montoRecaudadoField.setColumns(15);
		montoRecaudadoField.setEditable(false);

		JPanel botonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonPanel.getLayout();
		contentPanel.add(botonPanel);
		calcularButton = new JButton("Calcular");
		calcularButton.setBackground(new Color(35, 35, 35));
		calcularButton.setForeground(new Color(255, 255, 255));
		calcularButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcularButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonPanel.add(calcularButton);

		anioLectivoLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
		cedulaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		montoLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		tituloLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));

		anioLectivoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cedulaAlumnoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		montoRecaudadoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		anioLectivoField.setPreferredSize(new Dimension(1, 25));
		cedulaAlumnoField.setPreferredSize(new Dimension(1, 25));
		montoRecaudadoField.setPreferredSize(new Dimension(100, 60));

		calcularButton.setPreferredSize(new Dimension(120, 45));
		
		montoPanel.setVisible(false);

		// Configurar ActionListener para el botón Calcular
		calcularButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador = new ControladorCalcularMontoRecaudado();
					VOMontoRecaudado montoRecaudado = controlador.calcularMontoRecaudado(cedulaAlumnoField.getText(), anioLectivoField.getText());
					String montoParseado = Utilidades.convertirTextoAFormatoMoneda(String.valueOf(montoRecaudado.getMontoRecaudado()));
					
					montoRecaudadoField.setText(montoParseado);
					
					montoPanel.setVisible(true);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void setMontoPanelVisible() {
		montoPanel.setVisible(false);
	}
}

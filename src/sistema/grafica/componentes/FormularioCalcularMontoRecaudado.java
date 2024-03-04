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

import sistema.grafica.controladores.ControladorCalcularMontoRecaudado;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VOCalcularMontoRecaudado;
import sistema.valueobjects.VOMontoRecaudado;

public class FormularioCalcularMontoRecaudado extends JPanel {

	private JTextField anioLectivoField;
	private JTextField cedulaAlumnoField;
	private JButton calcularButton;
	private JTextField montoRecaudadoField;
	private ControladorCalcularMontoRecaudado controlador;

	public FormularioCalcularMontoRecaudado() {
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
				
				VOCalcularMontoRecaudado vo = new VOCalcularMontoRecaudado(Integer.parseInt(cedulaAlumnoField.getText()), Integer.parseInt(anioLectivoField.getText()));
			
				try {
					controlador = new ControladorCalcularMontoRecaudado();
					VOMontoRecaudado montoRecaudado = controlador.calcularMontoRecaudado(vo);
					montoRecaudadoField.setText(String.valueOf(montoRecaudado.getMontoRecaudado()));
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}

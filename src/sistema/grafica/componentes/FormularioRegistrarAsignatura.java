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

import sistema.grafica.controladores.ControladorRegistrarAsignatura;

public class FormularioRegistrarAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nombreField;
	private JTextField descripcionField;
	private JTextField codigoField;
	private ControladorRegistrarAsignatura controlador;

	public FormularioRegistrarAsignatura(Dimension frameDimension) {
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
        
        JLabel tituloLabel = new JLabel("Por favor ingrese los datos para la nueva asignatura.");
        tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPanel.add(tituloLabel);
        
        JPanel codigoPanel = new JPanel();
        contentPanel.add(codigoPanel);
        codigoPanel.setLayout(new BoxLayout(codigoPanel, BoxLayout.Y_AXIS));
        
        JPanel codigoLabelAligner = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) codigoLabelAligner.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        codigoPanel.add(codigoLabelAligner);
        
        JLabel codigoLabel = new JLabel("Codigo");
        codigoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        codigoLabelAligner.add(codigoLabel);
        codigoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField codigoField = new JTextField();
        codigoField.setBackground(new Color(255, 255, 255));
        codigoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        codigoField.setHorizontalAlignment(SwingConstants.LEFT);
        codigoPanel.add(codigoField);
        codigoField.setColumns(15);
        
        JPanel nombrePanel = new JPanel();
        contentPanel.add(nombrePanel);
        nombrePanel.setLayout(new BoxLayout(nombrePanel, BoxLayout.Y_AXIS));
        
        JPanel nombreLabelAligner = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) nombreLabelAligner.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        nombrePanel.add(nombreLabelAligner);
        
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nombreLabelAligner.add(nombreLabel);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        nombreField = new JTextField();
        nombreField.setBackground(new Color(255, 255, 255));
        nombreField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nombrePanel.add(nombreField);
        nombreField.setHorizontalAlignment(SwingConstants.LEFT);
        nombreField.setColumns(15);
        
        JPanel descripcionPanel = new JPanel();
        contentPanel.add(descripcionPanel);
        descripcionPanel.setLayout(new BoxLayout(descripcionPanel, BoxLayout.Y_AXIS));
        
        JPanel descripcionLabelAligner = new JPanel();
        FlowLayout fl_descripcionLabelAligner = (FlowLayout) descripcionLabelAligner.getLayout();
        fl_descripcionLabelAligner.setAlignment(FlowLayout.LEFT);
        descripcionPanel.add(descripcionLabelAligner);
        
        JLabel descripcionLabel = new JLabel("Descripcion");
        descripcionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        descripcionLabelAligner.add(descripcionLabel);
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        descripcionField = new JTextField();
        descripcionField.setBackground(new Color(255, 255, 255));
        descripcionField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        descripcionPanel.add(descripcionField);
        descripcionField.setColumns(15);
        
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
        nombreLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        descripcionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
        
        codigoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        nombreField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        descripcionField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        codigoField.setPreferredSize(new Dimension(1, 25)); 
        nombreField.setPreferredSize(new Dimension(1, 25)); 
        descripcionField.setPreferredSize(new Dimension(1, 25)); 
        
        registrarButton.setPreferredSize(new Dimension(120, 45)); 
        
		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador = new ControladorRegistrarAsignatura();
					String msg = controlador.registrarAsignatura(codigoField.getText(), nombreField.getText(), descripcionField.getText());
					JOptionPane.showMessageDialog(contentPanel, msg);
					vaciarCampos();
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	private void vaciarCampos() {
		codigoField.setText("");
		nombreField.setText("");
		descripcionField.setText("");
	}
}

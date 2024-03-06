package sistema.grafica.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sistema.grafica.controladores.ControladorRegistrarAlumno;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoRegistro;
import java.awt.Font;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FormularioRegistrarAlumno extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField cedulaField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField domicilioField;
	private JTextField telefonoField;
	private JCheckBox becadoCheckBox;
	private JTextField becaField;
	private JTextField razonBecaField;

	private ControladorRegistrarAlumno controlador;
	private JTextField textField;

	public FormularioRegistrarAlumno(Dimension frameDimension) {
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
        
        JLabel tituloLabel = new JLabel("Por favor ingrese los datos para el nuevo alumno.");
        contentPanel.add(tituloLabel);
        tituloLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
        
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
        cedulaField = new JTextField();
        cedulaField.setBackground(new Color(255, 255, 255));
        cedulaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cedulaField.setHorizontalAlignment(SwingConstants.LEFT);
        cedulaPanel.add(cedulaField);
        cedulaField.setColumns(15);
        
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
        
        JPanel apellidoPanel = new JPanel();
        contentPanel.add(apellidoPanel);
        apellidoPanel.setLayout(new BoxLayout(apellidoPanel, BoxLayout.Y_AXIS));
        
        JPanel apellidoLabelAligner = new JPanel();
        FlowLayout fl_apellidoLabelAligner = (FlowLayout) apellidoLabelAligner.getLayout();
        fl_apellidoLabelAligner.setAlignment(FlowLayout.LEFT);
        apellidoPanel.add(apellidoLabelAligner);
        
        JLabel apellidoLabel = new JLabel("Apellido");
        apellidoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        apellidoLabelAligner.add(apellidoLabel);
        apellidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        apellidoField = new JTextField();
        apellidoField.setBackground(new Color(255, 255, 255));
        apellidoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        apellidoPanel.add(apellidoField);
        apellidoField.setColumns(15);
        
        
        JPanel domicilioPanel = new JPanel();
        contentPanel.add(domicilioPanel);
        domicilioPanel.setLayout(new BoxLayout(domicilioPanel, BoxLayout.Y_AXIS));
        
        JPanel domicilioLabelAligner = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) domicilioLabelAligner.getLayout();
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        domicilioPanel.add(domicilioLabelAligner);
        
        JLabel domicilioLabel = new JLabel("Domicilio");
        domicilioLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        domicilioLabelAligner.add(domicilioLabel);
        domicilioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        domicilioField = new JTextField();
        domicilioField.setBackground(new Color(255, 255, 255));
        domicilioField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        domicilioField.setHorizontalAlignment(SwingConstants.LEFT);
        domicilioPanel.add(domicilioField);
        domicilioField.setColumns(15);
        
        
        
        JPanel telefonoPanel = new JPanel();
        contentPanel.add(telefonoPanel);
        telefonoPanel.setLayout(new BoxLayout(telefonoPanel, BoxLayout.Y_AXIS));
        
        JPanel telefonoLabelAligner = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) telefonoLabelAligner.getLayout();
        flowLayout_4.setAlignment(FlowLayout.LEFT);
        telefonoPanel.add(telefonoLabelAligner);
        
        JLabel telefonoLabel = new JLabel("Telefono");
        telefonoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        telefonoLabelAligner.add(telefonoLabel);
        telefonoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        telefonoField = new JTextField();
        telefonoField.setBackground(new Color(255, 255, 255));
        telefonoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        telefonoField.setHorizontalAlignment(SwingConstants.LEFT);
        telefonoPanel.add(telefonoField);
        telefonoField.setColumns(15);
        
        
        JPanel becadoCheckboxPanel = new JPanel();
        contentPanel.add(becadoCheckboxPanel);
        becadoCheckboxPanel.setLayout(new BoxLayout(becadoCheckboxPanel, BoxLayout.Y_AXIS));
        
        JPanel becadoCheckboxAligner = new JPanel();
        FlowLayout flowLayout_5 = (FlowLayout) becadoCheckboxAligner.getLayout();
        flowLayout_5.setAlignment(FlowLayout.LEFT);
        becadoCheckboxPanel.add(becadoCheckboxAligner);
        
        becadoCheckBox = new JCheckBox("Es el alumno un becado?");
        becadoCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
        becadoCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        becadoCheckboxAligner.add(becadoCheckBox);
        
        
        
        JPanel becaPanel = new JPanel();
        contentPanel.add(becaPanel);
        becaPanel.setLayout(new BoxLayout(becaPanel, BoxLayout.Y_AXIS));
        
        JPanel becaLabelAligner = new JPanel();
        FlowLayout flowLayout_6 = (FlowLayout) becaLabelAligner.getLayout();
        flowLayout_6.setAlignment(FlowLayout.LEFT);
        becaPanel.add(becaLabelAligner);
        
        JLabel becaLabel = new JLabel("Descuento Beca");
        becaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        becaLabelAligner.add(becaLabel);
        becaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        becaField = new JTextField();
        becaField.setBackground(new Color(255, 255, 255));
        becaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        becaField.setHorizontalAlignment(SwingConstants.LEFT);
        becaPanel.add(becaField);
        becaField.setColumns(15);
        becaPanel.setVisible(false);
        
        JPanel razonBecaPanel = new JPanel();
        contentPanel.add(razonBecaPanel);
        razonBecaPanel.setLayout(new BoxLayout(razonBecaPanel, BoxLayout.Y_AXIS));
        
        JPanel razonBecaLabelAligner = new JPanel();
        FlowLayout flowLayout_7 = (FlowLayout) razonBecaLabelAligner.getLayout();
        flowLayout_7.setAlignment(FlowLayout.LEFT);
        razonBecaPanel.add(razonBecaLabelAligner);
        
        JLabel razonBecaLabel = new JLabel("Razon Beca");
        razonBecaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        razonBecaLabelAligner.add(razonBecaLabel);
        razonBecaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        razonBecaField = new JTextField();
        razonBecaField.setBackground(new Color(255, 255, 255));
        razonBecaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        razonBecaField.setHorizontalAlignment(SwingConstants.LEFT);
        razonBecaPanel.add(razonBecaField);
        razonBecaField.setColumns(15);
        razonBecaPanel.setVisible(false);
        
        
        
        JPanel botonPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) botonPanel.getLayout();
        contentPanel.add(botonPanel);
        JButton registrarButton = new JButton("Registrar");
        registrarButton.setBackground(new Color(35, 35, 35));
        registrarButton.setForeground(new Color(255, 255, 255));
        registrarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        registrarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonPanel.add(registrarButton);
        
        cedulaLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
        nombreLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        apellidoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        domicilioLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        telefonoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        becaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        razonBecaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        cedulaField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        nombreField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        apellidoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        domicilioField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        telefonoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        becaField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        razonBecaField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        cedulaField.setPreferredSize(new Dimension(1, 25)); 
        nombreField.setPreferredSize(new Dimension(1, 25)); 
        apellidoField.setPreferredSize(new Dimension(1, 25)); 
        domicilioField.setPreferredSize(new Dimension(1, 25)); 
        telefonoField.setPreferredSize(new Dimension(1, 25)); 
        becaField.setPreferredSize(new Dimension(1, 25)); 
        razonBecaField.setPreferredSize(new Dimension(1, 25)); 
//        tituloLabel.setPreferredSize(new Dimension(100, 55)); 
        
        registrarButton.setPreferredSize(new Dimension(120, 45));  

        
        becadoCheckBox.addItemListener(new ItemListener() {
        	@Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	becaPanel.setVisible(true);
                	razonBecaPanel.setVisible(true);
                } else {
                	becaPanel.setVisible(false);
                	razonBecaPanel.setVisible(false);
                }
            }
        });
        
        
		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (camposValidos(mainPanel)) {
				
					VOAlumnoRegistro vo;
					
					TipoAlumno tipoAlumno;
					if (becadoCheckBox.isSelected()) {
						vo = new VOAlumnoRegistro(Integer.parseInt(cedulaField.getText()), nombreField.getText(), apellidoField.getText(),
								TipoAlumno.BECADO, domicilioField.getText(), becaField.getText(), Integer.parseInt(becaField.getText()), razonBecaField.getText());
					} else {
						vo = new VOAlumnoRegistro(Integer.parseInt(cedulaField.getText()), nombreField.getText(), apellidoField.getText(),
								TipoAlumno.NORMAL, domicilioField.getText(), becaField.getText(), 0, null);
					}
					
					

					try {
						controlador = new ControladorRegistrarAlumno();
						controlador.registrarAlumno(vo);
						String msg = "Se registró satisfactoriamente el Alumno.";
						JOptionPane.showMessageDialog(mainPanel, msg);
						vaciarCampos();
					} catch (Exception ex) {
						String msg = ex.getMessage();
						JOptionPane.showMessageDialog(mainPanel, msg);
					}
				}
			}
		});
	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos(JPanel mainPanel) {
		boolean valido = true;

		if (cedulaField.getText().isEmpty()) {
			String msg = "La cedula no puede ser vacía.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (nombreField.getText().isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (apellidoField.getText().isEmpty()) {
			String msg = "El apellido no puede ser vacío.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (domicilioField.getText().isEmpty()) {
			String msg = "El domicilio no puede ser vacío.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (telefonoField.getText().isEmpty()) {
			String msg = "El telefono no puede ser vacío.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (becaField.getText().isEmpty() && becadoCheckBox.isSelected()) {
			String msg = "El porcentaje de la beca.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (razonBecaField.getText().isEmpty() && becadoCheckBox.isSelected()) {
			String msg = "La razon de la beca no puede ser vacía.";
			JOptionPane.showMessageDialog(mainPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}

	private void vaciarCampos() {
		cedulaField.setText("");
		nombreField.setText("");
		apellidoField.setText("");
		domicilioField.setText("");
		telefonoField.setText("");
		becaField.setText("");
		razonBecaField.setText("");
	}

}

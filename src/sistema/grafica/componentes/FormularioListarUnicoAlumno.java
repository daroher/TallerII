package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorListarUnicoAlumno;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class FormularioListarUnicoAlumno extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel cedulaLabel;

	private JTextField cedulaField;
	private JButton buscarButton;
	JPanel panelFormulario;

	private ControladorListarUnicoAlumno controlador;
	private JPanel cedulaLabelPanel;
	private JPanel cedulaDatoPanel;
	private JLabel cedulaDatoField;
	private JPanel nombreLabelPanel;
	private JLabel nombreLabel;
	private JPanel nombreDatoPanel;
	private JLabel nombreDatoField;
	private JPanel apellidoLabelPanel;
	private JLabel apellidoLabel;
	private JPanel apellidoDatoPanel;
	private JLabel apellidoDatoField;
	private JPanel domicilioLabelPanel;
	private JLabel domicilioLabel;
	private JPanel domicilioDatoPanel;
	private JLabel domicilioDatoField;
	private JPanel telefonoLabelPanel;
	private JLabel telefonoLabel;
	private JPanel telefonoDatoPanel;
	private JLabel telefonoDatoField;
	private JPanel asignaturasAprobadasLabelPanel;
	private JLabel asignaturasAprobadasLabel;
	private JPanel asignaturasAprobadasDatoPanel;
	private JLabel asignaturasAprobadasDatoField;
	private JPanel tipoAlumnoLabelPanel;
	private JLabel tipoAlumnoLabel;
	private JPanel tipoAlumnoDatoPanel;
	private JLabel tipoAlumnoDatoField;
	private JPanel descuentoLabelPanel;
	private JLabel descuentoLabel;
	private JPanel descuentoDatoPanel;
	private JLabel descuentoDatoField;
	private JPanel razonBecaLabelPanel;
	private JLabel razonBecaLabel;
	private JPanel razonBecaDatoPanel;
	private JLabel razonBecaDatoField;

	public FormularioListarUnicoAlumno(Dimension frameDimension) {
		setLayout(new BorderLayout());

		// Configurar el título
		JLabel label = new JLabel("Detalles Alumno");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label, BorderLayout.NORTH);

		// Panel para el contenido
		panelFormulario = new JPanel();
		
		panelFormulario.setLayout(new BorderLayout(0, 0));

		// Panel para los componentes de entrada y el botón de búsqueda
		JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cedulaField = new JTextField(10);
		buscarButton = new JButton("Buscar");

		JLabel busquedaCedulaLabel = new JLabel("Cedula:");
		panelInput.add(busquedaCedulaLabel);
		panelInput.add(cedulaField);
		panelInput.add(buscarButton);

		// Agregar el panel de entrada al panel de formulario
		panelFormulario.add(panelInput, BorderLayout.NORTH);

		JPanel panelDatos = new JPanel(new GridLayout(9, 2, 5, 5));
		
		cedulaLabelPanel = new JPanel();
		cedulaLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout fl_cedulaLabelPanel = (FlowLayout) cedulaLabelPanel.getLayout();
		fl_cedulaLabelPanel.setAlignment(FlowLayout.LEFT);
		fl_cedulaLabelPanel.setVgap(0);
		fl_cedulaLabelPanel.setHgap(0);
		panelDatos.add(cedulaLabelPanel);
		
				cedulaLabel = new JLabel("Cédula:");
				cedulaLabelPanel.add(cedulaLabel);

		// Configurar el diseño del formulario
		add(panelFormulario, BorderLayout.CENTER);
		panelFormulario.add(panelDatos, BorderLayout.CENTER);

		// Panel para el botón Volver
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton volverButton = new JButton("Volver");
		botonPanel.add(volverButton);

		// Añadir paneles al formulario
		panelFormulario.add(botonPanel, BorderLayout.SOUTH);
		
		busquedaCedulaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		busquedaCedulaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		
		buscarButton.setBackground(new Color(0, 88, 176));
		buscarButton.setForeground(new Color(255, 255, 255));
		buscarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		buscarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buscarButton.setPreferredSize(new Dimension(110, 32)); 
		
		volverButton.setBackground(new Color(35, 35, 35));
		volverButton.setForeground(new Color(255, 255, 255));
		volverButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		volverButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volverButton.setPreferredSize(new Dimension(110, 35)); 
		
		cedulaField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cedulaField.setPreferredSize(new Dimension(1, 27)); 

		Border emptyBorder = BorderFactory.createEmptyBorder(15, 20, 20, 20);
		Border solidBorder = BorderFactory.createLineBorder(new Color(230, 230, 230), 7);
		Border compoundBorder = BorderFactory.createCompoundBorder(solidBorder, emptyBorder);
		panelDatos.setBorder(compoundBorder);
		panelInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		cedulaDatoPanel = new JPanel();
		cedulaDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout = (FlowLayout) cedulaDatoPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panelDatos.add(cedulaDatoPanel);
		
		cedulaDatoField = new JLabel("");
		cedulaDatoPanel.add(cedulaDatoField);
		
		nombreLabelPanel = new JPanel();
		nombreLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_1 = (FlowLayout) nombreLabelPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panelDatos.add(nombreLabelPanel);
		
		nombreLabel = new JLabel("Nombre:");
		nombreLabelPanel.add(nombreLabel);
		
		nombreDatoPanel = new JPanel();
		nombreDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_2 = (FlowLayout) nombreDatoPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		panelDatos.add(nombreDatoPanel);
		
		nombreDatoField = new JLabel("");
		nombreDatoPanel.add(nombreDatoField);
		
		apellidoLabelPanel = new JPanel();
		apellidoLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_3 = (FlowLayout) apellidoLabelPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		panelDatos.add(apellidoLabelPanel);
		
		apellidoLabel = new JLabel("Apellido:");
		apellidoLabelPanel.add(apellidoLabel);
		
		apellidoDatoPanel = new JPanel();
		apellidoDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_4 = (FlowLayout) apellidoDatoPanel.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		panelDatos.add(apellidoDatoPanel);
		
		apellidoDatoField = new JLabel("");
		apellidoDatoPanel.add(apellidoDatoField);
		
		domicilioLabelPanel = new JPanel();
		domicilioLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_5 = (FlowLayout) domicilioLabelPanel.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		panelDatos.add(domicilioLabelPanel);
		
		domicilioLabel = new JLabel("Domicilio:");
		domicilioLabelPanel.add(domicilioLabel);
		
		domicilioDatoPanel = new JPanel();
		domicilioDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_6 = (FlowLayout) domicilioDatoPanel.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		flowLayout_6.setVgap(0);
		flowLayout_6.setHgap(0);
		panelDatos.add(domicilioDatoPanel);
		
		domicilioDatoField = new JLabel("");
		domicilioDatoPanel.add(domicilioDatoField);
		
		telefonoLabelPanel = new JPanel();
		telefonoLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_7 = (FlowLayout) telefonoLabelPanel.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		flowLayout_7.setVgap(0);
		flowLayout_7.setHgap(0);
		panelDatos.add(telefonoLabelPanel);
		
		telefonoLabel = new JLabel("Telefono:");
		telefonoLabelPanel.add(telefonoLabel);
		
		telefonoDatoPanel = new JPanel();
		telefonoDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_8 = (FlowLayout) telefonoDatoPanel.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		flowLayout_8.setVgap(0);
		flowLayout_8.setHgap(0);
		panelDatos.add(telefonoDatoPanel);
		
		telefonoDatoField = new JLabel("");
		telefonoDatoPanel.add(telefonoDatoField);
		
		asignaturasAprobadasLabelPanel = new JPanel();
		asignaturasAprobadasLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_9 = (FlowLayout) asignaturasAprobadasLabelPanel.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		flowLayout_9.setVgap(0);
		flowLayout_9.setHgap(0);
		panelDatos.add(asignaturasAprobadasLabelPanel);
		
		asignaturasAprobadasLabel = new JLabel("Asignaturas Aprobadas:");
		asignaturasAprobadasLabelPanel.add(asignaturasAprobadasLabel);
		
		asignaturasAprobadasDatoPanel = new JPanel();
		asignaturasAprobadasDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_10 = (FlowLayout) asignaturasAprobadasDatoPanel.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		flowLayout_10.setVgap(0);
		flowLayout_10.setHgap(0);
		panelDatos.add(asignaturasAprobadasDatoPanel);
		
		asignaturasAprobadasDatoField = new JLabel("");
		asignaturasAprobadasDatoPanel.add(asignaturasAprobadasDatoField);
		
		tipoAlumnoLabelPanel = new JPanel();
		tipoAlumnoLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_11 = (FlowLayout) tipoAlumnoLabelPanel.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		flowLayout_11.setVgap(0);
		flowLayout_11.setHgap(0);
		panelDatos.add(tipoAlumnoLabelPanel);
		
		tipoAlumnoLabel = new JLabel("Tipo de Alumno:");
		tipoAlumnoLabelPanel.add(tipoAlumnoLabel);
		
		tipoAlumnoDatoPanel = new JPanel();
		tipoAlumnoDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_12 = (FlowLayout) tipoAlumnoDatoPanel.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		flowLayout_12.setVgap(0);
		flowLayout_12.setHgap(0);
		panelDatos.add(tipoAlumnoDatoPanel);
		
		tipoAlumnoDatoField = new JLabel("");
		tipoAlumnoDatoPanel.add(tipoAlumnoDatoField);
		
		descuentoLabelPanel = new JPanel();
		descuentoLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_13 = (FlowLayout) descuentoLabelPanel.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		flowLayout_13.setVgap(0);
		flowLayout_13.setHgap(0);
		panelDatos.add(descuentoLabelPanel);
		
		descuentoLabel = new JLabel("Descuento:");
		descuentoLabelPanel.add(descuentoLabel);
		
		descuentoDatoPanel = new JPanel();
		descuentoDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_14 = (FlowLayout) descuentoDatoPanel.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
		flowLayout_14.setVgap(0);
		flowLayout_14.setHgap(0);
		panelDatos.add(descuentoDatoPanel);
		
		descuentoDatoField = new JLabel("");
		descuentoDatoPanel.add(descuentoDatoField);
		
		razonBecaLabelPanel = new JPanel();
		razonBecaLabelPanel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout_15 = (FlowLayout) razonBecaLabelPanel.getLayout();
		flowLayout_15.setAlignment(FlowLayout.LEFT);
		flowLayout_15.setVgap(0);
		flowLayout_15.setHgap(0);
		panelDatos.add(razonBecaLabelPanel);
		
		razonBecaLabel = new JLabel("Razon de Beca:");
		razonBecaLabelPanel.add(razonBecaLabel);
		
		razonBecaDatoPanel = new JPanel();
		razonBecaDatoPanel.setBackground(new Color(221, 221, 221));
		FlowLayout flowLayout_16 = (FlowLayout) razonBecaDatoPanel.getLayout();
		flowLayout_16.setAlignment(FlowLayout.LEFT);
		flowLayout_16.setVgap(0);
		flowLayout_16.setHgap(0);
		panelDatos.add(razonBecaDatoPanel);
		
		razonBecaDatoField = new JLabel("");
		razonBecaDatoPanel.add(razonBecaDatoField);
		
		
		cedulaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cedulaLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		apellidoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		apellidoLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		domicilioLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		domicilioLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		telefonoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		telefonoLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		asignaturasAprobadasLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		asignaturasAprobadasLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		tipoAlumnoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		tipoAlumnoLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		descuentoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		descuentoLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		razonBecaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		razonBecaLabel.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		
		cedulaDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cedulaDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		nombreDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		apellidoDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		apellidoDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		domicilioDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		domicilioDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		telefonoDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telefonoDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		asignaturasAprobadasDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asignaturasAprobadasDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		tipoAlumnoDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tipoAlumnoDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		descuentoDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descuentoDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		razonBecaDatoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		razonBecaDatoField.setBorder(BorderFactory.createEmptyBorder(14, 80, 0, 0));
		
		descuentoLabelPanel.setVisible(false);
		descuentoDatoPanel.setVisible(false);
		razonBecaLabelPanel.setVisible(false);
		razonBecaDatoPanel.setVisible(false);

		// Configurar ActionListener para el botón buscar
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador = new ControladorListarUnicoAlumno();
					VOAlumnoCompleto alumno = controlador.listarUnicoAlumno(cedulaField.getText());
					cargarDatos(alumno);
					
					if (alumno.getTipoAlumno() == TipoAlumno.BECADO) {
						descuentoLabelPanel.setVisible(true);
						descuentoDatoPanel.setVisible(true);
						razonBecaLabelPanel.setVisible(true);
						razonBecaDatoPanel.setVisible(true);
					}
				} catch (Exception ex) {
					vaciarCampos();
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}


	public void cargarDatos(VOAlumnoCompleto alumno) {

		vaciarCampos();
		cedulaDatoField.setText(String.valueOf(alumno.getCedula()));
		nombreDatoField.setText(alumno.getNombre());
		apellidoDatoField.setText(alumno.getApellido());
		domicilioDatoField.setText(alumno.getDomicilio());
		telefonoDatoField.setText(alumno.getTelefono());
		asignaturasAprobadasDatoField.setText(String.valueOf(alumno.getCantAprobadas()));
		tipoAlumnoDatoField.setText(alumno.getTipoAlumno().name());
		
		if(alumno.getTipoAlumno() == TipoAlumno.BECADO) {
			descuentoDatoField.setText(String.valueOf(alumno.getPorcentajeBeca()));
			razonBecaDatoField.setText(alumno.getRazonBeca());
		}
		
	}

	private void vaciarCampos() {
		cedulaDatoField.setText("");
		nombreDatoField.setText("");
		apellidoDatoField.setText("");
		domicilioDatoField.setText("");
		telefonoDatoField.setText("");
		asignaturasAprobadasDatoField.setText("");
		tipoAlumnoDatoField.setText("");
		descuentoDatoField.setText("");
		razonBecaDatoField.setText("");
	}

}

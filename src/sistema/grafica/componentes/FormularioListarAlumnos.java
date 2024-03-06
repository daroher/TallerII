package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarAlumnos;
import sistema.grafica.controladores.ControladorListarAsignaturas;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOListarAlumnos;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;

public class FormularioListarAlumnos extends JPanel {

	private static final long serialVersionUID = 1L;

	private ControladorListarAlumnos controlador;
	private JTextField apellidoPrefijoField;
	private JTable alumnosTable;
	private DefaultTableModel tableModel;

	private JPanel contentPanel;

	private JPanel mainPanel;

	public FormularioListarAlumnos(Dimension frameDimension) {

		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.addColumn("Cedula");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellido");
		tableModel.addColumn("Tipo");
		
		alumnosTable = new JTable(tableModel);
		alumnosTable.setRowMargin(2);
		alumnosTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alumnosTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		alumnosTable.setOpaque(false);
		alumnosTable.setRowHeight(23);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel tituloLabelAligner = new JPanel();
		mainPanel.add(tituloLabelAligner, BorderLayout.NORTH);
		
		JLabel tituloLabel = new JLabel("Listado Alumnos");
		tituloLabelAligner.add(tituloLabel);
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPanel = new JPanel();
		contentPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JPanel busquedaPanel = new JPanel();
		contentPanel.add(busquedaPanel);
		FlowLayout fl_busquedaPanel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		busquedaPanel.setLayout(fl_busquedaPanel);
		
		JLabel apellidoLabel = new JLabel("Apellido/Prefijo:");
		busquedaPanel.add(apellidoLabel);
		
		apellidoPrefijoField = new JTextField();
		busquedaPanel.add(apellidoPrefijoField);
		apellidoPrefijoField.setColumns(10);
		
		JButton buscarButton = new JButton("Buscar");
		busquedaPanel.add(buscarButton);
		
		JPanel tablaPanel = new JPanel();
		tablaPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPanel.add(tablaPanel);
		tablaPanel.setLayout(new BoxLayout(tablaPanel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(alumnosTable);
		tablaPanel.add(scrollPane);
		scrollPane.setOpaque(false);
		tablaPanel.setPreferredSize(frameDimension);
		
		buscarButton.setBackground(new Color(0, 88, 176));
		buscarButton.setForeground(new Color(255, 255, 255));
		buscarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		buscarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buscarButton.setPreferredSize(new Dimension(120, 35)); 
		
		apellidoPrefijoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		apellidoPrefijoField.setPreferredSize(new Dimension(1, 27)); 
		
		apellidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		apellidoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		busquedaPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

		
		
		// Configurar ActionListener para el botón buscar
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (camposValidos()) {
					VOListarAlumnos vo = new VOListarAlumnos(apellidoPrefijoField.getText());

					try {
						controlador = new ControladorListarAlumnos();
						VOAlumno[] alumnos = controlador.listarAlumnos(vo);
						cargarTabla(alumnos);
					} catch (Exception ex) {
						String msg = ex.getMessage();
						JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos() {
		boolean valido = true;

		if (apellidoPrefijoField.getText().isEmpty()) {
			String msg = "El apellido o prefijo no puede ser vacío.";
			JOptionPane.showMessageDialog(contentPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}

	public void cargarTabla(VOAlumno[] alumnos) {
		// VACIO TABLA
		tableModel.setRowCount(0);
	
		// construimos las filas con datos
		if (alumnos != null) {
			for (VOAlumno voAlumno : alumnos) {
				String[] datosAlumno = { String.valueOf(voAlumno.getCedula()), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getTipoAlumno().name()};
				tableModel.addRow(datosAlumno);
			}
		}
	}

	private void vaciarCampos() {
		apellidoPrefijoField.setText("");
	}
	
}

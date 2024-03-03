package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarAlumnos;
import sistema.grafica.controladores.ControladorListarAsignaturas;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOAsignatura;
import sistema.valueobjects.VOListarAlumnos;

public class FormularioListarAlumnos extends JPanel {

	private JTextField apellidoField;
	private JButton buscarButton;
	private DefaultTableModel tableModel;
	private JTable alumnosTable;

	private ControladorListarAlumnos controlador;
	JPanel panelFormulario;

	public FormularioListarAlumnos() {

		// Crear el modelo de la tabla
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.addColumn("Cédula");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellido");
		tableModel.addColumn("Tipo");

		// Crear la JTable con el modelo
		alumnosTable = new JTable(tableModel);

		// Crear el formulario de búsqueda de alumnos por apellido
		setLayout(new BorderLayout());

		// Configurar el título
		add(new JLabel("Listado de Alumnos por Apellido"), BorderLayout.NORTH);

		// Panel para el formulario de búsqueda
		panelFormulario = new JPanel(new BorderLayout());
		panelFormulario.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Panel para los componentes de entrada y el botón de búsqueda
		JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		apellidoField = new JTextField(20);
		buscarButton = new JButton("Buscar");


		panelInput.add(new JLabel("Apellido o prefijo:"));
		panelInput.add(apellidoField);
		panelInput.add(buscarButton);

		// Agregar el panel de entrada al panel de formulario
		panelFormulario.add(panelInput, BorderLayout.NORTH);

		// Configurar el diseño del formulario
		JPanel tablaPanel = new JPanel(new BorderLayout());
		tablaPanel.add(new JScrollPane(alumnosTable), BorderLayout.CENTER);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton volverButton = new JButton("Volver");
		botonPanel.add(volverButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.CENTER);
		panelFormulario.add(tablaPanel, BorderLayout.CENTER);
		panelFormulario.add(botonPanel, BorderLayout.SOUTH);

		// Configurar ActionListener para el botón buscar
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controlador = new ControladorListarAlumnos();

				if (camposValidos()) {
					VOListarAlumnos vo = new VOListarAlumnos(apellidoField.getText());

					try {
						VOAlumno[] alumnos = controlador.listarAlumnos(vo);
						cargarTabla(alumnos);
					} catch (Exception ex) {
						String msg = ex.getMessage();
						JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos() {
		boolean valido = true;

		if (apellidoField.getText().isEmpty()) {
			String msg = "El apellido o prefijo no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
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
		apellidoField.setText("");
	}

}

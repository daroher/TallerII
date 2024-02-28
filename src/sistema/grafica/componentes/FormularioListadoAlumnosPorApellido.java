package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FormularioListadoAlumnosPorApellido extends JPanel {

	private JTextField apellidoField;
	private JButton buscarButton;
	private DefaultTableModel tableModel;
	private JTable alumnosTable;

	public FormularioListadoAlumnosPorApellido() {

		// Crear el modelo de la tabla
		tableModel = new DefaultTableModel();
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
		JPanel panelFormulario = new JPanel(new BorderLayout());
		panelFormulario.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Panel para los componentes de entrada y el botón de búsqueda
		JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		apellidoField = new JTextField(20);
		buscarButton = new JButton("Buscar");

		// Configurar ActionListener para el botón Buscar
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: implementar esto
			}
		});

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
	}
}

package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarAsignaturas;
import sistema.valueobjects.VOAsignatura;

public class FormularioListarAsignaturas extends JPanel {
	private DefaultTableModel tableModel;
	private JTable asignaturasTable;
	private VOAsignatura[] asignaturas;
	private ControladorListarAsignaturas controlador;
	private JPanel tablaPanel;

	public FormularioListarAsignaturas() {
		// Crear el modelo de la tabla
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tableModel.addColumn("Código");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Descripción");

		// Crear la JTable con el modelo
		asignaturasTable = new JTable(tableModel);

		// Configurar el diseño del formulario
		setLayout(new BorderLayout());

		// Panel para la tabla
		tablaPanel = new JPanel(new BorderLayout());
		tablaPanel.add(new JScrollPane(asignaturasTable), BorderLayout.CENTER);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton volverButton = new JButton("Volver");
		botonPanel.add(volverButton);

		// Añadir paneles al formulario
		add(tablaPanel, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Listado de Asignaturas"), BorderLayout.NORTH);

		asignaturasTable.setModel(tableModel);
		asignaturasTable.requestFocus();
	}

	public void obtenerAsignaturas() {
		// construimos las filas con datos

		// VACIO TABLA
		tableModel.setRowCount(0);
		controlador = new ControladorListarAsignaturas();

		try {
			asignaturas = controlador.listarAsignaturas();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			JOptionPane.showMessageDialog(tablaPanel, msg);
		}

		if (asignaturas != null) {
			for (VOAsignatura voAsignatura : asignaturas) {
				String[] asignatura = { voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() };
				tableModel.addRow(asignatura);
			}
		}
	}

}

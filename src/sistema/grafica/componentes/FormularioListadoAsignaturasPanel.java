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

import sistema.grafica.controladores.ControladorListadoAsignaturas;
import sistema.valueobjects.VOAsignatura;

public class FormularioListadoAsignaturasPanel extends JPanel {
	private DefaultTableModel tableModel;
	private JTable asignaturasTable;
	private VOAsignatura[] asignaturas;
	private ControladorListadoAsignaturas controlador;

	public FormularioListadoAsignaturasPanel() {
		// Crear el modelo de la tabla
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Código");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Descripción");

		// Crear la JTable con el modelo
		asignaturasTable = new JTable(tableModel);

		// Configurar el diseño del formulario
		setLayout(new BorderLayout());

		// Panel para la tabla
		JPanel tablaPanel = new JPanel(new BorderLayout());
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

		// construimos las filas con datos

		// VACIO TABLA
		tableModel.setRowCount(0);
		controlador = new ControladorListadoAsignaturas();

		try {
			asignaturas = controlador.listarAsignaturas();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			JOptionPane.showMessageDialog(tablaPanel, msg);
		}

		for (VOAsignatura voAsignatura : asignaturas) {
			String[] asignatura = { voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() };
			tableModel.addRow(asignatura);
		}

		asignaturasTable.setModel(tableModel);
	}

}

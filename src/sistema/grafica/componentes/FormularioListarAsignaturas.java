package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarAsignaturas;
import sistema.valueobjects.VOAsignatura;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FormularioListarAsignaturas extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable asignaturasTable;
	private JPanel tablaPanel;
	private VOAsignatura[] asignaturas;
	private ControladorListarAsignaturas controlador;

	public FormularioListarAsignaturas(Dimension frameDimension) {
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
		asignaturasTable.setRowMargin(2);
		asignaturasTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asignaturasTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		asignaturasTable.setOpaque(false);
		asignaturasTable.setRowHeight(23);

		// Configurar el diseño del formulario
		setLayout(new BorderLayout());

		  // Panel para la tabla
        tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setOpaque(false);
        
        
        // JScrollPane para que la tabla tenga un tamaño más manejable
        JScrollPane scrollPane = new JScrollPane(asignaturasTable);
        scrollPane.setOpaque(false);
        scrollPane.setPreferredSize(asignaturasTable.getPreferredSize());
        tablaPanel.add(scrollPane, BorderLayout.CENTER);

		// Añadir paneles al formulario
		add(tablaPanel, BorderLayout.CENTER);

		// Configurar el título
		JLabel tituloLabel = new JLabel("Listado de Asignaturas");
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(tituloLabel, BorderLayout.NORTH);
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		asignaturasTable.setModel(tableModel);
		asignaturasTable.requestFocus();
	}

	public void obtenerAsignaturas() {
		// construimos las filas con datos

		// VACIO TABLA
		tableModel.setRowCount(0);

		try {
			controlador = new ControladorListarAsignaturas();
			asignaturas = controlador.listarAsignaturas();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			JOptionPane.showMessageDialog(tablaPanel, msg, "Error", JOptionPane.ERROR_MESSAGE);
		}

		if (asignaturas != null) {
			for (VOAsignatura voAsignatura : asignaturas) {
				String[] asignatura = { voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() };
				tableModel.addRow(asignatura);
			}
		}
	}

}

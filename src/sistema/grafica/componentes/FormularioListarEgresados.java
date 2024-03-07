package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarEgresados;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOEgresadoCompleto;
import sistema.valueobjects.VOListarEgresados;

public class FormularioListarEgresados extends JPanel {

	private JComboBox<String> modoListadoComboBox;
	private JButton listarButton;
	private DefaultTableModel tableModelParcial;
	private DefaultTableModel tableModelCompleto;
	private JTable egresadosTable;
	private ControladorListarEgresados controlador;

	public FormularioListarEgresados(Dimension frameDimension) {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new FlowLayout());

		// Crear componentes del formulario
		modoListadoComboBox = new JComboBox<>(new String[] { "Parcial", "Completo" });
		modoListadoComboBox.setBackground(new Color(102, 74, 255));
		listarButton = new JButton("Listar Egresados");

		JLabel modoListadoLabel = new JLabel("Modo de Listado:");
		panelFormulario.add(modoListadoLabel);
		panelFormulario.add(modoListadoComboBox);
		panelFormulario.add(listarButton);

		// Crear modelo de la tabla
		tableModelParcial = new DefaultTableModel();
		tableModelParcial.addColumn("Cédula");
		tableModelParcial.addColumn("Nombre");
		tableModelParcial.addColumn("Apellido");

		// Crear modelo de la tabla
		tableModelCompleto = new DefaultTableModel();
		tableModelCompleto.addColumn("Cédula");
		tableModelCompleto.addColumn("Nombre");
		tableModelCompleto.addColumn("Apellido");
		tableModelCompleto.addColumn("Prom. total");
		tableModelCompleto.addColumn("Prom. aprobaciones");

		// Crear la JTable con el modelo
		egresadosTable = new JTable(tableModelParcial);
		egresadosTable.setRowMargin(2);
		egresadosTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		egresadosTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		egresadosTable.setOpaque(false);
		egresadosTable.setRowHeight(23);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.NORTH);
		add(new JScrollPane(egresadosTable), BorderLayout.CENTER);
		
		listarButton.setBackground(new Color(0, 88, 176));
		listarButton.setForeground(new Color(255, 255, 255));
		listarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		listarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		listarButton.setPreferredSize(new Dimension(150, 35)); 
		
		modoListadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoListadoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoListadoComboBox.setPreferredSize(new Dimension(150, 35)); 
		modoListadoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		
		// Configurar ActionListener para el botón Listar Egresados
		listarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TipoListado modoListado = null;

				switch (modoListadoComboBox.getSelectedIndex()) {
				case 0:
					modoListado = TipoListado.PARCIAL;
					break;
				case 1:
					modoListado = TipoListado.COMPLETO;
					break;
				}

				VOListarEgresados vo = new VOListarEgresados(modoListado);

				try {
					controlador = new ControladorListarEgresados();
					VOEgresado[] egresados = controlador.listarEgresados(vo);
					cargarTabla(egresados, modoListado);	
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void cargarTabla(VOEgresado[] egresados, TipoListado modoListado) {

		// VACIO TABLA
		tableModelParcial.setRowCount(0);
		tableModelCompleto.setRowCount(0);
		
		if (modoListado == TipoListado.PARCIAL) {

			egresadosTable.setModel(tableModelParcial);
			// construimos las filas con datos
			if (egresados != null) {
				for (VOEgresado voEgresado : egresados) {
					String[] datosEgresados = { String.valueOf(voEgresado.getCedula()), voEgresado.getNombre(), voEgresado.getApellido() };
					tableModelParcial.addRow(datosEgresados);
				}
			}
		} else {
			egresadosTable.setModel(tableModelCompleto);
			// construimos las filas con datos
			if (egresados != null) {
				for (VOEgresado voEgresado : egresados) {
					String[] datosEgresados = { String.valueOf(voEgresado.getCedula()), voEgresado.getNombre(), voEgresado.getApellido(), String.valueOf(((VOEgresadoCompleto) voEgresado).getPromedioTotal()), String.valueOf(((VOEgresadoCompleto) voEgresado).getPromedioAprobadas())};
					tableModelCompleto.addRow(datosEgresados);
				}
			}
		}
	}

}

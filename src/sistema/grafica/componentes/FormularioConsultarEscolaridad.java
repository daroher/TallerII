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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorConsultarEscolaridad;
import sistema.utilidades.TipoListado;
import sistema.utilidades.Utilidades;
import sistema.valueobjects.VOEscolaridad;
import sistema.valueobjects.VOEscolaridadCompleta;

public class FormularioConsultarEscolaridad extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField cedulaAlumnoField;
	private JComboBox<String> modoListadoComboBox;
	private JButton listarButton;
	private DefaultTableModel tableModelParcial;
	private DefaultTableModel tableModelCompleto;
	private JTable escolaridadTable;
	private ControladorConsultarEscolaridad controlador;
	private JPanel cedulaPanel;
	private JPanel modoListadoPanel;

	public FormularioConsultarEscolaridad(Dimension frameDimension) {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel();
		listarButton = new JButton("Listar Escolaridad");

		// Crear modelo de la tabla
		tableModelParcial = new DefaultTableModel();
		tableModelParcial.addColumn("Número de Inscripción");
		tableModelParcial.addColumn("Nombre de Asignatura");
		tableModelParcial.addColumn("Año Lectivo");
		tableModelParcial.addColumn("Calificación");

		tableModelCompleto = new DefaultTableModel();
		tableModelCompleto.addColumn("Número de Inscripción");
		tableModelCompleto.addColumn("Nombre de Asignatura");
		tableModelCompleto.addColumn("Año Lectivo");
		tableModelCompleto.addColumn("Calificación");
		tableModelCompleto.addColumn("Monto base");

		// Crear la JTable con el modelo
		escolaridadTable = new JTable(tableModelParcial);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(listarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.NORTH);
		panelFormulario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cedulaPanel = new JPanel();
		panelFormulario.add(cedulaPanel);

		JLabel cedulaLabel = new JLabel("Cedula Alumno:");
		cedulaPanel.add(cedulaLabel);

		// Crear componentes del formulario
		cedulaAlumnoField = new JTextField(10);
		cedulaPanel.add(cedulaAlumnoField);

		modoListadoPanel = new JPanel();
		panelFormulario.add(modoListadoPanel);
		JLabel modoListadoLabel = new JLabel("Modo de Listado:");
		modoListadoPanel.add(modoListadoLabel);
		modoListadoComboBox = new JComboBox<>(new String[] { "Parcial", "Completo" });
		modoListadoPanel.add(modoListadoComboBox);
		add(botonPanel, BorderLayout.SOUTH);

		// Panel para la tabla
		JPanel tablaPanel = new JPanel(new BorderLayout());
		tablaPanel.add(new JScrollPane(escolaridadTable), BorderLayout.CENTER);

		// Añadir panel de la tabla al formulario
		add(tablaPanel, BorderLayout.CENTER);

		escolaridadTable.setRowMargin(2);
		escolaridadTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		escolaridadTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		escolaridadTable.setOpaque(false);
		escolaridadTable.setRowHeight(23);

		listarButton.setBackground(new Color(0, 88, 176));
		listarButton.setForeground(new Color(255, 255, 255));
		listarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		listarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		listarButton.setPreferredSize(new Dimension(150, 35));

		modoListadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoListadoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoListadoComboBox.setPreferredSize(new Dimension(150, 35));
		modoListadoComboBox.setBackground(new Color(102, 74, 255));
		cedulaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cedulaAlumnoField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cedulaAlumnoField.setPreferredSize(new Dimension(1, 27));

		panelFormulario.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

		// Configurar ActionListener para el botón Listar
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

				try {
					controlador = new ControladorConsultarEscolaridad();
					VOEscolaridad[] escolaridad = controlador.consultarEscolaridad(cedulaAlumnoField.getText(), modoListado);
					cargarTabla(escolaridad, modoListado);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void cargarTabla(VOEscolaridad[] escolaridad, TipoListado modoListado) {
		// VACIO TABLA
		tableModelParcial.setRowCount(0);
		tableModelCompleto.setRowCount(0);

		if (modoListado == TipoListado.PARCIAL) {

			escolaridadTable.setModel(tableModelParcial);

			// construimos las filas con datos
			if (escolaridad != null) {
				for (VOEscolaridad voEscolaridad : escolaridad) {
					String[] datosEscolaridad = { String.valueOf(voEscolaridad.getNumInscripcion()),
							voEscolaridad.getNombreAsignatura(), String.valueOf(voEscolaridad.getAnioLectivo()),
							String.valueOf(voEscolaridad.getCalificacion()) };
					tableModelParcial.addRow(datosEscolaridad);
				}
			}
		} else {

			escolaridadTable.setModel(tableModelCompleto);

			// construimos las filas con datos
			if (escolaridad != null) {
				for (VOEscolaridad voEscolaridad : escolaridad) {
					String[] datosEscolaridad = { String.valueOf(voEscolaridad.getNumInscripcion()),
							voEscolaridad.getNombreAsignatura(), String.valueOf(voEscolaridad.getAnioLectivo()),
							String.valueOf(voEscolaridad.getCalificacion()),
							Utilidades.convertirTextoAFormatoMoneda(String.valueOf(((VOEscolaridadCompleta) voEscolaridad).getMontoBase())) };
					tableModelCompleto.addRow(datosEscolaridad);
				}
			}
		}
	}

}

package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOEscolaridad;
import sistema.valueobjects.VOEscolaridadCompleta;

public class FormularioConsultarEscolaridad extends JPanel {

	private JTextField cedulaAlumnoField;
	private JComboBox<String> modoListadoComboBox;
	private JButton listarButton;
	private DefaultTableModel tableModelParcial;
	private DefaultTableModel tableModelCompleto;
	private JTable escolaridadTable;
	private ControladorConsultarEscolaridad controlador;

	public FormularioConsultarEscolaridad() {
		setLayout(new BorderLayout());

		// Panel del formulario
		JPanel panelFormulario = new JPanel(new GridLayout(3, 2)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
			}
		};

		// Crear componentes del formulario
		cedulaAlumnoField = new JTextField(10);
		modoListadoComboBox = new JComboBox<>(new String[] { "Parcial", "Completo" });
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

		panelFormulario.add(new JLabel("Cédula del Alumno:"));
		panelFormulario.add(cedulaAlumnoField);
		panelFormulario.add(new JLabel("Modo de Listado:"));
		panelFormulario.add(modoListadoComboBox);

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(listarButton);

		// Añadir paneles al formulario
		add(panelFormulario, BorderLayout.NORTH);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar el título
		add(new JLabel("Listado de Escolaridad del Alumno"), BorderLayout.CENTER);

		// Panel para la tabla
		JPanel tablaPanel = new JPanel(new BorderLayout());
		tablaPanel.add(new JScrollPane(escolaridadTable), BorderLayout.CENTER);

		// Añadir panel de la tabla al formulario
		add(tablaPanel, BorderLayout.CENTER);

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
					String[] datosEscolaridad = { String.valueOf(voEscolaridad.getNumInscripcion()), voEscolaridad.getNombreAsignatura(),
							String.valueOf(voEscolaridad.getAnioLectivo()), String.valueOf(voEscolaridad.getCalificacion()) };
					tableModelParcial.addRow(datosEscolaridad);
				}
			}
		} else {

			escolaridadTable.setModel(tableModelCompleto);

			// construimos las filas con datos
			if (escolaridad != null) {
				for (VOEscolaridad voEscolaridad : escolaridad) {
					String[] datosEscolaridad = { String.valueOf(voEscolaridad.getNumInscripcion()), voEscolaridad.getNombreAsignatura(),
							String.valueOf(voEscolaridad.getAnioLectivo()), String.valueOf(voEscolaridad.getCalificacion()),
							String.valueOf(((VOEscolaridadCompleta) voEscolaridad).getMontoBase()) };
					tableModelCompleto.addRow(datosEscolaridad);
				}
			}
		}
	}

}

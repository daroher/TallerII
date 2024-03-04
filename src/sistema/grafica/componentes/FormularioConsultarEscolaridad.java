package sistema.grafica.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorConsultarEscolaridad;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOAlumno;
import sistema.valueobjects.VOConsultarEscolaridad;
import sistema.valueobjects.VOEscolaridad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioConsultarEscolaridad extends JPanel {

    private JTextField cedulaAlumnoField;
    private JComboBox<String> modoListadoComboBox;
    private JButton listarButton;
    private DefaultTableModel tableModel;
    private JTable escolaridadTable;
    private ControladorConsultarEscolaridad controlador;

    public FormularioConsultarEscolaridad() {
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2)){
    		@Override
    		protected void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
    		}
    	};

        // Crear componentes del formulario
        cedulaAlumnoField = new JTextField(10);
        modoListadoComboBox = new JComboBox<>(new String[]{"Parcial", "Completo"});
        listarButton = new JButton("Listar Escolaridad");

        // Crear modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Número de Inscripción");
        tableModel.addColumn("Nombre de Asignatura");
        tableModel.addColumn("Año Lectivo");
        tableModel.addColumn("Calificación");

        // Crear la JTable con el modelo
        escolaridadTable = new JTable(tableModel);

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
            	
            	VOConsultarEscolaridad vo = new VOConsultarEscolaridad(Integer.parseInt(cedulaAlumnoField.getText()), modoListado);

            	try {
            		controlador = new ControladorConsultarEscolaridad();
					VOEscolaridad[] escolaridad = controlador.consultarEscolaridad(vo);
					
					if (escolaridad[0] == null) {
						String msg = "El alumno no tiene inscripciones validas.";
						JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						cargarTabla(escolaridad);						
					}
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
    }
    
	public void cargarTabla(VOEscolaridad[] escolaridad) {
		// VACIO TABLA
		tableModel.setRowCount(0);
	
		// construimos las filas con datos
		if (escolaridad != null) {
			for (VOEscolaridad voEscolaridad : escolaridad) {
				String[] datosEscolaridad = { String.valueOf(voEscolaridad.getNumInscripcion()), voEscolaridad.getNombreAsignatura(), String.valueOf(voEscolaridad.getAnioLectivo()), String.valueOf(voEscolaridad.getCalificacion())};
				tableModel.addRow(datosEscolaridad);
			}
		}
	}

}
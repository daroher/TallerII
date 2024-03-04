package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import javax.swing.table.DefaultTableModel;

import sistema.grafica.controladores.ControladorListarEgresados;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.utilidades.TipoListado;
import sistema.valueobjects.VOEgresado;
import sistema.valueobjects.VOListarEgresados;

public class FormularioListarEgresados extends JPanel {

    private JComboBox<String> modoListadoComboBox;
    private JButton listarButton;
    private DefaultTableModel tableModel;
    private JTable egresadosTable;
    private ControladorListarEgresados controlador;

    public FormularioListarEgresados() {
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new FlowLayout()){
    		@Override
    		protected void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
    		}
    	};

        // Crear componentes del formulario
        modoListadoComboBox = new JComboBox<>(new String[]{"Parcial", "Completo"});
        listarButton = new JButton("Listar Egresados");

        panelFormulario.add(new JLabel("Modo de Listado:"));
        panelFormulario.add(modoListadoComboBox);
        panelFormulario.add(listarButton);

        // Crear modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cédula");

        // Crear la JTable con el modelo
        egresadosTable = new JTable(tableModel);

        // Añadir paneles al formulario
        add(panelFormulario, BorderLayout.NORTH);
        add(new JScrollPane(egresadosTable), BorderLayout.CENTER);

        // Panel para el botón
        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        JButton volverButton = new JButton("Volver");
//        botonPanel.add(volverButton);
        add(botonPanel, BorderLayout.SOUTH);

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
					
					if (egresados.length == 0) {
						String msg = "No hay egresados actualmente.";
						JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.INFORMATION_MESSAGE);
					} else {
						cargarTabla(egresados);
					}
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
    }
    
	public void cargarTabla(VOEgresado[] egresados) {
		// VACIO TABLA
		tableModel.setRowCount(0);
	
		// construimos las filas con datos
		if (egresados != null) {
			for (VOEgresado voEgresado : egresados) {
				String[] datosEgresados = { String.valueOf(voEgresado.getCedula()), voEgresado.getNombre(), voEgresado.getApellido()};
				tableModel.addRow(datosEgresados);
			}
		}
	}

}

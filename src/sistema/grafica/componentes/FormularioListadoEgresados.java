package sistema.grafica.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioListadoEgresados extends JPanel {

    private JComboBox<String> modoListadoComboBox;
    private JButton listarButton;
    private DefaultTableModel tableModel;
    private JTable egresadosTable;

    public FormularioListadoEgresados() {
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new FlowLayout());

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
        JButton volverButton = new JButton("Volver");
        botonPanel.add(volverButton);
        add(botonPanel, BorderLayout.SOUTH);

        // Configurar ActionListener para el botón Listar Egresados
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implementar la lógica de listado de egresados
            }
        });
    }

}

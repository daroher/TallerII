package sistema.grafica.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioListadoEscolaridad extends JPanel {

    private JTextField cedulaAlumnoField;
    private JComboBox<String> modoListadoComboBox;
    private JButton listarButton;
    private DefaultTableModel tableModel;
    private JTable escolaridadTable;

    public FormularioListadoEscolaridad() {
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2));

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
                // TODO: Implementar la lógica de listado
            }
        });
    }

}

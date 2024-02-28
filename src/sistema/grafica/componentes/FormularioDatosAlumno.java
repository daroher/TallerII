package sistema.grafica.componentes;

import javax.swing.*;
import java.awt.*;

public class FormularioDatosAlumno extends JPanel {

    private JLabel cedulaLabel;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel domicilioLabel;
    private JLabel telefonoLabel;
    private JLabel asignaturasAprobadasLabel;
    private JLabel tipoAlumnoLabel;
    private JLabel descuentoLabel;
    private JLabel razonBecaLabel;

    public FormularioDatosAlumno() {
        setLayout(new BorderLayout());

        // Panel para el contenido
        JPanel contentPanel = new JPanel(new GridLayout(9, 2, 5, 5)); // 9 filas, 2 columnas

        cedulaLabel = new JLabel("Cédula:");
        nombreLabel = new JLabel("Nombre:");
        apellidoLabel = new JLabel("Apellido:");
        domicilioLabel = new JLabel("Domicilio:");
        telefonoLabel = new JLabel("Teléfono:");
        asignaturasAprobadasLabel = new JLabel("Asignaturas Aprobadas:");
        tipoAlumnoLabel = new JLabel("Tipo de Alumno:");
        descuentoLabel = new JLabel("Descuento:");
        razonBecaLabel = new JLabel("Razón de Beca:");

        contentPanel.add(cedulaLabel);
        contentPanel.add(new JLabel("")); // Espacio en blanco para mostrar el valor después
        contentPanel.add(nombreLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(apellidoLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(domicilioLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(telefonoLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(asignaturasAprobadasLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(tipoAlumnoLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(descuentoLabel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(razonBecaLabel);
        contentPanel.add(new JLabel(""));

        // Configurar el diseño del formulario
        add(contentPanel, BorderLayout.CENTER);

        // Configurar el título
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Datos del Alumno"));
        add(titlePanel, BorderLayout.NORTH);

        // Panel para el botón Volver
        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton volverButton = new JButton("Volver");
        botonPanel.add(volverButton);

        // Añadir paneles al formulario
        add(botonPanel, BorderLayout.SOUTH);
    }

    public void setDatosAlumno(String cedula, String nombre, String apellido, String domicilio,
                               String telefono, String asignaturasAprobadas, String tipoAlumno,
                               String descuento, String razonBeca) {
        cedulaLabel.setText("Cédula: " + cedula);
        nombreLabel.setText("Nombre: " + nombre);
        apellidoLabel.setText("Apellido: " + apellido);
        domicilioLabel.setText("Domicilio: " + domicilio);
        telefonoLabel.setText("Teléfono: " + telefono);
        asignaturasAprobadasLabel.setText("Asignaturas Aprobadas: " + asignaturasAprobadas);
        tipoAlumnoLabel.setText("Tipo de Alumno: " + tipoAlumno);
        descuentoLabel.setText("Descuento: " + descuento);
        razonBecaLabel.setText("Razón de Beca: " + razonBeca);
    }

}

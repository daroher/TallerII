package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorRegistrarAsignatura;
import sistema.valueobjects.VOAsignatura;

public class FormularioRegistrarAsignatura extends JPanel {

	private JTextField codigoField;
	private JTextField nombreField;
	private JTextArea descripcionArea;
	private JButton registrarButton;

	private ControladorRegistrarAsignatura controlador;

	// Panel del formulario
	JPanel panelFormulario = new JPanel(new GridLayout(4, 2));

	public FormularioRegistrarAsignatura() {
		// layout que permite ordenar los componentes en norte,sur,este,oeste o centro
		// lo uso para poner el titulo al norte, el formulario en el centro y los
		// botones al sur
		setLayout(new BorderLayout());

		// Crear campos del formulario
		codigoField = new JTextField(10);
		nombreField = new JTextField(20);
		descripcionArea = new JTextArea(5, 20);
		// indicia si se permite que una linea sea mas larga que el textarea o si debe
		// pasar automaticamente a la linea de abajo al escribir
		descripcionArea.setLineWrap(true);
		registrarButton = new JButton("Registrar");

		panelFormulario.add(new JLabel("Código:"));
		panelFormulario.add(codigoField);
		panelFormulario.add(new JLabel("Nombre:"));
		panelFormulario.add(nombreField);
		panelFormulario.add(new JLabel("Descripción:"));
		panelFormulario.add(new JScrollPane(descripcionArea));

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		add(new JLabel("Registro de Asignaturas"), BorderLayout.NORTH);
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controlador = new ControladorRegistrarAsignatura();

				if (camposValidos()) {
					VOAsignatura vo = new VOAsignatura(codigoField.getText(), nombreField.getText(), descripcionArea.getText());

					try {
						controlador.registrarAsignatura(vo);
						String msg = "Se registró satisfactoriamente la Asignatura.";
						JOptionPane.showMessageDialog(panelFormulario, msg);
						vaciarCampos();
					} catch (Exception ex) {
						String msg = ex.getMessage();
						JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}

	// valido los datos ingresador, si alguno no valida devuelvo mensaje y un
	// boolean que indica si se debe seguir adelante con el registro
	private boolean camposValidos() {
		boolean valido = true;

		if (codigoField.getText().isEmpty()) {
			String msg = "El código no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (nombreField.getText().isEmpty()) {
			String msg = "El nombre no puede ser vacío.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		} else if (descripcionArea.getText().isEmpty()) {
			String msg = "La descripción no puede ser vacía.";
			JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		return valido;
	}

	private void vaciarCampos() {
		codigoField.setText("");
		nombreField.setText("");
		descripcionArea.setText("");
	}
}

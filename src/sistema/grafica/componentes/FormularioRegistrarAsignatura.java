package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorRegistrarAsignatura;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.valueobjects.VOAsignatura;
import javax.swing.SwingConstants;

public class FormularioRegistrarAsignatura extends JPanel {

	private JTextField codigoField;
	private JTextField nombreField;
	private JTextArea descripcionArea;
	private JButton registrarButton;

	private ControladorRegistrarAsignatura controlador;

	// Panel del formulario
	JPanel panelFormulario = new JPanel(new GridLayout(4, 2)) {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
		}
	};

	public FormularioRegistrarAsignatura() {
		// layout que permite ordenar los componentes en norte,sur,este,oeste o centro
		// lo uso para poner el titulo al norte, el formulario en el centro y los
		// botones al sur
		setLayout(new BorderLayout());

		// label codigo
		JLabel codigoLabel = new JLabel("Código:");
		codigoLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(codigoLabel);

		//campo codigo
		JPanel codigoFieldPanel = new JPanel(null);
		codigoFieldPanel.setOpaque(false);
		codigoField = new JTextField(10); 
		codigoField.setBounds(50, 80, 200, 30);
		codigoFieldPanel.add(codigoField);
		panelFormulario.add(codigoFieldPanel);

		//label nombre
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label);
		
		//campo nombre
		nombreField = new JTextField(20);
		JPanel nombreFieldPanel = new JPanel(null);
		nombreFieldPanel.setOpaque(false);
		nombreField.setBounds(50, 70, 200, 30);
		nombreFieldPanel.add(nombreField);
		panelFormulario.add(nombreFieldPanel);
		
		descripcionArea = new JTextArea(5, 20);
		// indicia si se permite que una linea sea mas larga que el textarea o si debe
		// pasar automaticamente a la linea de abajo al escribir
		descripcionArea.setLineWrap(true);
		registrarButton = new JButton("Registrar");

		
		JLabel label_1 = new JLabel("Descripción:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelFormulario.add(label_1);
		panelFormulario.add(new JScrollPane(descripcionArea));

		// Panel para el botón
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botonPanel.add(registrarButton);

		// Añadir paneles al formulario
		JLabel label_2 = new JLabel("Registro de Asignaturas");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2, BorderLayout.NORTH);
		add(panelFormulario, BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);

		// Configurar ActionListener para el botón Registrar
		registrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (camposValidos()) {
					VOAsignatura vo = new VOAsignatura(codigoField.getText(), nombreField.getText(), descripcionArea.getText());

					try {
						controlador = new ControladorRegistrarAsignatura();
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

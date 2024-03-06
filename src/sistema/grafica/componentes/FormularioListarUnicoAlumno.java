package sistema.grafica.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.grafica.controladores.ControladorListarUnicoAlumno;
import sistema.grafica.pantallas.VentanaPrincipal;
import sistema.logica.alumno.TipoAlumno;
import sistema.valueobjects.VOAlumnoCompleto;
import sistema.valueobjects.VOListarUnicoAlumno;

public class FormularioListarUnicoAlumno extends JPanel {

	private JLabel cedulaLabel;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel domicilioLabel;
	private JLabel telefonoLabel;
	private JLabel asignaturasAprobadasLabel;
	private JLabel tipoAlumnoLabel;
	private JLabel descuentoLabel;
	private JLabel razonBecaLabel;
	private JLabel cedulaDato;
	private JLabel nombreDato;
	private JLabel apellidoDato;
	private JLabel domicilioDato;
	private JLabel telefonoDato;
	private JLabel asignaturasAprobadasDato;
	private JLabel tipoAlumnoDato;
	private JLabel descuentoDato;
	private JLabel razonBecaDato;

	private JTextField cedulaField;
	private JButton buscarButton;
	JPanel panelFormulario;

	private ControladorListarUnicoAlumno controlador;

	public FormularioListarUnicoAlumno() {
		setLayout(new BorderLayout());

		// Configurar el título
		add(new JLabel("Datos del Alumno"), BorderLayout.NORTH);

		// Panel para el contenido
		panelFormulario = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")).getImage(), 0, 0, 582, 840, this);
			}
		};
		
		panelFormulario.setLayout(new BorderLayout(0, 0));

		// Panel para los componentes de entrada y el botón de búsqueda
		JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cedulaField = new JTextField(10);
		buscarButton = new JButton("Buscar");

		panelInput.add(new JLabel("Cedula:"));
		panelInput.add(cedulaField);
		panelInput.add(buscarButton);

		// Agregar el panel de entrada al panel de formulario
		panelFormulario.add(panelInput, BorderLayout.NORTH);

		JPanel panelDatos = new JPanel(new GridLayout(9, 2, 5, 5)); // 9 filas, 2 columnas

		cedulaLabel = new JLabel("Cédula:");
		nombreLabel = new JLabel("Nombre:");
		apellidoLabel = new JLabel("Apellido:");
		domicilioLabel = new JLabel("Domicilio:");
		telefonoLabel = new JLabel("Teléfono:");
		asignaturasAprobadasLabel = new JLabel("Asignaturas Aprobadas:");
		tipoAlumnoLabel = new JLabel("Tipo de Alumno:");
		descuentoLabel = new JLabel("Descuento:");
		razonBecaLabel = new JLabel("Razón de Beca:");

		// Inicializar JLabels
		cedulaDato = new JLabel(""); // Ejemplo de dato
		nombreDato = new JLabel("");
		apellidoDato = new JLabel("");
		domicilioDato = new JLabel("");
		telefonoDato = new JLabel("");
		asignaturasAprobadasDato = new JLabel("");
		tipoAlumnoDato = new JLabel("");
		descuentoDato = new JLabel("");
		razonBecaDato = new JLabel("");

		panelDatos.add(cedulaLabel);
		panelDatos.add(cedulaDato);
		panelDatos.add(nombreLabel);
		panelDatos.add(nombreDato);
		panelDatos.add(apellidoLabel);
		panelDatos.add(apellidoDato);
		panelDatos.add(domicilioLabel);
		panelDatos.add(domicilioDato);
		panelDatos.add(telefonoLabel);
		panelDatos.add(telefonoDato);
		panelDatos.add(asignaturasAprobadasLabel);
		panelDatos.add(asignaturasAprobadasDato);
		panelDatos.add(tipoAlumnoLabel);
		panelDatos.add(tipoAlumnoDato);
		panelDatos.add(descuentoLabel);
		panelDatos.add(descuentoDato);
		panelDatos.add(razonBecaLabel);
		panelDatos.add(razonBecaDato);

		// Configurar el diseño del formulario
		add(panelFormulario, BorderLayout.CENTER);
		panelFormulario.add(panelDatos, BorderLayout.CENTER);

		// Panel para el botón Volver
		JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton volverButton = new JButton("Volver");
		botonPanel.add(volverButton);

		// Añadir paneles al formulario
		panelFormulario.add(botonPanel, BorderLayout.SOUTH);

		// Configurar ActionListener para el botón buscar
		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					controlador = new ControladorListarUnicoAlumno();
					VOAlumnoCompleto alumno = controlador.listarUnicoAlumno(cedulaField.getText());
					cargarDatos(alumno);
				} catch (Exception ex) {
					vaciarCampos();
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(panelFormulario, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}


	public void cargarDatos(VOAlumnoCompleto alumno) {

		vaciarCampos();
		cedulaDato.setText(String.valueOf(alumno.getCedula()));
		nombreDato.setText(alumno.getNombre());
		apellidoDato.setText(alumno.getApellido());
		domicilioDato.setText(alumno.getDomicilio());
		telefonoDato.setText(alumno.getTelefono());
		asignaturasAprobadasDato.setText(String.valueOf(alumno.getCantAprobadas()));
		tipoAlumnoDato.setText(alumno.getTipoAlumno().name());
		
		if(alumno.getTipoAlumno() == TipoAlumno.BECADO) {
			descuentoDato.setText(String.valueOf(alumno.getPorcentajeBeca()));
			razonBecaDato.setText(alumno.getRazonBeca());
		}
		
	}

	private void vaciarCampos() {
		cedulaDato.setText("");
		nombreDato.setText("");
		apellidoDato.setText("");
		domicilioDato.setText("");
		telefonoDato.setText("");
		asignaturasAprobadasDato.setText("");
		tipoAlumnoDato.setText("");
		descuentoDato.setText("");
		razonBecaDato.setText("");
	}

}

package sistema.grafica.pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sistema.grafica.componentes.FormularioCalcularMontoRecaudado;
import sistema.grafica.componentes.FormularioListarUnicoAlumno;
import sistema.grafica.componentes.FormularioInscribirAlumnoEnAsignatura;
import sistema.grafica.componentes.FormularioListarAlumnos;
import sistema.grafica.componentes.FormularioListarAsignaturas;
import sistema.grafica.componentes.FormularioListarEgresados;
import sistema.grafica.componentes.FormularioConsultarEscolaridad;
import sistema.grafica.componentes.FormularioRegistrarAlumno;
import sistema.grafica.componentes.FormularioRegistrarAsignatura;
import sistema.grafica.componentes.FormularioRegistrarResultado;
import sistema.grafica.componentes.MenuSuperior;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VentanaPrincipal {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("");

	public VentanaPrincipal() {
		
		frame = new JFrame();
		 // Configurar la ventana
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  // No se puede redimensionar
        frame.setLocationRelativeTo(null);  // Centrar en la pantalla
        
        // Hacer que la ventana no tenga nada seleccionado al inicio
        frame.setFocusable(true);
        frame.requestFocusInWindow();

		// Instancia del menú y asignación a la ventana
		MenuSuperior menu = new MenuSuperior();
		frame.setJMenuBar(menu);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
//		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo2.jpeg")));
//		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

		/** creo para cada item de los menus un actionListener, el metodo privado crearActionListener se
		* encarga de definir que formulario se va a mostrar segun que item se de click.
		* Es el que se le pasa por parametro
		* El primer numero es el indice del menu padre
		* (Asignaturas,Alumnos,Inscripciones), el segundo indice es de cada sub-menu
		* hijo de esos 3 
		**/ 
		menu.getMenu(0).getItem(0).addActionListener(crearActionListener(new FormularioRegistrarAsignatura(frame.getSize())));
		menu.getMenu(0).getItem(1).addActionListener(crearActionListener(new FormularioListarAsignaturas(frame.getSize())));
		menu.getMenu(1).getItem(0).addActionListener(crearActionListener(new FormularioRegistrarAlumno(frame.getSize())));
		menu.getMenu(1).getItem(1).addActionListener(crearActionListener(new FormularioListarAlumnos(frame.getSize())));
		menu.getMenu(1).getItem(2).addActionListener(crearActionListener(new FormularioListarEgresados(frame.getSize())));
		menu.getMenu(1).getItem(3).addActionListener(crearActionListener(new FormularioListarUnicoAlumno(frame.getSize())));
		menu.getMenu(1).getItem(4).addActionListener(crearActionListener(new FormularioConsultarEscolaridad(frame.getSize())));
		menu.getMenu(1).getItem(5).addActionListener(crearActionListener(new FormularioCalcularMontoRecaudado(frame.getSize())));
		menu.getMenu(2).getItem(0).addActionListener(crearActionListener(new FormularioInscribirAlumnoEnAsignatura(frame.getSize())));
		menu.getMenu(2).getItem(1).addActionListener(crearActionListener(new FormularioRegistrarResultado(frame.getSize())));
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	// metodo que define el comportamiento de cada item del menu.
	// oculta el formulario que se este mostrando (si hay) y muestra el que se paso
	// por parametro
	private ActionListener crearActionListener(JPanel form) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getContentPane().getComponentCount() != 0)
					frame.getContentPane().remove(0);
				
				if(form instanceof FormularioListarAsignaturas) {
					((FormularioListarAsignaturas) form).obtenerAsignaturas();
				} else if (form instanceof FormularioCalcularMontoRecaudado) {
					((FormularioCalcularMontoRecaudado) form).setMontoPanelVisible();
				}
					
				frame.getContentPane().add(form);
				frame.getContentPane().repaint();
				frame.setVisible(true);
			};
		};
	}
}

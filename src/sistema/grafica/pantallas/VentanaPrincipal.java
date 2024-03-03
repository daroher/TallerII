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
import javax.swing.ImageIcon;

public class VentanaPrincipal {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("");

	public VentanaPrincipal() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instancia del menú y asignación a la ventana
		MenuSuperior menu = new MenuSuperior();
		frame.setJMenuBar(menu);
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/sistema/grafica/imagenes/fondo.png")));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

		/** creo para cada item de los menus un actionListener, el metodo privado crearActionListener se
		* encarga de definir que formulario se va a mostrar segun que item se de click.
		* Es el que se le pasa por parametro
		* El primer numero es el indice del menu padre
		* (Asignaturas,Alumnos,Inscripciones), el segundo indice es de cada sub-menu
		* hijo de esos 3 
		**/ 
		menu.getMenu(0).getItem(0).addActionListener(crearActionListener(new FormularioRegistrarAsignatura()));
		menu.getMenu(0).getItem(1).addActionListener(crearActionListener(new FormularioListarAsignaturas()));
		menu.getMenu(1).getItem(0).addActionListener(crearActionListener(new FormularioRegistrarAlumno()));
		menu.getMenu(1).getItem(1).addActionListener(crearActionListener(new FormularioListarAlumnos()));
		menu.getMenu(1).getItem(2).addActionListener(crearActionListener(new FormularioListarEgresados()));
		menu.getMenu(1).getItem(3).addActionListener(crearActionListener(new FormularioListarUnicoAlumno()));
		menu.getMenu(1).getItem(4).addActionListener(crearActionListener(new FormularioConsultarEscolaridad()));
		menu.getMenu(1).getItem(5).addActionListener(crearActionListener(new FormularioCalcularMontoRecaudado()));
		menu.getMenu(2).getItem(0).addActionListener(crearActionListener(new FormularioInscribirAlumnoEnAsignatura()));
		menu.getMenu(2).getItem(1).addActionListener(crearActionListener(new FormularioRegistrarResultado()));
		
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
				}
					
				frame.getContentPane().add(form);
				frame.getContentPane().repaint();
				frame.setVisible(true);
			};
		};
	}
}

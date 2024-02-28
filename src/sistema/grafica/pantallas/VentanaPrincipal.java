package sistema.grafica.pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sistema.grafica.componentes.FormularioCalculoMontoRecaudado;
import sistema.grafica.componentes.FormularioDatosAlumno;
import sistema.grafica.componentes.FormularioInscripcionAsignatura;
import sistema.grafica.componentes.FormularioListadoAlumnosPorApellido;
import sistema.grafica.componentes.FormularioListadoAsignaturasPanel;
import sistema.grafica.componentes.FormularioListadoEgresados;
import sistema.grafica.componentes.FormularioListadoEscolaridad;
import sistema.grafica.componentes.FormularioRegistroAlumno;
import sistema.grafica.componentes.FormularioRegistroAsignatura;
import sistema.grafica.componentes.FormularioRegistroResultado;
import sistema.grafica.componentes.MenuSuperior;

public class VentanaPrincipal {

	private JFrame frame;

	public VentanaPrincipal() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instancia del menú y asignación a la ventana
		MenuSuperior menu = new MenuSuperior();
		frame.setJMenuBar(menu);

		// creo para cada item de los menus un actionListener, el metodo privado crearActionListener se
		// encarga de definir que formulario se va a mostrar segun que item se de click.
		// Es el que se le pasa por parametro
		// El primer numero es el indice del menu padre
		// (Asignaturas,Alumnos,Inscripciones), el segundo indice es de cada sub-menu
		// hijo de esos 3 
		menu.getMenu(0).getItem(0).addActionListener(crearActionListener(new FormularioRegistroAsignatura()));
		menu.getMenu(0).getItem(1).addActionListener(crearActionListener(new FormularioListadoAsignaturasPanel()));
		menu.getMenu(1).getItem(0).addActionListener(crearActionListener(new FormularioRegistroAlumno()));
		menu.getMenu(1).getItem(1).addActionListener(crearActionListener(new FormularioListadoAlumnosPorApellido()));
		menu.getMenu(1).getItem(2).addActionListener(crearActionListener(new FormularioListadoEgresados()));
		menu.getMenu(1).getItem(3).addActionListener(crearActionListener(new FormularioDatosAlumno()));
		menu.getMenu(1).getItem(4).addActionListener(crearActionListener(new FormularioListadoEscolaridad()));
		menu.getMenu(1).getItem(5).addActionListener(crearActionListener(new FormularioCalculoMontoRecaudado()));
		menu.getMenu(2).getItem(0).addActionListener(crearActionListener(new FormularioInscripcionAsignatura()));
		menu.getMenu(2).getItem(1).addActionListener(crearActionListener(new FormularioRegistroResultado()));
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	//metodo que define el comportamiento de cada item del menu.
	//oculta el formulario que se este mostrando (si hay) y muestra el que se paso por parametro
	private ActionListener crearActionListener(JPanel form) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getContentPane().getComponentCount() != 0)
					frame.getContentPane().remove(0);

				frame.getContentPane().add(form);
				frame.setVisible(true);
			};
		};
	}
}

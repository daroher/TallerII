package sistema.grafica.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sistema.grafica.controladores.ControladorMenuSuperior;

//clase que cea el menu superior de la pantalla principal con sus menus y sub menus etc
public class MenuSuperior extends JMenuBar {

	private ControladorMenuSuperior controlador;

	public MenuSuperior() {
		// menu asignaturas y sus sub-menus
		JMenu asignaturaeMenu = new JMenu("Asignaturas");
		JMenuItem registrarAsignaturaItem = new JMenuItem("Registrar");
		JMenuItem listarAsignaturaItem = new JMenuItem("Listar");
		// agrego los sub-menus como hijos del menu padre
		asignaturaeMenu.add(registrarAsignaturaItem);
		asignaturaeMenu.add(listarAsignaturaItem);
		// agrego el menu a la barra de menu
		add(asignaturaeMenu);

		// menu alumnos y sus submenus
		JMenu alumnosMenu = new JMenu("Alumnos");
		JMenuItem inscribirAlumnoItem = new JMenuItem("Inscribir");
		JMenuItem listarAlumnoItem = new JMenuItem("Listar alumnos");
		JMenuItem listarEgresadosItem = new JMenuItem("Listar egresados");
		JMenuItem consultarAlumnoItem = new JMenuItem("Consultar detalles");
		JMenuItem consultarEscolaridadAlumnoItem = new JMenuItem("Consultar escolaridad");
		JMenuItem monoInscripcionesAlumnoItem = new JMenuItem("Monto de inscripciones");
		// agrego los sub-menus como hijos del menu padre
		alumnosMenu.add(inscribirAlumnoItem);
		alumnosMenu.add(listarAlumnoItem);
		alumnosMenu.add(listarEgresadosItem);
		alumnosMenu.add(consultarAlumnoItem);
		alumnosMenu.add(consultarEscolaridadAlumnoItem);
		alumnosMenu.add(monoInscripcionesAlumnoItem);
		// agrego el menu a la barra de menu
		add(alumnosMenu);

		// menu inscripciones y sus submenus
		JMenu inscripcionesMenu = new JMenu("Inscripciones");
		JMenuItem registrarInscripcionItem = new JMenuItem("Inscribir");
		JMenuItem resultadoInscripcionItem = new JMenuItem("Registrar resultado");
		// agrego los sub-menus como hijos del menu padre
		inscripcionesMenu.add(registrarInscripcionItem);
		inscripcionesMenu.add(resultadoInscripcionItem);
		// agrego el menu a la barra de menu
		add(inscripcionesMenu);

		// menu restaurar
		JButton botonRestaurar = new JButton("Restaurar");
		add(botonRestaurar);

		// menu respaldar
		JButton botonRespaldar = new JButton("Respaldar");
		add(botonRespaldar);

		// Configurar ActionListener para el botón restaurar
		botonRespaldar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controlador = new ControladorMenuSuperior();

				try {
					controlador.respaldarSistema();
					String msg = "Se han respaldado los datos satisfactoriamente.";
					JOptionPane.showMessageDialog(null, msg);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// Configurar ActionListener para el botón restaurar
		botonRestaurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				controlador = new ControladorMenuSuperior();

				try {
					controlador.recuperarSistema();
					String msg = "Se han restaurado los datos satisfactoriamente.";
					JOptionPane.showMessageDialog(null, msg);
				} catch (Exception ex) {
					String msg = ex.getMessage();
					JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

}

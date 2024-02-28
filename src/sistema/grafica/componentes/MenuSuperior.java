package sistema.grafica.componentes;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//clase que cea el menu superior de la pantalla principal con sus menus y sub menus etc
public class MenuSuperior extends JMenuBar {

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
		JButton RestaurarMenu = new JButton("Restaurar");
		// agrego el menu a la barra de menu
		add(RestaurarMenu);

		// menu respaldar
		JButton RespaldarMenu = new JButton("Respaldar");
		// agrego el menu a la barra de menu
		add(RespaldarMenu);

	}

}

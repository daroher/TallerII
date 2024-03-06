package sistema.grafica.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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


        // Agregar espacio en blanco para empujar los botones hacia la derecha
        add(Box.createHorizontalGlue());
        
		// menu restaurar
		JButton botonRestaurar = new JButton("Restaurar");
		add(botonRestaurar);
		botonRestaurar.setBackground(new Color(35, 35, 35));
		botonRestaurar.setForeground(new Color(255, 255, 255));
		botonRestaurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonRestaurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonRestaurar.setPreferredSize(new Dimension(120, 35)); 

		// menu respaldar
		JButton botonRespaldar = new JButton("Respaldar");
		add(botonRespaldar);
		botonRespaldar.setBackground(new Color(35, 35, 35));
		botonRespaldar.setForeground(new Color(255, 255, 255));
		botonRespaldar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonRespaldar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonRespaldar.setPreferredSize(new Dimension(120, 35)); 

		// Configurar ActionListener para el botón restaurar
		botonRespaldar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					//TODO: esta bien que se instancie al controlador en cada action?
					controlador = new ControladorMenuSuperior();
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

				try {
					controlador = new ControladorMenuSuperior();
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

package grafica;

import javax.swing.*;

import logica.*;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {

	// creaci�n de la colecci�n de Alumnos
	// public static ListaAlumnos coleccion = new ListaAlumnos();

	private JMenuBar mnbPrincipal = new JMenuBar(); // Barra de menus
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenu jMenuAlumnos;
	// opciones del menu Alumnos
	private JMenuItem itemAlta;
	private JMenuItem itemBuscar;
	private JMenuItem itemVer;

	// constructor
	public MenuPrincipal() {
		setTitle("Menu Principal Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setBounds(0, 0, 1200, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iniciarComponentes();
		iniciarManejadoresEventos();

	}

	private void iniciarComponentes() {

		// barra de men� principal
		mnbPrincipal = new JMenuBar();
		// Men� Alumnos
		jMenuAlumnos = new JMenu("Alumnos");
		// opciones de men� Alumnos
		itemAlta = new JMenuItem("Agregar Alumno");
		itemBuscar = new JMenuItem("Buscar Alumno");
		itemVer = new JMenuItem("Ver Alumnos");

		// agregamos los itemMen� al men�
		jMenuAlumnos.add(itemAlta);
		jMenuAlumnos.add(itemBuscar);
		jMenuAlumnos.add(itemVer);

		// agregamos el men� Alumnos a la barra de men�
		mnbPrincipal.add(jMenuAlumnos);

		// colocamos el men� principal en el JFrame
		setJMenuBar(mnbPrincipal);

		// creaci�n del desktopPane para manejar los JInternalFrame
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 0, 0));
		desktopPane.setBounds(0, 22, 1200, 678); // pos y tam
		contentPane.add(desktopPane);

	}

	private void iniciarManejadoresEventos() {
		itemAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarAlumno altaPer = new AgregarAlumno();
				altaPer.setVisible(true);
				desktopPane.add(altaPer);
			}
		});

		itemBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarAlumno busPer = new BuscarAlumno();
				busPer.setVisible(true);
				desktopPane.add(busPer);
			}
		});

		itemVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerAlumnosTabla tablaPer = new VerAlumnosTabla();
				tablaPer.setVisible(true);
				desktopPane.add(tablaPer);
			}
		});

	}

	public static void main(String args[]) {

		MenuPrincipal m = new MenuPrincipal();
		m.setVisible(true);
	}

}

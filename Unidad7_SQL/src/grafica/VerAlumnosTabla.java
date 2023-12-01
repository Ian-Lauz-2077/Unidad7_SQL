package grafica;

import javax.swing.*;

//import static grafica.MenuPrincipal.coleccion;	en todos los lugares que dice coleccion ahora debe decir listado

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logica.*;

public class VerAlumnosTabla extends JInternalFrame {

	private JPanel pnlCentral;
	private DefaultTableModel miModelo; // modelo
	private JTable tablaAlumnos; // tabla
	private JScrollPane scrPanel;// barra de desplazamiento

	private JButton btnActualizar;

	public VerAlumnosTabla() {
		setClosable(true);
		setBounds(600, 0, 400, 800);// pos y tamaño
		iniciarComponentes();
		iniciarManejadoresEventos();
	}

	public void iniciarComponentes() {
		setTitle("Listado de Alumnos");
		setResizable(true);
		/* Instanciamos un panel y le aplicamos BorderLayout */
		pnlCentral = new JPanel();
		pnlCentral.setLayout(new BorderLayout());
		// instanciamos un botón
		btnActualizar = new JButton("Actualizar Listado");
		getContentPane().add(btnActualizar, BorderLayout.SOUTH);
		iniciarTabla();

	}

	private void iniciarManejadoresEventos() {
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miModelo.getRowCount() != 0)
					limpiarTabla();
				cargarTabla();

			}
		});
	}

	public void iniciarTabla() {

		scrPanel = new JScrollPane();
		pnlCentral.add(scrPanel, BorderLayout.CENTER);

		tablaAlumnos = new JTable();
		scrPanel.setViewportView(tablaAlumnos);

		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		pack();
		String titulos[] = { "Cedula", "Nombre", "Apellido", "Grupo" };
		miModelo = new DefaultTableModel(null, titulos);
		tablaAlumnos.setModel(miModelo);
	}

	private void cargarTabla() {
		AlumnoDAO pDAO = new AlumnoDAO(); // agregue
		ListaAlumnos listado = pDAO.listarAlumnos(); // cambie

		String fila[] = new String[miModelo.getColumnCount()];
		try {
			for (int i = 0; i < listado.cantidad(); i++) {
				fila[0] = String.valueOf(listado.devolver(i).getCedula());
				fila[1] = listado.devolver(i).getNombre();
				fila[2] = listado.devolver(i).getApellido();
				fila[3] = listado.devolver(i).getGrupo();
				miModelo.addRow(fila);
			}
			tablaAlumnos.setModel(miModelo);
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	private void limpiarTabla() {
		int var = miModelo.getRowCount();
		for (int i = 0; i < var; i++)
			miModelo.removeRow(0);
	}
}

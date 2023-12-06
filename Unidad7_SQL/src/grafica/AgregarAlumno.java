package grafica;

//import static grafica.MenuPrincipal.coleccion;

import logica.*;

import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarAlumno extends JInternalFrame {

	private JPanel pnlSuperior;
	private JLabel lblCedula, lblNombre, lblApellido, lblGrupo;
	private JTextField txtCedula, txtNombre, txtApellido, txtGrupo;
	private JButton btnGuardar, btnLimpiar;

	public AgregarAlumno() {
		setClosable(true);
		setTitle("Agregar Alumno");
		setResizable(true);
		iniciarComponentes();
		iniciarManejadoresEventos();
		pack();
	}

	private void iniciarComponentes() {

		pnlSuperior = new JPanel();
		pnlSuperior.setLayout(new GridLayout(5, 2, 5, 5));
		/* genera espacio vacio alrededor para que no que todo contra los bordes */
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		/* Definimos los componentes del panel superior */
		lblCedula = new JLabel("Cedula:");
		txtCedula = new JTextField();
		lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField();
		lblApellido = new JLabel("Apellido:");
		txtApellido = new JTextField();
		lblGrupo = new JLabel("Grupo:");
		txtGrupo = new JTextField();
		btnGuardar = new JButton("Guardar");
		btnLimpiar = new JButton("Limpiar");

		/* agregamos los componentes del panel superior */
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(lblNombre);
		pnlSuperior.add(txtNombre);
		pnlSuperior.add(lblApellido);
		pnlSuperior.add(txtApellido);
		pnlSuperior.add(lblGrupo);
		pnlSuperior.add(txtGrupo);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		// agregamos el panel al JFrame
		getContentPane().add(pnlSuperior);

	}

	// resolvemos los eventos
	private void iniciarManejadoresEventos() {
		// TODO Auto-generated method stub

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int auxCed = Integer.parseInt(txtCedula.getText());
					String auxNom = txtNombre.getText();
					String auxApe = txtApellido.getText();
					String auxGru = txtGrupo.getText();
					AlumnoVO p1 = new AlumnoVO(auxCed, auxNom, auxApe, auxGru);
					// coleccion.agregar(p1); //
					AlumnoDAO pDAO = new AlumnoDAO(); // cambia esto
					pDAO.insertarAlumno(p1); // y esto
					JOptionPane.showMessageDialog(null, "Datos guardados ok", "Mensaje ",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!, " + "la cedula debe ser numerica  \n", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtCedula.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtGrupo.setText("");
			}
		});
	}
}

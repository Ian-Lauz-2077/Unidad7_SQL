package grafica;

//import static grafica.MenuPrincipal.coleccion;
import logica.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarPersona extends JInternalFrame{
	
	private JPanel pnlSuperior, pnlCentral;
	private JLabel lblCedula, lblNombre, lblApellido;
	private JTextField txtCedula, txtNombre, txtApellido;
	private JButton btnBuscar, btnBorrar;
	private DefaultTableModel miModelo;
			
	
	public BuscarPersona(){
		setClosable(true);
		setTitle("Buscar Persona");
		setBounds(200,0,100,300);
		setResizable(true);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		iniciarManejadoresEventos();
		pack();
	}
	
	private void BorrarPersona() {
		
	}

	private void iniciarComponentes() {
		
		pnlSuperior =new JPanel();   /*instanciamos el contenedor de los datos personales*/
		
		//crea un borde vacio que genera un espacio de 10 px en cada lado del panel
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				
		/*Definimos  los componentes del panel superior*/
		lblCedula=new JLabel("Ingrese cédula:"); 
		txtCedula= new JTextField(10);
		btnBuscar= new JButton();
		btnBuscar.setText("Buscar");
		btnBorrar= new JButton();
		btnBorrar.setText("Borrar");
						
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(btnBuscar);
		pnlSuperior.add(btnBorrar);
		
		/*instanciamos el contenedor para los componentes de la parte central*/
		pnlCentral=new JPanel();
		//pone un borde con titulo
		
		pnlCentral.setLayout(new GridLayout(2,2,10,10)); /*definimos el Layout de 3 filas, 2 columnas y espacios*/
		pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//Definimos  los componentes para el panel central
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setEnabled(true);
		
		lblApellido= new JLabel("Apellido:");
		txtApellido= new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setEnabled(true);
		
		/*Agregamos los componentes al Contenedor Central*/
		pnlCentral.add(lblNombre);
		pnlCentral.add(txtNombre);
		pnlCentral.add(lblApellido);
		pnlCentral.add(txtApellido);
							
		//agregamos cada panel a la zona correspondiendte
		getContentPane().add(pnlSuperior, BorderLayout.NORTH);
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		
	}
	
	private void iniciarManejadoresEventos() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaVO pAux=new PersonaVO();
				int auxCedula = 0;
				try{
					auxCedula=Integer.parseInt(txtCedula.getText());
					//pAux=coleccion.obtenerXCedula(auxCedula); 	//
					PersonaDAO pDAO=new PersonaDAO();	     //agregue
				    pAux=pDAO.buscarXCedula(auxCedula); 	//cambie
					if (pAux!=null){
							txtNombre.setText(pAux.getNombre());
							txtApellido.setText(pAux.getApellido());
					}else
						JOptionPane.showMessageDialog(null, "Persona no"
						+ " encontrada \n");
				}catch (Exception e1){
							JOptionPane.showMessageDialog(null, "La cédula "
							+ "debe ser numérica  \n");
				}
			}
				
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaVO pAux=new PersonaVO();
				PersonaDAO pDAO=new PersonaDAO();
				int borrarCedula = Integer.parseInt(txtCedula.getText());
				
				try {
					pAux=pDAO.buscarXCedula(borrarCedula);
					if(pAux!=null) {
						pDAO.eliminarPersona(borrarCedula);
						JOptionPane.showMessageDialog(null, "Borrado OK.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "Persona no encontrada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "La cédula debe ser numérica.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
	}
			
}
	

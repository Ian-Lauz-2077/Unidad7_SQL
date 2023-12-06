
package logica;

import java.sql.*;

import persistencia.*;

public class AlumnoDAO {
	private Conexion conexion;

	public AlumnoDAO() {
		conexion = new Conexion();
	}

	public String insertarAlumno(AlumnoVO per) {
		String rptaRegistro = null;
		int numFAfectas = 0, numFAfectas2 = 0;

		try {
			Connection acceDB = conexion.getConnection();
			String sql = "INSERT INTO persona VALUES(?,?,?) ";
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			estatuto.setInt(1, per.getCedula());
			estatuto.setString(2, per.getNombre());
			estatuto.setString(3, per.getApellido());

			String sql2 = "INSERT INTO alumno VALUES(?,?,?) ";
			PreparedStatement estatuto2 = acceDB.prepareStatement(sql2);
			estatuto2.setInt(1, per.getCedula());
			estatuto2.setString(2, per.getGrupo());
			estatuto2.setString(3, per.getApellido());

			numFAfectas = estatuto.executeUpdate();
			numFAfectas2 = estatuto2.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (numFAfectas > 0 && numFAfectas2 > 0) {
			rptaRegistro = "Registro exitoso.";
		}

		return rptaRegistro;
	}

	public int eliminarAlumno(int cedula) {
		int filAfectadas = 0;
		try {
			Connection accesoDB = conexion.getConnection();
			String sql = "DELETE FROM Alumno WHERE cedula=?";
			PreparedStatement estatuto = accesoDB.prepareStatement(sql);
			estatuto.setInt(1, cedula);
			filAfectadas = estatuto.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return filAfectadas;
	}

	public String actualizarAlumno(AlumnoVO per) {
		int numFAfectas = 0, numFAfectas2 = 0;
		String resp = null;

		try {
			Connection acceDB = conexion.getConnection();
			String sql = "UPDATE Persona SET cedula= ? ,nombre = ? , apellido=? " + "WHERE cedula= ? ";
			PreparedStatement estatuto = acceDB.prepareStatement(sql);

			estatuto.setInt(1, per.getCedula());
			estatuto.setString(2, per.getNombre());
			estatuto.setString(3, per.getApellido());
			estatuto.setInt(4, per.getCedula());

			String sql2 = "UPDATE Alumno SET cedula= ? , grupo = ? " + "WHERE cedula= ? ";
			PreparedStatement estatuto2 = acceDB.prepareStatement(sql2);
			estatuto2.setInt(1, per.getCedula());
			estatuto2.setString(2, per.getGrupo());

			numFAfectas = estatuto.executeUpdate();
			numFAfectas2 = estatuto2.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (numFAfectas > 0 && numFAfectas2 > 0) {
			resp = "ok.";
		}

		return resp;
	}

	public ListaAlumnos listarAlumnos() {
		ListaAlumnos listaAlumno = new ListaAlumnos();
		AlumnoVO Alumno;
		try {
			Connection acceDB = conexion.getConnection();
			String sql = "select * from Alumno";
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			ResultSet rs = estatuto.executeQuery();
			while (rs.next()) {
				Alumno = new AlumnoVO();
				Alumno.setCedula(rs.getInt(1));
				Alumno.setNombre(rs.getString(2));
				Alumno.setApellido(rs.getString(3));
				Alumno.setGrupo(rs.getString(4));
				listaAlumno.agregar(Alumno);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaAlumno;
	}

	public AlumnoVO buscarXCedula(int cedula) {
		AlumnoVO p = new AlumnoVO();
		p.setCedula(cedula);
		try {
			Connection acceDB = conexion.getConnection();
			String sql = "select * from persona where cedula=" + cedula + ";";
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			ResultSet rs = estatuto.executeQuery();

			String sql2 = "select * from alumno where cedula?" + cedula + ";";
			PreparedStatement estatuto2 = acceDB.prepareStatement(sql2);
			
			while (rs.next()) {
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				ResultSet rs2 = estatuto2.executeQuery();
				while(rs2.next())
				p.setGrupo(rs2.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

}

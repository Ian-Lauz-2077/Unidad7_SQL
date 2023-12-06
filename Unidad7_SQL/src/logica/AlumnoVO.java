package logica;

import java.util.Scanner;

public class AlumnoVO {
	private int cedula;
	private String nombre;
	private String apellido;
	private String grupo;

	public AlumnoVO() {

	}

	public AlumnoVO(int cedula, String nombre, String apellido, String grupo) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.grupo = grupo;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getGrupo() {
		return grupo;
	}

	@Override
	public String toString() {
		return " [cedula = " + cedula + ", " + nombre + " " + apellido + " " + grupo + "] ";
	}

	

}

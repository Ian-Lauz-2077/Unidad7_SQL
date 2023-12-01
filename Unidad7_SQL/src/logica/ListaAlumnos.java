package logica;

import java.util.ArrayList;

public class ListaAlumnos {

	private ArrayList<AlumnoVO> lista;

	// crea la lista de alumnos
	public ListaAlumnos() {
		lista = new ArrayList<>();
	}

	// Agrega una Alumno a la lista
	public void agregar(AlumnoVO p) {
		lista.add(p);
	}

	// dada una cedula elimina a la Alumno de la lista
	public void eliminar(int ced) {
		lista.remove(this.obtenerXCedula(ced));
	}

	// retorna la Alumno que est� en la posici�n i de la lista
	public AlumnoVO devolver(int i) {
		return (lista.get(i));

	}

	// devuelte true si ya existe una Alumno con la cedula ced
	public boolean estaAlumno(int ced) {

		boolean esta = lista.contains(obtenerXCedula(ced));
		return (esta);
	}

	// Busca una Alumno por la cedula, si no la encuentra retorna null
	public AlumnoVO obtenerXCedula(int cedula) {
		AlumnoVO p = null;
		int i = 0;
		boolean encontre = false;
		do {
			if (lista.get(i).getCedula() == cedula) {
				p = lista.get(i);
				encontre = true;
			} else
				i++;
		} while (i < lista.size() && !encontre);
		return p;
	}

	@Override
	public String toString() {
		return ("Lista de Alumnos: " + lista);
	}

	// retorna la cantidad de Alumnos en la lista
	public int cantidad() {
		int cant = 0;

		if (this != null)
			cant = lista.size();
		return cant;

	}

	// retorna la lista
	public ArrayList<AlumnoVO> getLista() {
		return lista;
	}

}

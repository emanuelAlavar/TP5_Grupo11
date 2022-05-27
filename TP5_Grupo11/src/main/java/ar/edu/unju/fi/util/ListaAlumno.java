package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Alumno;

public class ListaAlumno {
	private ArrayList<Alumno> alumnos;
	
	public ListaAlumno() {
		// crear el arrayList
		alumnos = new ArrayList<Alumno>();		
	}
	
	/*métodos accesores*/
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
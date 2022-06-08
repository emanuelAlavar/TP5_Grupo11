package ar.edu.unju.fi.util;

import java.util.ArrayList;


import ar.edu.unju.fi.model.Curso;

public class ListaCurso {
	private ArrayList<Curso> cursos;
	
	public ListaCurso() {
		// crear el arrayList
		cursos = new ArrayList<Curso>();		
	}
	
	/*métodos accesores*/
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
}
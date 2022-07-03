package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Curso;
@Component
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
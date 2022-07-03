package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Docente;
@Component
public class ListaDocente {
	private ArrayList<Docente> docentes;
	
	public ListaDocente() {
		// crear el arrayList
		docentes = new ArrayList<Docente>();
	}
	
	/*métodos accesores*/
	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
}

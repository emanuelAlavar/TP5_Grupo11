package ar.edu.unju.fi.util;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Beca;

public class ListaBeca {
	private ArrayList<Beca> becas;
	
	public ListaBeca() {
		// crear el arrayList
		becas = new ArrayList<Beca>();		
	}
	
	/*métodos accesores*/
	public ArrayList<Beca> getBecas() {
		return becas;
	}

	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}
}
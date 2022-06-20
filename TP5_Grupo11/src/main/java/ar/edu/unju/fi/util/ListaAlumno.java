package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Alumno;
@Component
public class ListaAlumno {
	private ArrayList<Alumno> alumnos;
	
	public ListaAlumno() {
		// crear el arrayList
		alumnos = new ArrayList<Alumno>();
		//alumnos.add(new Alumno(38469753,"Pablo","Alavar","ema@gmail.com","3884454801",true));

	}
	
	/*métodos accesores*/
	public ArrayList<Alumno> getAlumno() {
		return alumnos;
	}

	public void setAlumno(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
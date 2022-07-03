package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Alumno;

public interface IAlumnoService {

	public Alumno getAlumno();
	public boolean saveAlumno(Alumno alumno);
	public void modifyAlumno(Alumno alumno);
	public void deleteAlumno(int dni);
	public List<Alumno> getAlumnos();
	public Alumno findByDni(int dni);
}

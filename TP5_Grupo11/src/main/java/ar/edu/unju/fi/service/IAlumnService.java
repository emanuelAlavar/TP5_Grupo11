package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Alumno;
@Service
public interface IAlumnService {
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public List<Alumno> obtenerAlumnos();
	public Alumno buscarAlumno(int dni);
	public void modificarAlumno(Alumno alumno);
	public void eliminarAlumno(int dni);	
}
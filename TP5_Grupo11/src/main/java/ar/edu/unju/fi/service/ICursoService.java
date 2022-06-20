package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curso;
@Service
public interface ICursoService {
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public List<Curso> obtenerCursos();
	public Curso buscarCurso(int codigo);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
}
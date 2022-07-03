package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {
	
	public Curso getCurso();
	public boolean saveCurso(Curso curso);
	public void modifyCurso(Curso curso);
	public void deleteCurso(int codigo);
	public List<Curso> getCursos();
	public Curso findByCodigo(int codigo);
;
}

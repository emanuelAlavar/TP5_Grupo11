package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Docente;

public interface IDocenteService {
	public Docente getDocente();
	public boolean saveDocente(Docente docente);
	public void modifyDocente(Docente docente);
	public void deleteDocente(int Dni);
	public List<Docente> getDocentes();
	public Docente findByDni(int Dni);
}

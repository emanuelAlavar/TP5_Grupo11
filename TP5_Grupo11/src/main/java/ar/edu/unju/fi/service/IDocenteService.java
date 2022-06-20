package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Docente;
@Service
public interface IDocenteService {
	
	public Docente getDocente();
	public boolean guardarDocente(Docente docente);
	public List<Docente> obtenerDocentes();
	public Docente buscarDocente(int legajo);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	
	
}

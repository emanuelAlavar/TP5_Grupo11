package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Beca;
@Service
public interface IBecaService {
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public List<Beca> obtenerBecas();
	public Beca buscarBeca(int codigo);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(int codigo);	
}
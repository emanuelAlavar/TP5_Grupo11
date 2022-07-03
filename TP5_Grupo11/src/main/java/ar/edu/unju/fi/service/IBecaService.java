package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Beca;

public interface IBecaService {
	
	public Beca getBeca();
	public boolean saveBeca(Beca beca);
	public void modifyBeca(Beca beca);
	public void deleteBeca(int codigo);
	public List<Beca> getBecas();
	public Beca findByCodigo(int codigo);
}

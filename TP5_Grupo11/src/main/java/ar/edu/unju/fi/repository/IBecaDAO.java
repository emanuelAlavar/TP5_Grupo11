package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.entity.Beca;

public interface IBecaDAO extends JpaRepository<Beca, Long> {
	public Beca findByCodigo(int codigo);
	
	public List<Beca> findByEstadoBeca(boolean estadoBeca);
	
	@Query("from Beca b order by b.estadoBeca")
	public List<Beca> obtenerBecas();
	
	@Modifying
	@Query("delete from Beca b where b.codigo = ?1")
	public void deleteByCodigo(int codigo);
}
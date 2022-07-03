package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Beca;

@Repository
public interface BecaRepository extends JpaRepository<Beca, Long>{
	@Query("delete from Beca b where b.codigo =?1")
	public boolean deleteBecaByCodigo(int codigo);
	
	public List<Beca> findAll();
	
	@Query("select b from Beca b where b.codigo = ?1")
	public Beca findByCodigo(int codigo);	
}

package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.entity.Curso;

public interface ICursoDAO extends JpaRepository<Curso, Long>{
	public Curso findByCodigo(int codigo);
	
	public List<Curso> findByEstado(boolean estado);
	
	@Query("from Curso c order by c.titulo")
	public List<Curso> obtenerCursos();
	
	@Modifying
	@Query
	public void deleteByCodigo(int codigo);
	
}

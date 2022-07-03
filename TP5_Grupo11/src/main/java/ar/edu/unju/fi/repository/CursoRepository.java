package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Query("delete from Curso c where c.codigo =?1")
	public boolean deleteCursoByCodigo(int codigo);
	
	public List<Curso> findAll();
	
	@Query("select c from Curso c where c.codigo = ?1")
	public Curso findByCodigo(int codigo);	
}

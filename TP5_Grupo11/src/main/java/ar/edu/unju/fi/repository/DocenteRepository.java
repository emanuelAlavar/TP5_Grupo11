package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

	@Query("delete from Docente d where d.dni =?1")
	public boolean deleteDocenteByDni(int dni);
	
	public List<Docente> findAll();
	
	@Query("select d from Docente d where d.dni = ?1")
	public Docente findByDni(int dni);	
	
}

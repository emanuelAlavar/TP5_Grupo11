package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.entity.Docente;

public interface IDocenteDAO extends JpaRepository<Docente, Long> {
	public Docente findByLegajo(int legajo);
	
	public List<Docente> findByEstado(boolean estado);
	
	@Query("from Docente d order by d.nombre")
	public List<Docente> obtenerDocentes();
	
	@Modifying
	@Query("delete from Docente d where d.legajo = ?1")
	public void deleteByLegajo(int legajo);
}
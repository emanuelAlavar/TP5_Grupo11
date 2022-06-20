package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.entity.Alumno;

public interface IAlumnDAO extends JpaRepository<Alumno, Long>{
	
	public Alumno findByDni(int dni);
	
	public List<Alumno> findByEstado(boolean estado);
	
	@Query("from Alumno a order by a.nombre")
	public List<Alumno> obtenerAlumnos();
	
	@Modifying
	@Query("delete from Alumno a where a.dni = ?1")
	public void deleteByDni(int dni);
}
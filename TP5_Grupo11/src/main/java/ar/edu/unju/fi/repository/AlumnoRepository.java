package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	@Query("delete from Alumno a where a.dni =?1")
	public boolean deleteAlumnoByDni(int dni);
	
	public List<Alumno> findAll();
	
	@Query("select a from Alumno a where a.dni = ?1")
	public Alumno findByDni(int dni);
}

package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.AlumnoController;
import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImp implements IAlumnoService {
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);

	@Autowired
	AlumnoRepository alumnoRepo;

	@Override
	public Alumno getAlumno() {
		LOGGER.info("Se ha creado un nuevo alumno");
		return new Alumno();
	}

	@Override
	public boolean saveAlumno(Alumno alumno) {
		if(alumnoRepo.findByDni(alumno.getDni()) != null) {
			LOGGER.info("Ya existe un alumno con el DNI: "+alumno.getDni()+" registrado");
			return false;
		}
		try {
			alumno.addCurso(alumno.getClase());
			if(alumnoRepo.save(alumno)!=null) {
				LOGGER.info("Se ha agregado un alumno a la lista");
				return true;
			} else {
				LOGGER.info("Hubo un error al agregar el nuevo alumno");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al agregar el nuevo alumno");
			return false;
		}
	}

	@Override
	public void modifyAlumno(Alumno alumno) {
		Alumno a = alumnoRepo.findByDni(alumno.getDni());
		if(a != null) {
			try {
				a.setNombre(alumno.getNombre());
				a.setApellido(alumno.getApellido());
				a.setEmail(alumno.getEmail());
				a.setTelefono(alumno.getTelefono());
				alumnoRepo.save(a);
				LOGGER.info("Se ha modificado el alumno con DNI: "+alumno.getDni());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LOGGER.info("Hubo un error al modificar el alumno con DNI: "+alumno.getDni());
			}
		}
		LOGGER.info("No se ha encontrado al alumno con DNI: "+alumno.getDni());
	}

	@Override
	public void deleteAlumno(int dni) {
		try {
			if(alumnoRepo.deleteAlumnoByDni(dni)) {
				LOGGER.info("Se ha eliminado el alumno con DNI: "+dni);
			} else {
				LOGGER.info("No se ha encontrado al alumno con DNI: "+dni);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al eliminar al alumno con DNI: "+dni);
		}
	}
	
	@Override
	public List<Alumno> getAlumnos() {
		return alumnoRepo.findAll();
	}

	@Override
	public Alumno findByDni(int dni) {
		Alumno a = alumnoRepo.findByDni(dni);
		if(a!=null) {			
			LOGGER.info("Se ha encontrado al alumno con DNI: "+a.getDni());
			return a;
		}
		LOGGER.info("No se ha encontrado al alumno con DNI: "+dni);
		return a;
	}
}

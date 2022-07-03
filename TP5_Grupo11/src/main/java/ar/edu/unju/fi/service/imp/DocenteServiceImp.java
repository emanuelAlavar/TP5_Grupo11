package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.AlumnoController;
import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	DocenteRepository docenteRepo;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
	@Override
	public Docente getDocente() {
		return new Docente();
	}

	@Override
	public boolean saveDocente(Docente docente) {
		if(docenteRepo.findByDni(docente.getDni()) != null) {
			LOGGER.info("Ya existe un docente con el Dni: "+docente.getDni()+" registrado");
			return false;
		}
		try {
			if(docenteRepo.save(docente)!=null) {
				LOGGER.info("Se ha agregado un docente a la lista");
				return true;
			} else {
				LOGGER.info("Hubo un error al agregar el nuevo docente");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al agregar el nuevo docente");
			return false;
		}
	}

	@Override
	public void modifyDocente(Docente docente) {
		Docente d = docenteRepo.findByDni(docente.getDni());
		if(d != null) {
			try {
				d.setNombre(docente.getNombre());
				d.setApellido(docente.getApellido());
				d.setEmail(docente.getEmail());
				d.setTelefono(docente.getTelefono());
				d.setCursos(docente.getCursos());
				docenteRepo.save(d);
				LOGGER.info("Se ha modificado el curso con el Dni: "+docente.getDni());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LOGGER.info("Hubo un error al modificar el curso con el Dni: "+docente.getDni());
			}
		}
		LOGGER.info("No se ha encontrado el docente con el Dni: "+docente.getDni());
	}

	@Override
	public void deleteDocente(int dni) {
		try {
			if(docenteRepo.deleteDocenteByDni(dni)) {
				LOGGER.info("Se ha eliminado el docente con el Dni: "+dni);
			} else {
				LOGGER.info("No se ha encontrado el docente con el Dni: "+dni);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al eliminar el docente con el Dni: "+dni);
		}
	}

	@Override
	public List<Docente> getDocentes() {
		return docenteRepo.findAll();
	}

	@Override
	public Docente findByDni(int dni) {
		Docente d = docenteRepo.findByDni(dni);
		if(d!=null) {			
			LOGGER.info("Se ha encontrado el docente con el Dni: "+d.getDni());
			return d;
		}
		LOGGER.info("No se ha encontrado el docente con el Dni: "+dni);
		return d;
	}

}

package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.AlumnoController;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.CursoRepository;
import ar.edu.unju.fi.service.ICursoService;

@Service
public class CursoServiceImp implements ICursoService {
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);

	@Autowired
	CursoRepository cursoRepo;
	
	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public boolean saveCurso(Curso curso) {
		if(cursoRepo.findByCodigo(curso.getCodigo()) != null) {
			LOGGER.info("Ya existe un curso con el Codigo: "+curso.getCodigo()+" registrado");
			return false;
		}
		try {
			curso.addDocente(curso.getPrincipal());;
			if(cursoRepo.save(curso)!=null) {
				LOGGER.info("Se ha agregado un curso a la lista");
				return true;
			} else {
				LOGGER.info("Hubo un error al agregar el nuevo curso");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al agregar el nuevo curso");
			return false;
		}
	}

	@Override
	public void modifyCurso(Curso curso) {
		Curso c = cursoRepo.findByCodigo(curso.getCodigo());
		if(c != null) {
			try {
				c.setTitulo(curso.getTitulo());;
				c.setModalidad(curso.getModalidad());
				c.setFechaFin(curso.getFechaFin());
				c.setFechaInicio(curso.getFechaInicio());
				c.setHoras(curso.getHoras());
				c.setDocentes(curso.getDocentes());
				c.setAlumnos(curso.getAlumnos());
				c.setBecas(curso.getBecas());
				c.setCategoria(curso.getCategoria());
				c.setPrincipal(curso.getPrincipal());
				cursoRepo.save(c);
				LOGGER.info("Se ha modificado el curso con el Codigo: "+curso.getCodigo());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LOGGER.info("Hubo un error al modificar el curso con el Codigo: "+curso.getCodigo());
			}
		}
		LOGGER.info("No se ha encontrado el curso con el Codigo: "+curso.getCodigo());
	}

	@Override
	public void deleteCurso(int codigo) {
		try {
			if(cursoRepo.deleteCursoByCodigo(codigo)) {
				LOGGER.info("Se ha eliminado el curso con el Codigo: "+codigo);
			} else {
				LOGGER.info("No se ha encontrado el curso con el Codigo: "+codigo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al eliminar el curso con el Codigo: "+codigo);
		}
	}

	@Override
	public List<Curso> getCursos() {
		return cursoRepo.findAll();
	}

	@Override
	public Curso findByCodigo(int codigo) {
		Curso c = cursoRepo.findByCodigo(codigo);
		if(c!=null) {			
			LOGGER.info("Se ha encontrado el curso con el Codigo: "+c.getCodigo());
			return c;
		}
		LOGGER.info("No se ha encontrado el curso con el Codigo: "+codigo);
		return c;
	}

}

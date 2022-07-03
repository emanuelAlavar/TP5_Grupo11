package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.AlumnoController;
import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.repository.BecaRepository;
import ar.edu.unju.fi.service.IBecaService;

@Service
public class BecaServiceImp implements IBecaService {

	@Autowired
	BecaRepository becaRepo;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);

	@Override
	public Beca getBeca() {
		return new Beca();
	}

	@Override
	public boolean saveBeca(Beca beca) {
		if(becaRepo.findByCodigo(beca.getCodigo()) != null) {
			LOGGER.info("Ya existe una beca con el Codigo: "+beca.getCodigo()+" registrado");
			return false;
		}
		try {
			if(becaRepo.save(beca)!=null) {
				LOGGER.info("Se ha agregado una beca a la lista");
				return true;
			} else {
				LOGGER.info("Hubo un error al agregar la nueva beca");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al agregar la nueva beca");
			return false;
		}
	}

	@Override
	public void modifyBeca(Beca beca) {
		Beca b = becaRepo.findByCodigo(beca.getCodigo());
		if(b != null) {
			try {
				b.setEstado(beca.getEstado());
				b.setFechaCierre(beca.getFechaCierre());
				b.setFechaInicio(beca.getFechaInicio());
				becaRepo.save(b);
				LOGGER.info("Se ha modificado la beca con el Codigo: "+beca.getCodigo());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LOGGER.info("Hubo un error al modificar la beca con el Codigo: "+beca.getCodigo());
			}
		}
		LOGGER.info("No se ha encontrado la beca con el Codigo: "+beca.getCodigo());

	}

	@Override
	public void deleteBeca(int codigo) {
		try {
			if(becaRepo.deleteBecaByCodigo(codigo)) {
				LOGGER.info("Se ha eliminado la beca con el Codigo: "+codigo);
			} else {
				LOGGER.info("No se ha encontrado la beca con el Codigo: "+codigo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.info("Hubo un error al eliminar la beca con el Codigo: "+codigo);
		}
	}

	@Override
	public List<Beca> getBecas() {
		return becaRepo.findAll();
	}

	@Override
	public Beca findByCodigo(int codigo) {
		Beca b = becaRepo.findByCodigo(codigo);
		if(b!=null) {			
			LOGGER.info("Se ha encontrado la beca con el Codigo: "+b.getCodigo());
			return b;
		}
		LOGGER.info("No se ha encontrado la beca con el Codigo: "+codigo);
		return b;
	}

}

package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.repository.IDocenteDAO;
import ar.edu.unju.fi.service.IDocenteService;

@Service("DocenteServiceImp")
public class DocenteServiceImp implements IDocenteService {
	@Autowired
	private IDocenteDAO docenteDaoImp;

	@Override
	public Docente getDocente() {
		// TODO Auto-generated method stub
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		docente.setEstado(true);
		if(docenteDaoImp.save(docente)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Docente> obtenerDocentes() {
		// TODO Auto-generated method stub
		return docenteDaoImp.findByEstado(true);
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// TODO Auto-generated method stub
		return docenteDaoImp.findByLegajo(legajo);
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub
		Docente doc = docenteDaoImp.findByLegajo(docente.getLegajo());
		doc.setNombre(docente.getNombre());
		doc.setApellido(docente.getApellido());
		doc.setEmail(docente.getEmail());
		doc.setTelefono(docente.getTelefono());
		docenteDaoImp.save(doc);
	}

	@Override
	@Transactional
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub
		Docente docente = buscarDocente(legajo);
		docente.setEstado(false);
		docenteDaoImp.save(docente);		
	}
}
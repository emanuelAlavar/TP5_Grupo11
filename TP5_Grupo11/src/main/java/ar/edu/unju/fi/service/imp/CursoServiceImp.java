package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoDAO;
import ar.edu.unju.fi.service.ICursoService;

@Service("CursoServiceImp")
public class CursoServiceImp implements ICursoService {
	
	@Autowired
	private ICursoDAO cursoDaoImp;
	
	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		curso.setEstado(true);
		if(cursoDaoImp.save(curso)!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Curso> obtenerCursos() {
		// TODO Auto-generated method stub
		return cursoDaoImp.findByEstado(true);
	}
	
	@Override
	public Curso buscarCurso(int codigo) {
		// TODO Auto-generated method stub
		return cursoDaoImp.findByCodigo(codigo);
	}
	
	@Override
	public void modificarCurso(Curso curso) {
		Curso cur = cursoDaoImp.findByCodigo(curso.getCodigo());
		cur.setTitulo(curso.getTitulo());
		cur.setCategoria(curso.getCategoria());
		cur.setFechaInicio(curso.getFechaInicio());
		cur.setFechaFin(curso.getFechaFin());
		cur.setHoras(curso.getHoras());
		cur.setModalidad(curso.getModalidad());		
		cursoDaoImp.save(cur);
	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub
		Curso curso = buscarCurso(codigo);
		curso.setEstado(false);
		cursoDaoImp.save(curso);
	}
}
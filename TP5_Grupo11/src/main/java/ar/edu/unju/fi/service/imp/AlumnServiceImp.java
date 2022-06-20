package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.repository.IAlumnDAO;
import ar.edu.unju.fi.service.IAlumnService;

@Service
public class AlumnServiceImp implements IAlumnService {
	@Autowired
	private IAlumnDAO alumnoDaoImp;
	
	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumno.setEstado(true);
		if(alumnoDaoImp.save(alumno)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		return alumnoDaoImp.findByEstado(true);
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		return alumnoDaoImp.findByDni(dni);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		Alumno alu =  alumnoDaoImp.findByDni(alumno.getDni());
		alu.setNombre(alumno.getNombre());
		alu.setApellido(alumno.getApellido());
		alu.setEmail(alumno.getEmail());
		alu.setTelefono(alumno.getTelefono());
		alumnoDaoImp.save(alu);
	}

	@Override
	@Transactional
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		Alumno alumno = buscarAlumno(dni);
		alumno.setEstado(false);
		alumnoDaoImp.save(alumno);
	}
}
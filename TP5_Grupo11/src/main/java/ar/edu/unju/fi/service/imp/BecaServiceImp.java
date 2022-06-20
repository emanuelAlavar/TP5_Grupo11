package ar.edu.unju.fi.service.imp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.repository.IBecaDAO;
import ar.edu.unju.fi.service.IBecaService;

@Service
public class BecaServiceImp implements IBecaService {
	
	@Autowired
	private IBecaDAO becaDaoImp;
	
	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// TODO Auto-generated method stub
		beca.setEstadoBeca(true);
		if(becaDaoImp.save(beca)!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Beca> obtenerBecas() {
		// TODO Auto-generated method stub
		return becaDaoImp.findByEstadoBeca(true);
	}
	
	@Override
	public Beca buscarBeca(int codigo) {
		// TODO Auto-generated method stub
		return becaDaoImp.findByCodigo(codigo);
	}

	@Override
	public void modificarBeca(Beca beca) {
		Beca bec = becaDaoImp.findByCodigo(beca.getCodigo());
		bec.setFechaInicio(beca.getFechaInicio());
		bec.setFechaCierre(beca.getFechaCierre());
		bec.setEstado(beca.getEstado());
		becaDaoImp.save(bec);
	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub
		Beca beca = buscarBeca(codigo);
		beca.setEstadoBeca(false);
		becaDaoImp.save(beca);
	}
}
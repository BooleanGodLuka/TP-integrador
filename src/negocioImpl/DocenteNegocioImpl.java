package negocioImpl;

import java.util.List;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import dominio.Docente;
import negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio{

	DocenteDao docdao = new DocenteDaoImpl();
	
	public boolean insert(Docente docente) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Docente docente_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Docente> readall() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Docente> readall(String consigna) {
		// TODO Auto-generated method stub
		return docdao.readall(consigna);
	}

	public boolean update(Docente docente_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

}

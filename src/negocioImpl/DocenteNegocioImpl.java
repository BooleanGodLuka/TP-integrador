package negocioImpl;

import java.util.List;

import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import dominio.Docente;
import negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio {

	DocenteDao docdao = new DocenteDaoImpl();

	public boolean insert(Docente docente) {
		return docdao.insert(docente);
	}

	public boolean delete(Docente docente_a_eliminar) {
		return docdao.delete(docente_a_eliminar);
	}

	public List<Docente> readall() {
		return docdao.readall();
	}

	public List<Docente> readall(String consigna) {
		return docdao.readall(consigna);
	}

	public boolean update(Docente docente_a_modificar) {
		return docdao.update(docente_a_modificar);
	}

}

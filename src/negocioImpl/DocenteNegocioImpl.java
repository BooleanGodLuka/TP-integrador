package negocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import Dao.DocenteDao;
import DaoImpl.DocenteDaoImpl;
import dominio.Docente;
import negocio.DocenteNegocio;

public class DocenteNegocioImpl implements DocenteNegocio {

	DocenteDao docdao = new DocenteDaoImpl();

	public boolean insert(Docente docente) {
		return docdao.insert(docente);
	}

	public boolean delete(String id) {
		return docdao.delete(id);
	}

	public ArrayList<Docente> readall() {
		return docdao.readall();
	}

	public ArrayList<Docente> readall(String consigna) {
		return docdao.readall(consigna);
	}

	public boolean update(Docente docente_a_modificar) {
		return docdao.update(docente_a_modificar);
	}

	public String getNombreDocente(int iddocente) throws SQLException {
		return docdao.getNombreDocente(iddocente);
	}

	@Override
	public String getApellidoDocente(int iddocente) throws SQLException {
		return docdao.getApellidoDocente(iddocente);
	}

}

package negocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import Dao.MateriaDao;
import DaoImpl.MateriaDaoImpl;
import dominio.Materia;
import negocio.MateriaNegocio;

public class MateriaNegocioImpl implements MateriaNegocio{
	
	MateriaDao mdao = new MateriaDaoImpl();

	@Override
	public boolean insert(Materia materia) {
		return mdao.insert(materia);
	}

	@Override
	public boolean delete(Materia materia) {
		return mdao.delete(materia);
	}

	@Override
	public ArrayList<Materia> readall() {
		return mdao.readall();
	}

	@Override
	public boolean update(Materia materia) {
		return mdao.update(materia);
	}

	@Override
	public String getNombreMateria(int idmateria) throws SQLException {
		return	mdao.getNombreMateria(idmateria);
		
	}


}

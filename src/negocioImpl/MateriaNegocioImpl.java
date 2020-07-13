package negocioImpl;

import java.util.List;

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
	public boolean delete(Materia materia_a_eliminar) {
		return mdao.delete(materia_a_eliminar);
	}

	@Override
	public List<Materia> readall() {
		return mdao.readall();
	}

	@Override
	public boolean update(Materia materia_a_modificar) {
		return mdao.update(materia_a_modificar);
	}

	@Override
	public Materia read(int idmateria) {
		// TODO Auto-generated method stub
		return mdao.read(idmateria);
	}

}

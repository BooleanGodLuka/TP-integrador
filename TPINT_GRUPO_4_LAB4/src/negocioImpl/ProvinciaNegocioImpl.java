package negocioImpl;

import java.util.List;

import Dao.ProvinciaDao;
import DaoImpl.ProvinciaDaoImpl;
import dominio.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio{
	
	ProvinciaDao dao = new ProvinciaDaoImpl();

	@Override
	public boolean insert(Provincia provincia) {
		return dao.insert(provincia);
	}

	@Override
	public boolean delete(Provincia provincia_a_borrar) {
		return dao.delete(provincia_a_borrar);
	}

	@Override
	public List<Provincia> readall() {
		return dao.readall();
	}

	@Override
	public boolean update(Provincia provincia_a_modificar) {
		return dao.update(provincia_a_modificar);
	}

}

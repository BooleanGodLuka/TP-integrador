package negocioImpl;

import java.util.List;

import Dao.LocalidadDao;
import DaoImpl.LocalidadDaoImpl;
import dominio.Localidad;
import dominio.Provincia;
import negocio.LocalidadNegocio;

public class LocalidadNegocioImpl implements LocalidadNegocio{
	
	LocalidadDao ldao = new LocalidadDaoImpl();

	@Override
	public boolean insert(Localidad localidad) {
		return ldao.insert(localidad);
	}

	@Override
	public boolean delete(Localidad localidad_a_borrar) {
		return ldao.delete(localidad_a_borrar);
	}

	@Override
	public List<Localidad> readall() {
		return ldao.readall();
	}

	@Override
	public List<Localidad> readall(Provincia provincia_seleccionada) {
		return ldao.readall(provincia_seleccionada);
	}

	@Override
	public boolean update(Localidad localidad_a_modificar) {
		return ldao.update(localidad_a_modificar);
	}

}

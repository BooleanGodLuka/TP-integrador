package negocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import Dao.ProvinciaDao;
import DaoImpl.ProvinciaDaoImpl;
import dominio.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio{
	
	ProvinciaDao provdao = new ProvinciaDaoImpl();

	@Override
	public boolean insert(Provincia provincia) {
		return provdao.insert(provincia);
	}

	@Override
	public boolean delete(Provincia provincia_a_borrar) {
		return provdao.delete(provincia_a_borrar);
	}

	@Override
	public ArrayList<Provincia> readall() {
		return provdao.readall();
	}

	@Override
	public boolean update(Provincia provincia_a_modificar) {
		return provdao.update(provincia_a_modificar);
	}

	@Override
	public String getNombreProvincia(String idlocalidad) throws SQLException {
		return provdao.getNombreProvincia(idlocalidad);
	}
	

}

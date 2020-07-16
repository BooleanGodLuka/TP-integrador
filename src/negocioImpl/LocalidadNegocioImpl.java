package negocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.LocalidadDao;
import DaoImpl.LocalidadDaoImpl;
import dominio.Localidad;
import negocio.LocalidadNegocio;

public class LocalidadNegocioImpl implements LocalidadNegocio{
	
	LocalidadDao ldao = new LocalidadDaoImpl();

	@Override
	public ArrayList<Localidad> readall(String idprovincia) {
		return ldao.readall(idprovincia);
	}


	@Override
	public String getNombreLocalidad(String idlocalidad) throws SQLException {
		return ldao.getNombreLocalidad(idlocalidad);
	}
	
	

}

package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Localidad;

public interface LocalidadNegocio {
	
	public ArrayList<Localidad> readall(String idprovincia);
	
	public ArrayList<Localidad> readall();
	
	public String getNombreLocalidad (String idlocalidad) throws SQLException;
}

package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import dominio.Provincia;

public interface ProvinciaNegocio {

	public boolean insert(Provincia provincia);

	public boolean delete(Provincia provincia_a_borrar);

	public ArrayList<Provincia> readall();

	public boolean update(Provincia provincia_a_modificar);
	
	public String getNombreProvincia(String idlocalidad) throws SQLException;

}

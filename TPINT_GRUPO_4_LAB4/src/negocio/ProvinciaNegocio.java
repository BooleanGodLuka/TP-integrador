package negocio;

import java.util.List;

import dominio.Provincia;

public interface ProvinciaNegocio {

	public boolean insert(Provincia provincia);

	public boolean delete(Provincia provincia_a_borrar);

	public List<Provincia> readall();

	public boolean update(Provincia provincia_a_modificar);

}

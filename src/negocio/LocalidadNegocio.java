package negocio;

import java.util.List;

import dominio.Localidad;

public interface LocalidadNegocio {

	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_borrar);

	public List<Localidad> readall();
	public List<Localidad> readall(String idprovincia);

	public boolean update(Localidad localidad_a_modificar);

}

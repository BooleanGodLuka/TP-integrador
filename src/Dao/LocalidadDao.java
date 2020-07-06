package Dao;

import java.util.List;

import dominio.Localidad;
import dominio.Provincia;

public interface LocalidadDao {

	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_borrar);

	public List<Localidad> readall();
	public List<Localidad> readall(Provincia provincia_seleccionada);

	public boolean update(Localidad localidad_a_modificar);

}

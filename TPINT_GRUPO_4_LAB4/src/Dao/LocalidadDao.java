package Dao;

import java.util.List;

import dominio.Localidad;

public interface LocalidadDao {

	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_borrar);

	public List<Localidad> readall();

	public boolean update(Localidad localidad_a_modificar);

}

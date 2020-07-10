package Dao;

import java.util.ArrayList;
import dominio.Localidad;

public interface LocalidadDao {

	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_eliminar);

	public ArrayList<Localidad> readall();
	
	public ArrayList<Localidad> readall(String idprovincia);

	public boolean update(Localidad localidad_a_modificar);

}

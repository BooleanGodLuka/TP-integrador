package Dao;

import java.util.ArrayList;
import dominio.Provincia;

public interface ProvinciaDao {

	public boolean insert(Provincia provincia);

	public boolean delete(Provincia provincia_a_borrar);

	public ArrayList<Provincia> readall();
	
	public ArrayList<Provincia> readall(String consigna);

	public boolean update(Provincia provincia_a_modificar);

}

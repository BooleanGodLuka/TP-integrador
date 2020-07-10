package Dao;

import java.util.ArrayList;
import dominio.Materia;

public interface MateriaDao {

	public boolean insert(Materia materia);

	public boolean delete(Materia materia);

	public ArrayList<Materia> readall();
	
	public Materia read(int idmateria);

	public boolean update(Materia materia);

}

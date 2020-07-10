package Dao;

import java.util.ArrayList;
import dominio.Materia;

public interface MateriaDao {

	public boolean insert(Materia materia);

	public boolean delete(Materia materia_a_eliminar);

	public ArrayList<Materia> readall();

	public boolean update(Materia materia_a_modificar);

}

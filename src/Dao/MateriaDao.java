package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import dominio.Materia;

public interface MateriaDao {

	public boolean insert(Materia materia);

	public boolean delete(Materia materia);

	public ArrayList<Materia> readall();
	
	public boolean update(Materia materia);

	public String getNombreMateria(int idmateria) throws SQLException;

}

package Dao;

import java.util.List;
import dominio.Docente;

public interface DocenteDao {

	public boolean insert(Docente docente);
	
	public boolean delete(Docente docente_a_eliminar);
	
	public List<Docente> readall();
	
	public List<Docente> readall(String consigna);
	
	public boolean update(Docente docente_a_modificar);
}

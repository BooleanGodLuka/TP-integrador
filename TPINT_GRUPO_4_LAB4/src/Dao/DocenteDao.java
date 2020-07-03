package Dao;

import java.util.List;
import dominio.Docente;

public interface DocenteDao {

	public boolean insert(Docente docente);
	
	public boolean delete(Docente docente_a_borrar);
	
	public List<Docente> select_docentes();
	
	public List<Docente> select_docente_consigna(String consigna);
	
	public boolean update(Docente docente_a_modificar);
}

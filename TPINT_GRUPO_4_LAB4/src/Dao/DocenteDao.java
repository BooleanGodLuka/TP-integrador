package Dao;

import java.util.List;
import dominio.Docente;

public interface DocenteDao {

	public boolean insert_docente(Docente docente);
	
	public boolean delete_docente(Docente docente);
	
	public List<Docente> select_docentes();
	
	public List<Docente> select_docentes_consigna(String consigna);
	
	public boolean update_docente(Docente docente_a_modificar);
}

package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Docente;

public interface DocenteDao {

	public boolean insert(Docente docente);
	
	public boolean delete(String docente_a_eliminar);
	
	public ArrayList<Docente> readall();
	
	public ArrayList<Docente> readall(String consigna);
	
	public boolean update(Docente docente_a_modificar);
	
	public String getNombreDocente(int iddocente) throws SQLException;
	
	public String getApellidoDocente(int iddocente) throws SQLException;
	
	public int getIDUltimoDocente ();
}

package negocio;

import java.util.ArrayList;
import java.util.List;

import dominio.Docente;
import dominio.Reporte;

public interface DocenteNegocio {

	public boolean insert(Docente docente);
	
	public boolean delete(Docente docente_a_eliminar);
	
	public List<Docente> readall();
	
	public List<Docente> readall(String consigna);
	
	public boolean update(Docente docente_a_modificar);

}

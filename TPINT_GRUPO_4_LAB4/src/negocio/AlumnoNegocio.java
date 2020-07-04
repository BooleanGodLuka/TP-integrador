package negocio;

import java.util.List;

import dominio.Alumno;

public interface AlumnoNegocio {
	
	public boolean insert_alumno(Alumno alumno);
	
	public boolean delete_alumno(Alumno alumno);
	
	public List<Alumno> select_alumnos();
	
	public List<Alumno>select_alummnos_consigna(String consigna);

	public boolean update_alumno(Alumno alumno);
	
}

package negocio;

import java.util.List;

import dominio.Alumno;

public interface AlumnoNegocio {

	public boolean insert(Alumno alumno);

	public boolean delete(Alumno alumno_a_borrar);

	public List<Alumno> readall();

	public List<Alumno> readall(String consigna);

	public boolean update(Alumno alumno_a_modificar);

}
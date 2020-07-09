package Dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Curso;
import dominio.alumnoXcurso;


public interface CursoDao {
	
	public boolean insert(Curso curso);
	
	public boolean delete(Curso curso_a_eliminar);
	
	public ArrayList<Curso> readall();
	public ArrayList<Curso> readall(String consigna);
	
	public boolean update (Curso curso_a_modificar);
	
	public ArrayList <alumnoXcurso> leer_alumnoXcurso(String id_curso);
	
	public boolean actualizar_alumnoXcurso (alumnoXcurso alumno);
	
	public String leer_materia (String id);

}

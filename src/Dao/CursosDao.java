package Dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Curso;
import dominio.alumnoXcurso;


public interface CursosDao {
	
	public boolean agregar_curso(Curso curso);
	
	public boolean borrar_curso(Curso curso_a_borrar);
	
	public ArrayList<Curso> leer_todo_curso();
	public ArrayList<Curso> leer_todo_curso_consigna(String consigna);
	
	public boolean actualizar_curso (Curso curso_a_modificar);
	
	public ArrayList <alumnoXcurso> leer_alumnoXcurso(String id_curso);
	
	public boolean actualizar_alumnoXcurso (alumnoXcurso alumno);

}

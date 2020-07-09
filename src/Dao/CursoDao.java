package Dao;

import java.util.ArrayList;

import dominio.Curso;
import dominio.alumnoXcurso;


public interface CursoDao {
	
	public boolean agregar_curso(Curso curso);
	
	public boolean borrar_curso(Curso curso_a_borrar);
	
	public ArrayList<Curso> leer_todo_curso();
	public ArrayList<Curso> leer_todo_curso_consigna(String consigna);
	
	public boolean actualizar_curso (Curso curso_a_modificar);
	
	public ArrayList <alumnoXcurso> leer_alumnoXcurso(String id_curso);

}

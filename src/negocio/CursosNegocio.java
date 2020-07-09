package negocio;

import java.util.ArrayList;
import java.util.List;

import dominio.Curso;
import dominio.alumnoXcurso;

public interface CursosNegocio {

	public boolean insert(Curso curso);
	
	public boolean insert(Curso curso_a_eliminar);
	
	public ArrayList<Curso> readall();
	public ArrayList<Curso> readall(String consigna);
	
	public boolean update (Curso curso_a_modificar);
	
	public ArrayList <alumnoXcurso> leer_alumnoXcurso(String id_curso);
	
	public boolean actualizar_alumnoXcurso (alumnoXcurso alumno);
	
	public int calcular_cant_alumnXcurso (String id);
	
	public int calcular_cant_alumnXcurso_aprob (String id);
	
	public int calcular_cant_alumnXcurso_desap (String id);
	
	public String leer_materia (String id);
}

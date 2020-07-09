package negocio;

import java.util.ArrayList;

import dominio.Curso;
import dominio.alumnoXcurso;

public interface CursoNegocio {

	public boolean insert(Curso curso);

	public boolean delete(Curso curso_a_eliminar);

	public ArrayList<Curso> readall();

	public ArrayList<Curso> readall(String consigna);

	public boolean update(Curso curso_a_modificar);

	public boolean actualizar_alumnoXcurso(alumnoXcurso alumno);

	public String leer_materia(int id);

	int calcular_cant_alumnXcurso_aprob(int id);

	int calcular_cant_alumnXcurso_desap(int id);

	int calcular_cant_alumnXcurso(int id);

	ArrayList<alumnoXcurso> leer_alumnoXcurso(int id_curso);
	
	public String leer_ultimo_curso_id ();
	
	public boolean insert_alumnoXcurso (alumnoXcurso alumno);
}

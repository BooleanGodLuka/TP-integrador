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

	public ArrayList<alumnoXcurso> leer_alumnoXcurso(String id_curso);

	public boolean actualizar_alumnoXcurso(alumnoXcurso alumno);

	public int calcular_cant_alumnXcurso(String id);

	public int calcular_cant_alumnXcurso_aprob(String id);

	public int calcular_cant_alumnXcurso_desap(String id);

	public int leer_materia(int id);
}

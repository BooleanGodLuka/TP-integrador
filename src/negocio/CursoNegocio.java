package negocio;

import java.util.ArrayList;

import dominio.Curso;
import dominio.AlumnoXCurso;

public interface CursoNegocio {

	public boolean insert(Curso curso);

	public boolean delete(Curso curso_a_eliminar);

	public ArrayList<Curso> readall();

	public ArrayList<Curso> readall(String consigna);

	public boolean update(Curso curso_a_modificar);
	
	public ArrayList<Curso> leer_ultimo_curso_id ();


}

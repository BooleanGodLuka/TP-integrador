package Dao;

import java.util.ArrayList;

import dominio.Curso;

public interface CursoDao {

	public boolean insert(Curso curso);

	public boolean delete(Curso curso);

	public ArrayList<Curso> readall();

	public ArrayList<Curso> readall(String consigna);
	
	public Curso read(int idcurso);

	public boolean update(Curso curso);

	public ArrayList<Curso> leer_ultimo_curso_id ();
}

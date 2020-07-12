package Dao;

import java.util.ArrayList;

import dominio.AlumnoXCurso;
import dominio.Curso;

public interface AlumnoXCursoDao {

	public ArrayList<AlumnoXCurso> readall(int idcurso);

	public boolean insert(AlumnoXCurso axc);

	public boolean update(AlumnoXCurso axc);

	public String leer_ultimo_curso_id();


}
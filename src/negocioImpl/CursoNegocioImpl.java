package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.CursoDao;
import DaoImpl.CursoDaoImpl;
import dominio.Curso;
import dominio.alumnoXcurso;
import negocio.CursoNegocio;

public class CursoNegocioImpl implements CursoNegocio {

	
	CursoDao cudao = new CursoDaoImpl();
	
	
	@Override
	public boolean agregar_curso(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar_curso(Curso curso_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Curso> leer_todo_curso() {
		// TODO Auto-generated method stub
		
		return cudao.leer_todo_curso();
	}

	
	
	
	
	
	@Override
	public ArrayList<Curso> leer_todo_curso_consigna(String consigna) {
		// TODO Auto-generated method stub
		return cudao.leer_todo_curso_consigna(consigna);
	}

	@Override
	public boolean actualizar_curso(Curso curso_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<alumnoXcurso> leer_alumnoXcurso(String id_curso) {
		// TODO Auto-generated method stub
		return cudao.leer_alumnoXcurso(id_curso);
	}

}

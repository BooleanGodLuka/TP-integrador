package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.CursosDao;
import DaoImpl.CursoDaoImpl;
import dominio.Curso;
import dominio.alumnoXcurso;
import negocio.CursosNegocio;

public class CursosNegocioImpl implements CursosNegocio {

	
	CursoDaoImpl cudao =  new CursoDaoImpl();
	
	
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

	@Override
	public boolean actualizar_alumnoXcurso(alumnoXcurso alumno) {
		// TODO Auto-generated method stub
		return cudao.actualizar_alumnoXcurso(alumno);
	}

	@Override
	public int calcular_cant_alumnXcurso(String id) {
		// TODO Auto-generated method stub
		int cont= 0;
		ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(id);
		
		for (alumnoXcurso al : lista) {
		cont++;
		}
		return cont;
	}

	@Override
	public int calcular_cant_alumnXcurso_aprob(String id) {
		// TODO Auto-generated method stub
		int cont= 0;
		ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(id);
		
		for (alumnoXcurso al : lista) {
		if (al.getNota4()>6) {
			cont++;
		}
		}
		return cont;
	}

	@Override
	public int calcular_cant_alumnXcurso_desap(String id) {
		// TODO Auto-generated method stub
		int cont= 0;
		ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(id);
		
		for (alumnoXcurso al : lista) {
		if (al.getNota4()<6) {
			cont++;
		}
		}
		return cont;
	}

	@Override
	public String leer_materia(String id) {
		// TODO Auto-generated method stub
		return cudao.leer_materia(id);
	}

}
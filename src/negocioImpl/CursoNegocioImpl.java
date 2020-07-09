package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.CursoDao;
import DaoImpl.CursoDaoImpl;
import dominio.Curso;
import dominio.alumnoXcurso;
import negocio.CursosNegocio;

public class CursoNegocioImpl implements CursosNegocio {

	
	CursoDaoImpl cdao =  new CursoDaoImpl();
	
	
	@Override
	public boolean insert(Curso curso) {
		return cdao.insert(curso);
	}

	@Override
	public boolean delete(Curso curso_a_eliminar) {
		return cdao.delete(curso_a_eliminar);
	}

	@Override
	public ArrayList<Curso> readall() {
		return cdao.readall();
	}
	
	@Override
	public ArrayList<Curso> readll(String consigna) {
		return cdao.readall(consigna);
	}

	@Override
	public boolean update(Curso curso_a_modificar) {

		cdao.update(curso_a_modificar);
	}

	@Override
	public ArrayList<alumnoXcurso> leer_alumnoXcurso(String id_curso) {
		return cdao.leer_alumnoXcurso(id_curso);
	}

	@Override
	public boolean actualizar_alumnoXcurso(alumnoXcurso alumno) {
		return cdao.actualizar_alumnoXcurso(alumno);
	}

	@Override
	public int calcular_cant_alumnXcurso(int id) {
		// TODO Auto-generated method stub
		int cont= 0;
		ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(id);
		
		for (alumnoXcurso al : lista) {
		cont++;
		}
		return cont;
	}

	@Override
	public int calcular_cant_alumnXcurso_aprob(int id) {
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
	public int calcular_cant_alumnXcurso_desap(int id) {
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
	public String leer_materia(int id) {
		// TODO Auto-generated method stub
		return cudao.leer_materia(id);
	}

}

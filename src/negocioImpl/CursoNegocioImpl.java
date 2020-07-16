package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.CursoDao;

import DaoImpl.CursoDaoImpl;
import dominio.Curso;
import dominio.AlumnoXCurso;
import negocio.CursoNegocio;

public class CursoNegocioImpl implements CursoNegocio {

	CursoDao cdao = new CursoDaoImpl();

	@Override
	public boolean insert(Curso curso) {
		return cdao.insert(curso);
	}

	@Override
	public boolean delete(int curso_a_eliminar) {
		return cdao.delete(curso_a_eliminar);
	}

	@Override
	public ArrayList<Curso> readall() {
		return cdao.readall();
	}

	@Override
	public ArrayList<Curso> readall(String consigna) {
		return cdao.readall(consigna);
	}

	@Override
	public boolean update(Curso curso_a_modificar) {
		return cdao.update(curso_a_modificar);
	}



	@Override
	public ArrayList<Curso> leer_ultimo_curso_id() {
		// TODO Auto-generated method stub
		return cdao.leer_ultimo_curso_id();
	}



}

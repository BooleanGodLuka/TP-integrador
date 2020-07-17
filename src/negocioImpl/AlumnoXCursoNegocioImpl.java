package negocioImpl;

import java.util.ArrayList;

import DaoImpl.AlumnoXCursoDaoImpl;
import dominio.AlumnoXCurso;
import negocio.AlumnoXCursoNegocio;

public class AlumnoXCursoNegocioImpl implements AlumnoXCursoNegocio {

	AlumnoXCursoDaoImpl aldao = new AlumnoXCursoDaoImpl();
	public AlumnoXCursoNegocioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean actualizar_alumnoXcurso(AlumnoXCurso alumno) {
		// TODO Auto-generated method stub
		return aldao.update(alumno);
	}

	@Override
	public int calcular_cant_alumnXcurso_aprob(int id) {
		// TODO Auto-generated method stub
		ArrayList<AlumnoXCurso> lista = new ArrayList<AlumnoXCurso>();
		lista = aldao.readall(id);
		int cont=0;
		AlumnoXCurso al = new AlumnoXCurso();
		for (int i=0;i<lista.size();i++) {
			al.igualar(lista.get(i));
			if (al.isAprobado()) {
				cont++;
			}
		}
		
		return cont;
	}

	@Override
	public int calcular_cant_alumnXcurso_desap(int id) {
		// TODO Auto-generated method stub
		ArrayList<AlumnoXCurso> lista = new ArrayList<AlumnoXCurso>();
		lista = aldao.readall(id);
		int cont=0;
		AlumnoXCurso al = new AlumnoXCurso();
		for (int i=0;i<lista.size();i++) {
			al.igualar(lista.get(i));
			if (!al.isAprobado()) {
				cont++;
			}
		}
		
		return cont;
	}

	@Override
	public int calcular_cant_alumnXcurso(int id) {
		// TODO Auto-generated method stub
		ArrayList<AlumnoXCurso> lista = new ArrayList<AlumnoXCurso>();
		lista = aldao.readall(id);
		int cont=0;
		
		for (int i=0;i<lista.size();i++) {
			cont++;
		
		}
		
		return cont;
	}

	@Override
	public boolean insert_alumnoXcurso(AlumnoXCurso alumno) {
		// TODO Auto-generated method stub
		return aldao.insert(alumno);
	}

	@Override
	public ArrayList<AlumnoXCurso> leer_alumnoXcurso(int id_curso) {
		// TODO Auto-generated method stub
		return aldao.readall(id_curso);
	}

}
 
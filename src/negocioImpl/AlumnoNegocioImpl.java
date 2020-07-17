package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.AlumnoDao;
import DaoImpl.AlumnoDaoImpl;
import dominio.Alumno;
import negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio {

	AlumnoDao dao = new AlumnoDaoImpl();

	public AlumnoNegocioImpl() {
	}

	@Override
	public boolean insert(Alumno alumno) {
		/* TODO validación insert alumno no compila
		 * boolean estado=false; if(alumno.getNombre().trim().length()>0 &&
		 * alumno.getApellido().trim().length()>0 && alumno.getDni().trim().length() >
		 * 0) { ArrayList<Alumno> personas =(ArrayList<Alumno>) aludao.readall(); if
		 * (!alumno.validar_exist(personas)) { estado=aludao.insert(alumno); }
		 * 
		 * }
		 */
		return dao.insert(alumno);
	}

	@Override
	public boolean delete(String id_alumno) {
		return dao.delete(id_alumno);
	}

	@Override
	public ArrayList<Alumno> readall() {
		return dao.readall();
	}


	@Override
	public boolean update(Alumno alumno_a_modificar) {
		return dao.update(alumno_a_modificar);
	}

	@Override
	public Alumno read(String idalumno) {
		// TODO Auto-generated method stub
		return dao.read(Integer.parseInt(idalumno));
	}

	@Override
	public ArrayList<Alumno> readall(String id_alumno) {
		// TODO Auto-generated method stub
		return dao.readall(id_alumno);
	}

}

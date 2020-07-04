package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import dominio.Alumno;
import negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio {

	
	public AlumnoNegocioImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean insert_alumno(Alumno alumno) {
		boolean estado=false;
		if(alumno.getNombre().trim().length()>0 && alumno.getApellido().trim().length()>0 && alumno.getDni().trim().length() > 0)
		{
			ArrayList<Alumno> personas =(ArrayList<Alumno>) usdao.leer_todo_alumno();
			if (!alumno.validar_exist(personas)) {
				estado=usdao.agregar_alumno(alumno);	
			}
			
		}
		return estado;
	}

	
	@Override
	public boolean delete_alumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Alumno> select_alumnos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Alumno> select_alummnos_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update_alumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

}



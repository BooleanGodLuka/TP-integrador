package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Alumno;
import dominio.Docente;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao usdao = new UsuarioDaoImpl();
	
	
	@Override
	public boolean agregar_alumno(Alumno alumno) {
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
	public boolean agregar_docente(Docente docente) {
		// TODO Auto-generated method stub
		boolean estado=false;
		if(docente.getNombre().trim().length()>0 && docente.getApellido().trim().length()>0 && docente.getDni().trim().length() > 0)
		{
			ArrayList<Docente> personas =(ArrayList<Docente>) usdao.leer_todo_docente();
			if (!docente.validar_exist(personas)) {
				estado=usdao.agregar_docente(docente);	
			}
			
		}
		return estado;
	}

	@Override
	public boolean borrar_alumno(Alumno alumno_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar_docente(Docente docente_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alumno> leer_todo_alumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> leer_todo_alummno_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> leer_todo_docente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> leer_todo_docente_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar_alumno(Alumno alumno_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar_docente(Docente docente_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

}

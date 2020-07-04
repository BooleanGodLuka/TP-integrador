package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Alumno;
import dominio.Docente;
import dominio.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao usdao = new UsuarioDaoImpl();
	
	@Override
	public boolean insert_usuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete_usuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update_clave(Usuario clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> readall_usuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> readall_usuarios_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}

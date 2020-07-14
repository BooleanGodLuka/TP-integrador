package negocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao usdao = new UsuarioDaoImpl();

	@Override
	public boolean insert(Usuario usuario) {
		return usdao.insert(usuario);
	}

	@Override
	public boolean delete(Usuario usuario) {
		return usdao.delete(usuario);
	}

	@Override
	public boolean updateClave(Usuario usuario) {
		return usdao.updateClave(usuario);
	}

	@Override
	public boolean validateUsuario(Usuario usuario) {
		return usdao.validateUsuario(usuario);
	}


	@Override
	public ArrayList<Usuario> readall() {
		return usdao.readall();
	}

	@Override
	public Usuario validateLogin(Usuario aux) {
		return usdao.validateLogin(aux);
	}

	@Override
	public String getNombreDocente(int iddocente) throws SQLException {
		return usdao.getNombreDocente(iddocente);
	}

	@Override
	public String getApellidoDocente(int iddocente) throws SQLException {
		return usdao.getApellidoDocente(iddocente);
	}
	
	

	
	
}

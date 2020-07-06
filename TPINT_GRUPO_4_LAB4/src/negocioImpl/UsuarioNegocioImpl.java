package negocioImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao usdao = new UsuarioDaoImpl();
	
	@Override
	public boolean insert_usuario(Usuario usuario) {
		usdao.insert_usuario(usuario);
		return false;
	}

	@Override
	public boolean delete_usuario(Usuario usuario) {
		usdao.delete_usuario(usuario);
		return false;
	}

	@Override
	public boolean update_clave(String clave) {
		usdao.update_clave(clave);
		return false;
	}

	@Override
	public List<Usuario> readall_usuarios() {
		usdao.readall_usuarios();
		return null;
	}

	@Override
	public List<Usuario> readall_usuarios_consigna(String consigna) {
		usdao.readall_usuarios_consigna(consigna);
		return null;
	}


	@Override
	public Usuario get_usuario(Usuario usuario){
		Usuario User = usdao.get_usuario(usuario);
		return User;
	}

	@Override
	public boolean validate_usuario(String nombreusuario, String claveusuario) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

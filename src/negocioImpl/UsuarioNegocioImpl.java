package negocioImpl;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao usdao = new UsuarioDaoImpl();
	
	@Override
	public boolean insert_usuario(Usuario usuario) {
		return usdao.insert(usuario);
	}

	@Override
	public boolean delete_usuario(Usuario usuario) {
		return usdao.delete(usuario);
	}

	@Override
	public boolean update_clave(String nombreusuario, String claveusuario) {
		boolean estado = false;
		estado = usdao.updateClave(nombreusuario, claveusuario);
		return estado;
	}	

	@Override
	public Usuario validate_usuario(String nombreusuario, String claveusuario) {
		return usdao.validateUsuario(nombreusuario, claveusuario);
	}
	
}

package Dao;

import dominio.Usuario;

public interface UsuarioDao {

	public boolean insert(Usuario nombreusuario);
	
	public boolean delete(Usuario nombreusuario);
	
	public boolean updateClave (String nombreusuario, String claveusuario);
	
	public Usuario validateUsuario(String nombreusuario, String claveusuario);
	
}

package Dao;

import dominio.Usuario;

public interface UsuarioDao {

	public boolean insert_usuario(Usuario nombreusuario);
	
	public boolean delete_usuario(Usuario nombreusuario);
	
	public boolean update_clave (String nombreusuario, String claveusuario);
	
	public Usuario validate_usuario(String nombreusuario, String claveusuario);
	
}

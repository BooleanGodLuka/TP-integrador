package negocio;

import dominio.Usuario;

public interface UsuarioNegocio {

	public boolean insert_usuario(Usuario usuario);
	
	public boolean delete_usuario(Usuario usuario);
	
	public boolean update_clave(String nombreusuario, String claveusuario);
	
	public Usuario validate_usuario(String nombreusuario, String claveusuario);
}

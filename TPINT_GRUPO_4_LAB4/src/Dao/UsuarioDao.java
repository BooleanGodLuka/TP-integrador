package Dao;

import java.util.List;

import dominio.Alumno;
import dominio.Docente;
import dominio.Usuario;


public interface UsuarioDao {

	public boolean insert_usuario(Usuario usuario);
	
	public boolean delete_usuario(Usuario usuario);
	
	public boolean update_clave (String clave);
	
	public List<Usuario> readall_usuarios();
	
	public List<Usuario> readall_usuarios_consigna(String consigna);

	public Usuario get_usuario(String nusuario, String clave);
	
}

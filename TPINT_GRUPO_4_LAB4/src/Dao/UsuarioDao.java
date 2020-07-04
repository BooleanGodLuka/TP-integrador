package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import dominio.Usuario;


public interface UsuarioDao {

	public boolean insert_usuario(Usuario usuario);
	
	public boolean delete_usuario(Usuario usuario);
	
	public boolean update_clave (String clave);
	
	public List<Usuario> readall_usuarios();
	
	public List<Usuario> readall_usuarios_consigna(String consigna);

	public Usuario get_usuario(ResultSet resultset) throws SQLException;
	
}

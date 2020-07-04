package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dominio.Alumno;
import dominio.Docente;
import dominio.Usuario;

public interface UsuarioNegocio {

	public boolean insert_usuario(Usuario usuario);
	
	public boolean delete_usuario(Usuario usuario);
	
	public boolean update_clave (Usuario clave);
	
	public List<Usuario> readall_usuarios();
	
	public List<Usuario> readall_usuarios_consigna(String consigna);

	Usuario get_usuario(ResultSet resultset) throws SQLException;
}

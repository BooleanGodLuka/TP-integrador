package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import dominio.Usuario;

public interface UsuarioDao {

	public boolean insert(Usuario usuario);
	
	public boolean delete(Usuario usuario);
	
	public boolean updateClave (Usuario usuario);
	
	public boolean validateUsuario(Usuario usuario);
	
	public ArrayList<Usuario> readall();

	public Usuario validateLogin(Usuario aux);
	
	public String getNombreDocente (int iddocente) throws SQLException;
	
	public String getApellidoDocente (int iddocente) throws SQLException;
	
}

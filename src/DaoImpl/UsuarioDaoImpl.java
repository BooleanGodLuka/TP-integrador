package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.UsuarioDao;
import DaoImpl.Conexion;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_grupo4_labo4";
	public static final String validate = "SELECT usuario, clave FROM usuarios";
	public static final String update = "UPDATE usuarios SET password_user = ? WHERE usuario_user = ?;";


	@Override
	public boolean insert_usuario(Usuario usuario) {
		
		String query = "INSERT INTO usuarios(idusuario,usuario,clave) VALUES ('"+usuario.getIdusuario()+"','"+usuario.getUsuario()+"','"+usuario.getClave()+"')";
		Connection cn = null;
		
		int filas=0;
		
		try
		
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
		if (filas==0) {
		
			return false;
			
		}
		
		else {
			
		return true;
		
		}
		
	}

	@Override
	public boolean delete_usuario(Usuario usuario) {
		
		String query = "DELETE FROM usuarios (idusuario,usuario,clave) VALUES ('"+usuario.getIdusuario()+"','"+usuario.getUsuario()+"','"+usuario.getClave()+"')";
		Connection cn = null;
		
		int filas=0;
		
		try
		
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
		if (filas==0) {
			
			return false;
		}
		
		else {
			
			return true;
			
		}
		
	}
	

	@Override
	public boolean update_clave(String nombreusuario, String claveusuario) {
		
		PreparedStatement statement;
		boolean estado = false;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, pass);
			statement.setString(2, user);
			
			if(statement.executeUpdate() > 0)
			{			
				estado = true;
			}
			
		} 
		
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		return estado;
	}
	
	


	public Usuario get_usuario(ResultSet resultSet) throws SQLException {
		
		String idusuario = resultSet.getString("idusuario");
		String iddocente = resultSet.getString("iddocente");
		String nusuario = resultSet.getString("usuario");
		String claveu = resultSet.getString("clave");
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(idusuario);
		usuario.setIddocente(iddocente);
		usuario.setClave(claveu);
		usuario.setUsuario(nusuario);
		
		return usuario;
		
	}
	
	@Override
	public Usuario validate_usuario(String nombreusuario, String claveusuario) {
		
		PreparedStatement statement;
		ResultSet resultSet;
		
		Usuario obj = new Usuario();
		
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(validate);
			statement.setString(1, nombreusuario);
			statement.setString(2, claveusuario);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{			
				obj = get_usuario(resultSet);
			}
			
		} 
		
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		return obj;
		
	}

	
	
}

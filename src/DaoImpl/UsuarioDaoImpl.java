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
	public static final String validate = "SELECT * FROM usuarios WHERE usuario = ? AND clave= ?;";
	public static final String update = "UPDATE usuarios SET clave = ? WHERE usuario = ?;";


	@Override
	public boolean insert(Usuario usuario) {
		
		String query = "INSERT INTO usuarios(idusuario,iddocente,usuario,clave,estado) VALUES ('"+usuario.getIdusuario()+"','"+usuario.getIddocente()+"','"+usuario.getUsuario()+"','"+usuario.getClave()+"','true')";
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
	public boolean delete(Usuario usuario) {
		
		String query = "UPDATE FROM usuarios (estado) VALUES ('false')";
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
	public boolean updateClave(String nombreusuario, String claveusuario) {
		
		PreparedStatement statement;
		boolean estado = false;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, nombreusuario);
			statement.setString(2, claveusuario);
			
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
		
		usuario.setIdusuario(Integer.parseInt(idusuario));
		usuario.setIddocente(Integer.parseInt(iddocente));
		usuario.setClave(claveu);
		usuario.setUsuario(nusuario);
		
		return usuario;
		
	}
	
	@Override
	public Usuario validateUsuario(String nombreusuario, String claveusuario) {
		
		PreparedStatement statement;
		ResultSet resultSet;
		
		Usuario usu = new Usuario();
		
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(validate);
			statement.setString(1, nombreusuario);
			statement.setString(2, claveusuario);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{			
				usu = get_usuario(resultSet);
			}
			
		} 
		
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		return usu;
		
	}

	
	
}

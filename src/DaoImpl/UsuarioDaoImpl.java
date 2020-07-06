package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Dao.UsuarioDao;
import dominio.Alumno;
import dominio.Docente;
import dominio.Provincia;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_grupo4_labo4";


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
	public boolean update_clave(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> readall_usuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> readall_usuarios_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario get_usuario(Usuario usuario) {
		String idusuario = usuario.getIdusuario();
		String nusuario = usuario.getUsuario();
		String claveu = usuario.getClave();
		return new Usuario (idusuario, nusuario, claveu);
		
	}
	
	@Override
	public boolean validate_usuario(String nombreusuario, String claveusuario) {
		
		String usuario = nombreusuario;
		String clave = claveusuario;
		
		Statement statement;
		ResultSet resultset = null;
		
		String usuarioDB = "";
		String claveDB = "";
		
		try {
			
		Connection conexion = Conexion.getConexion().getSQLConexion();
		statement = conexion.createStatement();
		resultset = statement.executeQuery("SELECT usuario, clave FROM usuarios");
		
		while (resultset.next()==true) {
			usuarioDB = resultset.getString("usuario");
			claveDB = resultset.getString("clave");	
			if (usuario.equals(usuarioDB) && clave.equals(claveDB)) {
				return true;
			}
		}
		
		}
	
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		return false;
		
	}

	
	
}

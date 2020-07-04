package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import Dao.UsuarioDao;
import dominio.Alumno;
import dominio.Docente;
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
	
	/*aca hay un flashing*/
	
	public Usuario get_usuario(String usuario, String clave) {
		
		String query = "SELECT * FROM usuarios WHERE (usuario,clave) VALUES ('"+usuario+"','"+clave+"')";
		Connection cn = null;
		
		Usuario usu = new Usuario();
		
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
		
		finally {
			if (filas!=0) {
				
				return usu;
			}
		}
		return usu;	
		
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

	
	

	
	
}

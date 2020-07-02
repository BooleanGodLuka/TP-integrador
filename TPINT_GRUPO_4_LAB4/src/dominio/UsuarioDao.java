package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import dominio.Alumno;
import dominio.Docente;

public class UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_grupo4_labo4";

	
	public int agregarAlumno(Alumno alumno)
	{
		String query = "Insert into alumnos(id,dni,nombre,apellido,fechanacimiento,email, direccion, idlocalidad, telefono) values ('"+alumno.getId()+"','"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getFechanacimiento()+"','"+alumno.getEmail()+"','"+alumno.getDireccion()+"','"+alumno.getIdlocalidad()+"','"+alumno.getTelefono()+"')";
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
		return filas;
		
	}
	
	public int agregarDocente(Docente docente)
	{
		String query = "Insert into docentes(id,dni,nombre,apellido,fechanacimiento,email, direccion, idlocalidad) values ('"+docente.getId()+"','"+docente.getDni()+"','"+docente.getNombre()+"','"+docente.getApellido()+"','"+docente.getFechanacimiento()+"','"+docente.getEmail()+"','"+docente.getDireccion()+"','"+docente.getIdlocalidad()+"'')";
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
		return filas;
		
	}

	
	/*
	public void ejecutarSPCrearUsuario(Usuario usuario)
	{
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL crearUsuario(?,?)");
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	*/
	
}

package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

<<<<<<< HEAD

public class Conexion {
	private Connection conexion;
	private static Conexion estancia;
	
	
=======
public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_grupo4_labo4";
>>>>>>> d3799a027358c5019c89bb2721b246e5f0a2b835
	
	private Conexion()
	{
		try
		{
<<<<<<< HEAD
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_grupo4_labo4","root","root");
			this.conexion.setAutoCommit(false);
=======
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName,user,pass);
			this.connection.setAutoCommit(false);
>>>>>>> d3799a027358c5019c89bb2721b246e5f0a2b835
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
<<<<<<< HEAD
		if(estancia == null)
		{
			estancia = new Conexion();
		}
		return estancia;
=======
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
>>>>>>> d3799a027358c5019c89bb2721b246e5f0a2b835
	}
	
	public void cerrarConexion()
	{
		try 
		{
<<<<<<< HEAD
			this.conexion.close();
=======
			this.connection.close();
>>>>>>> d3799a027358c5019c89bb2721b246e5f0a2b835
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
<<<<<<< HEAD
		estancia = null;
	}


	public void setSQLConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	public Connection getSQLConexion() 
	{
		return this.conexion;
	} 
	
	
	
}

=======
		instancia = null;
	}
}
>>>>>>> d3799a027358c5019c89bb2721b246e5f0a2b835

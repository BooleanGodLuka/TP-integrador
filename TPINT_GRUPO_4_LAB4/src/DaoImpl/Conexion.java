package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	private Connection conexion;
	private static Conexion estancia;
	
	
	
	private Conexion()
	{
		try
		{
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_grupo4_labo4","root","root");
			this.conexion.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(estancia == null)
		{
			estancia = new Conexion();
		}
		return estancia;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.conexion.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
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


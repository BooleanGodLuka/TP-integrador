package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import Dao.UsuarioDao;
import dominio.Alumno;
import dominio.Docente;

public class UsuarioDaoImpl implements UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "db_grupo4_labo4";

	
	@Override
	public boolean agregar_alumno(Alumno alumno) {
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
		
		if (filas==0) {
		
			return false;
		}else {
			return true;
		}
		
		
	}
	
	@Override
	public boolean agregar_docente(Docente docente) {
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
		
		if (filas==0) {
			
			return false;
		}else {
			return true;
		}
		
	}

	
	


	@Override
	public boolean borrar_alumno(Alumno alumno_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar_docente(Docente docente_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alumno> leer_todo_alumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> leer_todo_alummno_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> leer_todo_docente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> leer_todo_docente_consigna(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar_alumno(Alumno alumno_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar_docente(Docente docente_a_modificar) {
		// TODO Auto-generated method stub
		return false;
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

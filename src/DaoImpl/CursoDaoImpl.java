package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CursoDao;
import dominio.Curso;
import dominio.alumnoXcurso;

public class CursoDaoImpl implements CursoDao {

	private static final String insert = "INSERT INTO cursos(id, cuatrimestre, año,iddocente,idmateria) VALUES(?, ?, ?, ?, ?)";
	private static final String leer_todo = "SELECT * FROM cursos ";
	private static final String update = "UPDATE cursos SET cuatrimestre= ?, año= ?,iddocente= ? where id=?";
	private static final String delete = "DELETE FROM cursos WHERE id = ?";
	private static final String leer_alumnosXcurso = "Select * from alumnos_x_cursos ";
	
	
	
	@Override
	public boolean agregar_curso(Curso curso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean validar = false;
		
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, String.valueOf(curso.getId()));
			statement.setString(2, curso.getCuatrimestre());
			statement.setString(3, curso.getAño());
			statement.setString(4, String.valueOf(curso.getId_docente()) );
			statement.setString(5, String.valueOf(curso.getId_materia()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				validar = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return validar;
	}
	
	
	
	@Override
	public boolean borrar_curso(Curso curso_a_borrar) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	@Override
	public ArrayList<Curso> leer_todo_curso() {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(leer_todo);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Curso cur = new Curso();
				
				cur.setAño(getCurso(resultSet).getAño());
				cur.setCuatrimestre(getCurso(resultSet).getCuatrimestre());
				cur.setId(getCurso(resultSet).getId());
				cur.setId_docente(getCurso(resultSet).getId_docente());
				cur.setId_materia(getCurso(resultSet).getId_materia());
				
				
				cursos.add(cur);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cursos;
	}
	
	private Curso getCurso(ResultSet resultSet) throws SQLException
	{
		int id = Integer.parseInt(resultSet.getString("id"))  ;
		String cuatri = resultSet.getString("cuatrimestre");
		String año = resultSet.getString("año");
		int id_docente = Integer.parseInt(resultSet.getString("iddocente"))  ;
		int id_materia = Integer.parseInt(resultSet.getString("idmateria"))  ;
		

		return new Curso(id, cuatri, año, id_docente, id_materia); 
	}
	
	
	
	@Override
	public ArrayList<Curso> leer_todo_curso_consigna(String consigna) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(leer_todo + "WHERE " + consigna);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Curso cur = new Curso();
				
				cur.setAño(getCurso(resultSet).getAño());
				cur.setCuatrimestre(getCurso(resultSet).getCuatrimestre());
				cur.setId(getCurso(resultSet).getId());
				cur.setId_docente(getCurso(resultSet).getId_docente());
				cur.setId_materia(getCurso(resultSet).getId_materia());
				
				
				cursos.add(cur);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cursos;
	}
	
	
	
	@Override
	public boolean actualizar_curso(Curso curso_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList<alumnoXcurso> leer_alumnoXcurso(String id_curso) {
		// TODO Auto-generated method stub
				PreparedStatement statement;
				ResultSet resultSet; //Guarda el resultado de la query
				ArrayList<alumnoXcurso> alumnos = new ArrayList<alumnoXcurso>();
				Conexion conexion = Conexion.getConexion();
				
				try 
				{
					statement = conexion.getSQLConexion().prepareStatement(leer_alumnosXcurso + "WHERE idcurso=" + id_curso);
					resultSet = statement.executeQuery();
					while(resultSet.next())
					{
						alumnoXcurso cur = new alumnoXcurso();
						
						cur.setId_alumno(getCurso_alumnos(resultSet).getId_alumno());
						cur.setId_curso(getCurso_alumnos(resultSet).getId_curso());
						cur.setNota1(getCurso_alumnos(resultSet).getNota1());
						cur.setNota2(getCurso_alumnos(resultSet).getNota2());
						cur.setNota3(getCurso_alumnos(resultSet).getNota3());
						cur.setNota4(getCurso_alumnos(resultSet).getNota4());
						
						
						
						alumnos.add(cur);
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return alumnos;
	}
	
	
	private alumnoXcurso getCurso_alumnos(ResultSet resultSet) throws SQLException
	{
		int id_alumno = Integer.parseInt(resultSet.getString("idalumno"));
		int id_curso = Integer.parseInt(resultSet.getString("idcurso"));
		int nota1 = Integer.parseInt(resultSet.getString("nota1"));
		int nota2 = Integer.parseInt(resultSet.getString("nota2"));
		int nota3 = Integer.parseInt(resultSet.getString("nota3"));
		int nota4 = Integer.parseInt(resultSet.getString("nota4"));
		

		return new alumnoXcurso(id_alumno, id_curso, nota1, nota2, nota3, nota4); 
	}


}

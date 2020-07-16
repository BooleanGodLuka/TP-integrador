package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.CursoDao;
import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Materia;
import dominio.AlumnoXCurso;

public class CursoDaoImpl implements CursoDao {

	private static final String insert = "INSERT INTO cursos (cuatrimestre, anio, iddocente, idmateria, activo) VALUES(?, ?, ?, ?, true)";
	private static final String readall = "SELECT * FROM cursos ";
	private static final String delete = "UPDATE cursos SET activo = false WHERE id = ? ";
	private static final String update = "UPDATE cursos SET materia= ?, cuatrimestre = ?, anio = ?, iddocente = ? WHERE id = ? ";

	@Override
	public boolean insert(Curso curso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean validar = false;

		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, curso.getCuatrimestre());
			statement.setString(2, curso.getAnio());
			statement.setInt(3, curso.getDocente().getLegajo());
			statement.setInt(4, curso.getMateria().getID());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				validar = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return validar;
	}

	public CursoDaoImpl() {

	}

	@Override
	public boolean delete(int id) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, id);

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}

	@Override
	public ArrayList<Curso> readall() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			Curso curso = null;
			while (resultSet.next()) {
				curso = new Curso();

				cargarCurso(curso, resultSet);

				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public Curso read(int idcurso) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + "WHERE id = " + idcurso);
			resultSet = statement.executeQuery();
			Curso curso = new Curso();
			if (resultSet != null) {
				
				cargarCurso(curso, resultSet);
				return curso;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void cargarCurso(Curso curso, ResultSet resultSet) throws SQLException {
		curso.setID(resultSet.getInt("id"));
		curso.getMateria().setID(resultSet.getInt("idmateria"));
		curso.setCuatrimestre(resultSet.getString("cuatrimestre"));
		curso.setAnio(resultSet.getString("anio"));
		curso.getDocente().setLegajo(resultSet.getInt("iddocente"));

	}

	@Override
	public boolean update(Curso curso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, curso.getMateria().getID());
			statement.setString(2, curso.getCuatrimestre());
			statement.setString(3, curso.getAnio());
			statement.setInt(4, curso.getDocente().getLegajo());
			statement.setInt(5, curso.getID());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}

	@Override
	public ArrayList<Curso> readall(String consigna) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + " WHERE " + consigna);
			resultSet = statement.executeQuery();
			Curso curso = null;
			while (resultSet.next()) {
				curso = new Curso();

				cargarCurso(curso, resultSet);

				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public ArrayList<Curso> leer_ultimo_curso_id() {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM cursos ORDER BY id DESC LIMIT 0, 1");
			resultSet = statement.executeQuery();
			Curso curso = null;
			while (resultSet.next()) {
				curso = new Curso();

				cargarCurso(curso, resultSet);

				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

}

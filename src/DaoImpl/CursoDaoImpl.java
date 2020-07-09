package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.CursoDao;
import dominio.Curso;
import dominio.Docente;
import dominio.Materia;
import dominio.alumnoXcurso;

public class CursoDaoImpl implements CursoDao {

	private static final String insert = "INSERT INTO cursos (cuatrimestre, año, iddocente, idmateria) VALUES(?, ?, ?, ?)";
	private static final String leer_todo = "SELECT * FROM cursos ";
	private static final String delete = "UPDATE cursos SET activo = false WHERE id = ?";
	private static final String update = "UPDATE cursos SET cuatrimestre = ?, año = ?,iddocente = ? WHERE id = ?";
	private static final String leer_alumnosXcurso = "Select * from alumnos_x_cursos ";
	private static final String update_alumnoXcurso = "UPDATE alumnos_x_cursos SET nota1= ?, nota2= ?, nota3= ?, nota4= ?, regularidad =? WHERE idalumno= ? AND idcurso= ?";
	private static final String leer_mat = "SELECT * FROM materias";

	@Override
	public boolean insert(Curso curso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean validar = false;

		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, curso.getCuatrimestre());
			statement.setInt(2, curso.getAnio());
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
	public boolean delete(Curso curso_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, curso_a_eliminar.getID());
			statement.setInt(2, curso_a_eliminar.getCuatrimestre());
			statement.setInt(2, curso_a_eliminar.getAnio());
			statement.setInt(2, curso_a_eliminar.getDocente().getLegajo());
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
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(leer_todo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Curso cur = new Curso();

				cargarCurso(resultSet);

				cursos.add(cur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public ArrayList<Curso> readall(String consigna) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(leer_todo + "WHERE " + consigna);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Curso cur = new Curso();

				cargarCurso(resultSet);

				cursos.add(cur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	private Curso cargarCurso(ResultSet resultSet) throws SQLException {
		Materia materia = new Materia();
		Docente docente = new Docente();
		
		int id = Integer.parseInt(resultSet.getString("id"));
		materia.setID(Integer.parseInt(resultSet.getString("idmateria")));
		int cuatrimestre = resultSet.getInt("cuatrimestre");
		int año = resultSet.getInt("anio");
		docente.setLegajo(Integer.parseInt(resultSet.getString("iddocente")));

		return new Curso(id, materia, cuatrimestre, año, docente);
	}

	@Override
	public boolean update(Curso curso_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, curso_a_modificar.getID());
			statement.setInt(2, curso_a_modificar.getCuatrimestre());
			statement.setInt(2, curso_a_modificar.getAnio());
			statement.setInt(2, curso_a_modificar.getDocente().getLegajo());
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
	public ArrayList<alumnoXcurso> leer_alumnoXcurso(String id_curso) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<alumnoXcurso> alumnos = new ArrayList<alumnoXcurso>();
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(leer_alumnosXcurso + "WHERE idcurso=" + id_curso);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				alumnoXcurso axc = new alumnoXcurso();

				axc = cargarAlumnosXCurso(resultSet);

				alumnos.add(axc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	private alumnoXcurso cargarAlumnosXCurso(ResultSet resultSet) throws SQLException {
		int id_alumno = Integer.parseInt(resultSet.getString("idalumno"));
		int id_curso = Integer.parseInt(resultSet.getString("idcurso"));
		int nota1 = Integer.parseInt(resultSet.getString("nota1"));
		int nota2 = Integer.parseInt(resultSet.getString("nota2"));
		int nota3 = Integer.parseInt(resultSet.getString("nota3"));
		int nota4 = Integer.parseInt(resultSet.getString("nota4"));
		String nombre = resultSet.getString("nombre_alumno");
		String apellido = resultSet.getString("apellido_alumno");
		String regular = resultSet.getString("regularidad");

		return new alumnoXcurso(id_alumno, id_curso, nota1, nota2, nota3, nota4, nombre, apellido, regular);
	}

	@Override
	public boolean actualizar_alumnoXcurso(alumnoXcurso axc) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update_alumnoXcurso);
			statement.setInt(1, axc.getNota1());
			statement.setInt(2, axc.getNota2());
			statement.setInt(3, axc.getNota3());
			statement.setInt(4, axc.getNota4());
			statement.setString(5, axc.getRegularidad());
			statement.setInt(6, axc.getAlumno().getLegajo());
			statement.setInt(7, axc.getCurso().getID());

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
	public String leer_materia(String id) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		String materia = "";
		try {
			statement = conexion.getSQLConexion().prepareStatement(leer_mat + " WHERE id=" + id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				materia = resultSet.getString("nombre");
 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materia;
	}

}

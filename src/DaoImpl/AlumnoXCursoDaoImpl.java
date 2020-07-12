package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.AlumnoDao;
import Dao.AlumnoXCursoDao;
import Dao.CursoDao;
import dominio.AlumnoXCurso;
import dominio.Curso;

public class AlumnoXCursoDaoImpl implements AlumnoXCursoDao {

	private static final String insert = "INSERT INTO alumnosXcursos (idalumno, idcurso, nota1, nota2, nota3, nota4, aprobado, regularidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE alumnosXcursos SET activo = false WHERE idalumno= ? AND idcurso= ?";
	private static final String readall = "Select * from alumnosXcursos ";
	private static final String update = "UPDATE alumnosXcursos SET nota1 = ?, nota2 = ?, nota3 = ?, nota4 = ?, regularidad = ? WHERE idalumno = ? AND idcurso = ? ";
	private static final String readallmaterias = "SELECT * FROM materias";

	AlumnoDao alumnoDao = new AlumnoDaoImpl();
	CursoDao cursoDao = new CursoDaoImpl();

	@Override
	public boolean insert(AlumnoXCurso alumXcurso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean validar = false;

		try {
			statement = conexion.prepareStatement(insert);

			statement.setInt(1, alumXcurso.getAlumno().getLegajo());
			statement.setInt(2, alumXcurso.getCurso().getID());
			statement.setInt(3, alumXcurso.getNota1());
			statement.setInt(4, alumXcurso.getNota2());
			statement.setInt(5, alumXcurso.getNota3());
			statement.setInt(6, alumXcurso.getNota4());
			statement.setBoolean(7, false);
			statement.setString(8, alumXcurso.getAlumno().getNombre());
			statement.setString(9, alumXcurso.getAlumno().getApellido());
			statement.setString(10, alumXcurso.getRegularidad());

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

	@Override
	public ArrayList<AlumnoXCurso> readall(int idcurso) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<AlumnoXCurso> listaAlumnosXCurso = new ArrayList<AlumnoXCurso>();
		Conexion conexion = Conexion.getConexion();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + "WHERE idcurso = " + idcurso);
			resultSet = statement.executeQuery();
			AlumnoXCurso alumXcurso = null;
			while (resultSet.next()) {
				alumXcurso = new AlumnoXCurso();
				cargarAlumnosXCurso(alumXcurso, resultSet);

				listaAlumnosXCurso.add(alumXcurso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnosXCurso;
	}

	private void cargarAlumnosXCurso(AlumnoXCurso alumXcurso, ResultSet resultSet) throws SQLException {

		alumXcurso.getAlumno().setLegajo(resultSet.getInt("idalumno"));
		alumnoDao.read(alumXcurso.getAlumno().getLegajo());

		alumXcurso.getCurso().setID(resultSet.getInt("idcurso"));
		alumnoDao.read(alumXcurso.getCurso().getID());

		alumXcurso.setNota1(resultSet.getInt("nota1"));
		alumXcurso.setNota2(resultSet.getInt("nota2"));
		alumXcurso.setNota3(resultSet.getInt("nota3"));
		alumXcurso.setNota4(resultSet.getInt("nota4"));
		alumXcurso.setRegularidad(resultSet.getString("regularidad"));
	} 

	@Override
	public boolean update(AlumnoXCurso alumXcurso) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, alumXcurso.getNota1());
			statement.setInt(2, alumXcurso.getNota2());
			statement.setInt(3, alumXcurso.getNota3());
			statement.setInt(4, alumXcurso.getNota4());
			statement.setString(5, alumXcurso.getRegularidad());
			statement.setInt(6, alumXcurso.getAlumno().getLegajo());
			statement.setInt(7, alumXcurso.getCurso().getID());

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
	public String leer_ultimo_curso_id() {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		String id = "";
		try {
			statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(id) FROM cursos;");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getString("id");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
 


}

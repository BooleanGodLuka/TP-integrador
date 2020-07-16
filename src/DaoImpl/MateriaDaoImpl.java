package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.MateriaDao;
import dominio.Materia;

public class MateriaDaoImpl implements MateriaDao {

	private static final String insert = "INSERT INTO materias (nombre) VALUES (?) ";
	private static final String delete = "DELETE FROM materias WHERE id = ? ";
	private static final String readall = "SELECT * FROM materias ";
	private static final String update = "UPDATE materias (nombre) VALUES (?) WHERE id = ?";

	@Override
	public boolean insert(Materia materia) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, materia.getNombre());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			((Conexion) conexion).cerrarConexion();
		}

		return isInsertExitoso;
	}

	@Override
	public boolean delete(Materia materia_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(materia_a_eliminar.getID()));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleteExitoso;
	}

	@Override
	public ArrayList<Materia> readall() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Materia> materias = new ArrayList<Materia>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			Materia mat;
			while (resultSet.next()) {
				mat = new Materia();
				getMateria(mat, resultSet);
				materias.add(mat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materias;
	}

	@Override
	public String getNombreMateria(int idmateria) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT nombre FROM materias WHERE id = "
				+ idmateria;
		String nombre = "";
		Statement statement = conexion.getSQLConexion().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		try {
			while (resultSet.next()) {
				nombre = resultSet.getString("nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	@Override
	public boolean update(Materia materia_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, materia_a_modificar.getNombre());
			statement.setInt(2, materia_a_modificar.getID());
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

	private void getMateria(Materia materia, ResultSet resultSet) throws SQLException {
		materia.setID(resultSet.getInt("id"));
		materia.setNombre(resultSet.getString("nombre"));
	}

}

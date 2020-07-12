package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.LocalidadDao;
import dominio.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {

	private static final String insert = "INSERT INTO localidades (nombre, idprovincia) VALUES (?, ?) ";
	private static final String delete = "DELETE FROM localidades WHERE id = ? ";
	private static final String readall = "SELECT * FROM localidades ";
	private static final String readallwhere = "SELECT * FROM localidades WHERE idprovincia = ?";
	private static final String update = "UPDATE localidades (nombre, idprovincia) VALUES (?, ?) WHERE id = ?";

	@Override
	public boolean insert(Localidad localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, localidad.getNombre());
			statement.setInt(2, localidad.getIDProvincia());
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
	public boolean delete(Localidad localidad_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getID()));
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
	public ArrayList<Localidad> readall() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				localidades.add(getLocalidad(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidades;
	}

	@Override
	public ArrayList<Localidad> readall(String idprovincia) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallwhere);
			statement.setString(1, idprovincia);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				localidades.add(getLocalidad(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidades;
	}

	@Override
	public boolean update(Localidad localidad_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, localidad_a_modificar.getNombre());
			statement.setInt(2, localidad_a_modificar.getIDProvincia());
			statement.setInt(3, localidad_a_modificar.getID());
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

	private Localidad getLocalidad(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		int idprovincia = resultSet.getInt("idprovincia");
		return new Localidad(id, nombre, idprovincia);
	}

}

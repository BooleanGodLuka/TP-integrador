package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.LocalidadDao;
import dominio.Localidad;
import dominio.Provincia;

public class LocalidadDaoImpl implements LocalidadDao {

	private static final String insert = "INSERT INTO localidades (ID, nombre, IDProvincia) VALUES (?, ?, ?)";
	private static final String delete = "DELETE FROM localidades WHERE id = ?";
	private static final String readall = "SELECT * FROM localidades";
	private static final String readallwhere = "SELECT * FROM localidades WHERE idprovincia = ?";
	private static final String update = "UPDATE localidades (id, nombre, idprovincia) VALUES (?, ?, ?) WHERE id = ?";

	@Override
	public boolean insert(Localidad localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, localidad.getID());
			statement.setString(2, localidad.getNombre());
			statement.setInt(3, localidad.getIDProvincia());
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
		}

		return isInsertExitoso;
	}

	@Override
	public boolean delete(Localidad localidad_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getID()));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public List<Localidad> readall() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
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
	public List<Localidad> readall(Provincia provincia_seleccionada) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallwhere);
			statement.setString(1, Integer.toString(provincia_seleccionada.getID()));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				localidades.add(getLocalidad(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidades;
	}

	private Localidad getLocalidad(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		int idprovincia = resultSet.getInt("idprovincia");
		return new Localidad(id, nombre, idprovincia);
	}

	@Override
	public boolean update(Localidad localidad_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, localidad_a_modificar.getID());
			statement.setString(2, localidad_a_modificar.getNombre());
			statement.setInt(3, localidad_a_modificar.getIDProvincia());
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
		}

		return isInsertExitoso;
	}

}

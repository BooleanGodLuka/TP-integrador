package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dao.ProvinciaDao;
import dominio.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	private static final String insert = "INSERT INTO provincias (ID, nombre) VALUES (?, ?)";
	private static final String delete = "DELETE FROM provincias WHERE id = ?";
	private static final String readall = "SELECT * FROM provincias";
	private static final String update = "UPDATE provincias (id, nombre) VALUES (?, ?) WHERE id = ?";

	@Override
	public boolean insert(Provincia provincia) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, provincia.getID());
			statement.setString(2, provincia.getNombre());
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
	public boolean delete(Provincia provincia_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(provincia_a_eliminar.getID()));
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
	public ArrayList<Provincia> readall() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				provincias.add(getProvincia(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincias;
	}

	private Provincia getProvincia(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String nombre = resultSet.getString("nombre");
		return new Provincia(id, nombre);
	}

	@Override
	public boolean update(Provincia provincia_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, provincia_a_modificar.getID());
			statement.setString(2, provincia_a_modificar.getNombre());
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
	public ArrayList<Provincia> readall(String consigna) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombreProvincia(String idlocalidad) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT provincias.nombre FROM provincias INNER JOIN localidades ON provincias.id = localidades.idprovincia WHERE localidades.id = "
				+ idlocalidad;
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
	
}

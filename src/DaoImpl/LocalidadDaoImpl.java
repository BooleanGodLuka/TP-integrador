package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dao.LocalidadDao;
import dominio.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {

	private static final String readallwhere = "SELECT * FROM localidades INNER JOIN provincias ON localidades.idprovincia = provincias.id WHERE provincias.id = ? ";
	private static final String readall = "SELECT * FROM localidades";

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
	public ArrayList<Localidad> readall() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readallwhere);
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
	public String getNombreLocalidad(String idlocalidad) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT nombre FROM localidades WHERE id = "
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

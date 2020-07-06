package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DocenteDao;
import dominio.Docente;

public class DocenteDaoImpl implements DocenteDao {

	private static final String insert = "INSERT INTO docentes (dni, nombre, apellido, fechanacimiento, email, direccion, idlocalidad, activo) VALUES (?, ?, ?, ?, ?, ?, ?, true) ";
	private static final String delete = "DELETE FROM alumnos WHERE id = ? ";
	private static final String readall = "SELECT * FROM docentes ";
	private static final String update = "UPDATE docentes (dni, nombre, apellido, fechanacimiento, email, direccion, idlocalidad, activo) VALUES (?, ?, ?, ?, ?, ?, ?, activo) WHERE id = ? ";

	@Override
	public boolean insert(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, docente.getDni());
			statement.setString(2, docente.getNombre());
			statement.setString(3, docente.getApellido());
			statement.setString(4, docente.getFechaNacimiento());
			statement.setString(5, docente.getEmail());
			statement.setString(6, docente.getDireccion());
			statement.setString(7, docente.getIDLocalidad());
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
	public boolean delete(Docente docente_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(docente_a_eliminar.getLegajo()));
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
	public List<Docente> readall() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Docente> lista = new ArrayList<Docente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(getDocente(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Docente> readall(String consigna) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Docente> lista = new ArrayList<Docente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + consigna);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(getDocente(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public boolean update(Docente docente_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, docente_a_modificar.getDni());
			statement.setString(2, docente_a_modificar.getNombre());
			statement.setString(3, docente_a_modificar.getApellido());
			statement.setString(4, docente_a_modificar.getFechaNacimiento());
			statement.setString(5, docente_a_modificar.getEmail());
			statement.setString(6, docente_a_modificar.getDireccion());
			statement.setInt(7, docente_a_modificar.getTelefono());
			statement.setString(8, docente_a_modificar.getIDLocalidad());
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

	private Docente getDocente(ResultSet resultSet) throws SQLException {
		int legajo = resultSet.getInt("id");
		int dni = resultSet.getInt("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		String fechanacimiento = resultSet.getString("fechanacimiento");
		String email = resultSet.getString("email");
		String direccion = resultSet.getString("direccion");
		String idlocalidad = resultSet.getString("idlocalidad");
		int telefono = resultSet.getInt("telefono");
		Boolean activo = resultSet.getBoolean("activo");
		return new Docente(legajo, dni, nombre, apellido, fechanacimiento, email, direccion, idlocalidad, telefono,
				activo);
	}

}
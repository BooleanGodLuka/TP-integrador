package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AlumnoDao;
import dominio.Alumno;

public class AlumnoDaoImpl implements AlumnoDao {

	private static final String insert = "INSERT INTO alumnos(dni, nombre, apellido, fechanacimiento, email, direccion, idlocalidad) VALUES (?, ?, ?, ?, ?, ?, ?) ";
	private static final String delete = "DELETE FROM alumnos WHERE id = ? ";
	private static final String readall = "SELECT * FROM alumnos ";
	private static final String update = "UPDATE alumnos (dni, nombre, apellido, fechanacimiento, email, direccion, idlocalidad) VALUES (?, ?, ?, ?, ?, ?, ?) WHERE id = ? ";

	@Override
	public boolean insert(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setString(4, alumno.getFechaNacimiento());
			statement.setString(5, alumno.getEmail());
			statement.setString(6, alumno.getDireccion());
			statement.setString(7, alumno.getIDLocalidad());
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
	public boolean delete(Alumno alumno_a_borrar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(alumno_a_borrar.getID()));
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
	public List<Alumno> readall() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(getAlumno(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	//se llama readall pero lee un solo alumno a partir de la ID
	@Override
	public List<Alumno> readall(String consigna) {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + consigna);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(getAlumno(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public boolean update(Alumno alumno_a_modificar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setInt(1, alumno_a_modificar.getDni());
			statement.setString(2, alumno_a_modificar.getNombre());
			statement.setString(3, alumno_a_modificar.getApellido());
			statement.setString(4, alumno_a_modificar.getFechaNacimiento());
			statement.setString(5, alumno_a_modificar.getEmail());
			statement.setString(6, alumno_a_modificar.getDireccion());
			statement.setInt(7, alumno_a_modificar.getTelefono());
			statement.setString(8, alumno_a_modificar.getIDLocalidad());
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

	private Alumno getAlumno(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		int dni = resultSet.getInt("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		String fechanacimiento = resultSet.getString("fechanacimiento");
		String email = resultSet.getString("email");
		String direccion = resultSet.getString("direccion");
		String idlocalidad = resultSet.getString("idlocalidad");
		int telefono = resultSet.getInt("telefono");
		return new Alumno(id, dni, nombre, apellido,
				fechanacimiento, email, direccion, idlocalidad, telefono);
	}

}
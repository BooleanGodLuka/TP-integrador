package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.DocenteDao;
import dominio.Curso;
import dominio.Docente;

public class DocenteDaoImpl implements DocenteDao {

	private static final String insert = "INSERT INTO docentes (dni, nombre, apellido, fechanacimiento, direccion, idlocalidad, email, telefono, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, true) ";
	private static final String delete = "UPDATE docentes (activo) VALUES (false) WHERE id = ? ";
	private static final String readall = "SELECT * FROM docentes ";
	private static final String update = "UPDATE docentes SET dni=?, nombre=?, apellido=?, fechanacimiento=?, direccion=?, idlocalidad=?, email=?, telefono=?, activo=true  WHERE id = ? ";

	@Override
	public boolean insert(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, docente.getDni());
			statement.setString(2, docente.getNombre());
			statement.setString(3, docente.getApellido());
			statement.setString(4, docente.getFechaNacimiento());
			statement.setString(5, docente.getDireccion());
			statement.setString(6, docente.getIDLocalidad());
			statement.setString(7, docente.getEmail());
			statement.setString(8, docente.getTelefono());
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
	public boolean delete(String docente_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, docente_a_eliminar);
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
	public ArrayList<Docente> readall() {
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
	public ArrayList<Docente> readall(String consigna) {
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
			statement.setString(1, docente_a_modificar.getDni());
			statement.setString(2, docente_a_modificar.getNombre());
			statement.setString(3, docente_a_modificar.getApellido());
			statement.setString(4, docente_a_modificar.getFechaNacimiento());
			statement.setString(5, docente_a_modificar.getDireccion());
			statement.setString(6, docente_a_modificar.getIDLocalidad());
			statement.setString(7, docente_a_modificar.getEmail());
			statement.setString(8, docente_a_modificar.getTelefono());
			statement.setInt(9, docente_a_modificar.getLegajo());
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
		String dni = resultSet.getString("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		String fechanacimiento = resultSet.getString("fechanacimiento");
		String direccion = resultSet.getString("direccion");
		String idlocalidad = resultSet.getString("idlocalidad");
		String email = resultSet.getString("email");
		String telefono = resultSet.getString("telefono");
		Boolean activo = resultSet.getBoolean("activo");
		return new Docente(legajo, dni, nombre, apellido, fechanacimiento, direccion, idlocalidad, email, telefono, activo);

	}

	@Override
	public String getNombreDocente(int iddocente) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT nombre FROM docentes WHERE id = "
				+ iddocente;
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
	public String getApellidoDocente(int iddocente) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT apellido FROM docentes WHERE id = "
				+ iddocente;
		Statement statement = conexion.getSQLConexion().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String apellido = "";
		try {
			while (resultSet.next()) {
				apellido = resultSet.getString("apellido");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apellido;
	}

	@Override
	public int getIDUltimoDocente() {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		int id = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM cursos ORDER BY id DESC LIMIT 0, 1");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	

}
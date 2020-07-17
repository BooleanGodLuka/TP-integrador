package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.UsuarioDao;
import DaoImpl.Conexion;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	public static final String insert = "INSERT INTO usuarios(iddocente, usuario, clave, activo) VALUES (?, ?, ?, true) ";
	public static final String delete = "UPDATE FROM usuarios (estado) VALUES ('false') WHERE idusuario = ? ";
	public static final String validate = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ? ";
	public static final String update = "UPDATE usuarios SET clave = ? WHERE usuario = ? ";
	private static final String readall = "SELECT * FROM usuarios ";

	@Override
	public boolean insert(Usuario usuario) {

		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean validar = false;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, usuario.getIDDocente());
			statement.setString(2, usuario.getUsuario());
			statement.setString(3, usuario.getClave());
			if (statement.executeUpdate() > 0) {

				validar = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return validar;

	}

	@Override
	public boolean delete(Usuario usuario) {

		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean validar = false;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, usuario.getIDUsuario());
			if (statement.executeUpdate() > 0) {
				validar = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validar;
	}

	@Override
	public boolean updateClave(Usuario usuario) {

		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean validar = false;
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, usuario.getClave());
			statement.setString(2, usuario.getUsuario());
			if (statement.executeUpdate() > 0) {
				validar = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validar;
	}

	public Usuario getUsuario(ResultSet resultSet) throws SQLException {

		int idusuario = resultSet.getInt("idusuario");
		int iddocente = resultSet.getInt("iddocente");
		String nusuario = resultSet.getString("usuario");
		String claveu = resultSet.getString("clave");

		Usuario usuario = new Usuario();

		usuario.setIDUsuario(idusuario);
		usuario.setIDDocente(iddocente);
		usuario.setClave(claveu);
		usuario.setUsuario(nusuario);

		return usuario;

	}

	private void cargarUsuario(Usuario usuario, ResultSet resultSet) throws SQLException {
		usuario.setIDDocente(resultSet.getInt("iddocente"));
		usuario.setUsuario(resultSet.getString("usuario"));
		usuario.setClave(resultSet.getString("clave"));
		usuario.setEstado(resultSet.getBoolean("estado"));
	}

	@Override
	public boolean validateUsuario(Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean validar = false;
		try {
			statement = conexion.prepareStatement(validate);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getClave());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				validar = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validar;
	}

	@Override
	public Usuario validateLogin(Usuario usuario) {

		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Usuario obj = new Usuario();
		try {
			statement = conexion.getSQLConexion().prepareStatement(validate);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getClave());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				obj = getUsuario(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public ArrayList<Usuario> readall() {

		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			Usuario usuario = null;
			while (resultSet.next()) {
				usuario = new Usuario();
				cargarUsuario(usuario, resultSet);
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	/*
	 * no se usa por ahora me parece que la voy a borrar, pero puede llegar a servir
	 * despues. NO LA BORREN
	 * 
	 * @Override public Usuario read(int iddocente) { PreparedStatement statement;
	 * ResultSet resultSet; Conexion conexion = Conexion.getConexion(); try {
	 * statement = conexion.getSQLConexion().prepareStatement(readall +
	 * "WHERE iddocente = " + iddocente); resultSet = statement.executeQuery();
	 * Usuario usuario = null; if (resultSet != null) { usuario = new Usuario();
	 * cargarUsuario(usuario, resultSet); return usuario;
	 * 
	 * } } catch (SQLException e) { e.printStackTrace(); } return null; }
	 * 
	 */

	public String getNombreDocente(int iddocente) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT nombre FROM docentes INNER JOIN usuarios ON docentes.id = usuarios.iddocente WHERE docentes.id = "
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

	public String getApellidoDocente(int iddocente) throws SQLException {
		Conexion conexion = Conexion.getConexion();
		String query = "SELECT apellido FROM docentes INNER JOIN usuarios ON docentes.id = usuarios.iddocente WHERE docentes.id = "
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

}

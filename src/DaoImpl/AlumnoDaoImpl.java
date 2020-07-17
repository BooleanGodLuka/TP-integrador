package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.AlumnoDao;
import dominio.Alumno;

public class AlumnoDaoImpl implements AlumnoDao {

	private static final String insert = "INSERT INTO alumnos(dni, nombre, apellido, fechanacimiento, direccion, idlocalidad, email, telefono, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, true) ";
	private static final String delete = "UPDATE alumnos (activo) VALUES (false) WHERE id = ? ";
	private static final String readall = "SELECT * FROM alumnos ";
	private static final String update = "UPDATE alumnos SET dni=?, nombre=?, apellido=?, fechanacimiento=?, direccion=?, idlocalidad=?, email=?, telefono=?, activo=?  WHERE id = ? ";

	@Override
	public boolean insert(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setString(4, alumno.getFechaNacimiento().toString());
			statement.setString(5, alumno.getDireccion());
			statement.setString(6, alumno.getIDLocalidad());
			statement.setString(7, alumno.getEmail());
			statement.setString(8, alumno.getTelefono());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}

		}

		catch (SQLException e) {
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
	public boolean delete(String alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, alumno);
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
	public ArrayList<Alumno> readall() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			Alumno alumno;
			while (resultSet.next()) {
				alumno = new Alumno();
				cargarAlumno(alumno, resultSet);
				lista.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Alumno read(int idalumno) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Alumno alumno = new Alumno();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + "WHERE id = " + idalumno);
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				cargarAlumno(alumno, resultSet);
				return alumno;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setString(3, alumno.getApellido());
			statement.setString(4, alumno.getFechaNacimiento());
			statement.setString(5, alumno.getDireccion());
			statement.setString(6, alumno.getIDLocalidad());
			statement.setString(7, alumno.getEmail());
			statement.setString(8, alumno.getTelefono());
			statement.setBoolean(9, alumno.getActivo());
			statement.setInt(10, alumno.getLegajo());
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

	private void cargarAlumno(Alumno alumno, ResultSet resultSet) throws SQLException {
		alumno.setLegajo(resultSet.getInt("id"));
		alumno.setDni(resultSet.getString("dni"));
		alumno.setNombre(resultSet.getString("nombre"));
		alumno.setApellido(resultSet.getString("apellido"));
		alumno.setFechaNacimiento(resultSet.getString("fechanacimiento"));
		alumno.setDireccion(resultSet.getString("direccion"));
		alumno.setIDLocalidad(resultSet.getString("idlocalidad"));
		alumno.setEmail(resultSet.getString("email"));
		alumno.setTelefono(resultSet.getString("telefono"));
		alumno.setActivo(resultSet.getBoolean("activo"));
	}

	@Override
	public ArrayList<Alumno> readall(String consigna) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall + " WHERE " + consigna);
			resultSet = statement.executeQuery();
			Alumno alumno;
			while (resultSet.next()) {
				alumno = new Alumno();
				cargarAlumno(alumno, resultSet);
				lista.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
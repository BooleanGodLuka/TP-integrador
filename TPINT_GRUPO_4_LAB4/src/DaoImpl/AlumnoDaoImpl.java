/*package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AlumnoDao;
import dominio.Alumno;
import dominio.Provincia;
import DaoImpl.Conexion;

public class AlumnoDaoImpl implements AlumnoDao {

	
		private static final String insert = "INSERT into alumnos(id,dni,nombre,apellido,fechanacimiento,email, direccion, idlocalidad, telefono) VALUES (?,?,?,?,?,?,?,?,?)";
		private static final String delete = "DELETE FROM alumnos WHERE id = ?";
		private static final String readall = "SELECT * FROM alumnos";
		private static final String update = "UPDATE alumnos (id,dni,nombre,apellido,fechanacimiento,email, direccion, idlocalidad, telefono) VALUES (?,?,?,?,?,?,?,?,?) WHERE id = ?";

		@Override
		public boolean insert(Alumno alumno) {
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean isInsertExitoso = false;
			try
			{
				statement = conexion.prepareStatement(insert);
				statement.setInt(1, .getID());
				statement.setString(2, .getNombre());
				if(statement.executeUpdate() > 0)
				{
					conexion.commit();
					isInsertExitoso = true;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return isInsertExitoso;
			return false;
		}

		@Override
		public boolean delete(Alumno alumno_a_borrar) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<Alumno> select_alumnos() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Alumno> select_alummno_consigna(String consigna) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean update(Alumno alumno_a_modificar) {
			// TODO Auto-generated method stub
			return false;
		}

	
	
	

}

*/

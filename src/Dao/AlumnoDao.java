package Dao;

import java.util.ArrayList;
import dominio.Alumno;

public interface AlumnoDao {

	public boolean insert(Alumno alumno);

	public boolean delete(Alumno alumno_a_eliminar);

	public ArrayList<Alumno> readall();

	public ArrayList<Alumno> readall(String consigna);

	public boolean update(Alumno alumno_a_modificar);

}

package Dao;

import java.util.ArrayList;
import dominio.Alumno;

public interface AlumnoDao {

	public boolean insert(Alumno alumno);

	public boolean delete(String alumno);

	public ArrayList<Alumno> readall();
	
	public ArrayList<Alumno> readall(String consigna);

	public Alumno read(int idalumno);

	public boolean update(Alumno alumno);

}

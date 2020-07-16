package negocio;

import java.util.ArrayList;
import java.util.List;

import dominio.Alumno;

public interface AlumnoNegocio {


		public boolean insert(Alumno alumno);

		public boolean delete(Alumno alumno);

		public ArrayList<Alumno> readall();
		
		public ArrayList<Alumno> readall(String consigna);

		public Alumno read(int idalumno);

		public boolean update(Alumno alumno);

}


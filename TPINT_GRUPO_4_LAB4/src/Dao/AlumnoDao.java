package Dao;

import java.util.List;
import dominio.Alumno;

public interface AlumnoDao {

		public boolean insert(Alumno alumno);
		
		public boolean delete(Alumno alumno_a_borrar);
		
		public List<Alumno> select_alumnos();
		
		public List<Alumno>select_alummno_consigna(String consigna);

		public boolean update(Alumno alumno_a_modificar);

	}


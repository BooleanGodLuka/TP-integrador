package negocio;

import java.util.ArrayList;

import dominio.AlumnoXCurso;

public interface AlumnoXCursoNegocio {

	public boolean actualizar_alumnoXcurso(AlumnoXCurso alumno);
	
	int calcular_cant_alumnXcurso_aprob(int id);

	int calcular_cant_alumnXcurso_desap(int id);

	int calcular_cant_alumnXcurso(int id);

	public boolean insert_alumnoXcurso (AlumnoXCurso alumno);

	ArrayList<AlumnoXCurso> leer_alumnoXcurso(int id_curso);
}

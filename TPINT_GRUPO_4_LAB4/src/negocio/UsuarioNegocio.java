package negocio;

import java.util.List;

import dominio.Alumno;
import dominio.Docente;

public interface UsuarioNegocio {
	public boolean agregar_alumno(Alumno alumno);
	public boolean agregar_docente(Docente docente);
	
	public boolean borrar_alumno(Alumno alumno_a_borrar);
	public boolean borrar_docente(Docente docente_a_borrar);
	
	public List<Alumno> leer_todo_alumno();
	public List<Alumno> leer_todo_alummno_consigna(String consigna);
	
	public List<Docente> leer_todo_docente();
	public List<Docente> leer_todo_docente_consigna(String consigna);
	
	public boolean actualizar_alumno (Alumno alumno_a_modificar);
	public boolean actualizar_docente (Docente docente_a_modificar);
}

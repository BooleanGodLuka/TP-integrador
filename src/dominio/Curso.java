package dominio;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String cuatrimestre;
	private String año;
	private int id_docente;
	private int id_materia;
	private String nombre_materia;

	public Curso() {
	}

	public Curso(int id, String cuatrimestre, String año, int id_docente, int id_materia) {
		super();
		this.id = id;
		this.cuatrimestre = cuatrimestre;
		this.año = año;
		this.id_docente = id_docente;
		this.id_materia = id_materia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public int getId_docente() {
		return id_docente;
	}

	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public boolean validar_exist(ArrayList<Curso> lista) {
		boolean validar = false;
		for (int i = 0; i < lista.size(); i++) {
			String temp;
			temp = lista.get(i).toString();
			if (temp == this.toString()) {
				validar = true;
			}

		}
		return validar;
	}
	
	public void igualar (Curso cur) {
		this.año= cur.getAño();
		this.cuatrimestre = cur.getCuatrimestre();
		this.id = cur.getId();
		this.id_docente = cur.getId_docente();
		this.id_materia = cur.getId_materia();
		this.nombre_materia = cur.getNombre_materia();
	}

	public String getNombre_materia() {
		return nombre_materia;
	}

	public void setNombre_materia(String nombre_materia) {
		this.nombre_materia = nombre_materia;
	}

	public Curso(Curso cur) {
		super();
		this.id = cur.id;
		this.cuatrimestre = cur.cuatrimestre;
		this.año = cur.año;
		this.id_docente = cur.id_docente;
		this.id_materia = cur.id_materia;
		this.nombre_materia = cur.nombre_materia;
	}

	
	
	
}

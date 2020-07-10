package dominio;

import java.util.ArrayList;

public class Curso {

	private int ID;
	private Materia Materia;
	private String Cuatrimestre;
	private String Anio;
	private Docente Docente;

	public Curso() {
		Materia = new Materia();
		Docente = new Docente();
	}

	public Curso(int id, Materia materia, String cuatrimestre, String anio, Docente docente) {
		super();
		this.ID = id;
		this.Materia = new Materia(materia);
		this.Cuatrimestre = cuatrimestre;
		this.Anio = anio;
		this.Docente = new Docente(docente);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Materia getMateria() {
		return Materia;
	}

	public void setMateria(Materia materia) {
		Materia = materia;
	}

	public String getCuatrimestre() {
		return Cuatrimestre;
	}

	public void setCuatrimestre(String cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}

	public String getAnio() {
		return Anio;
	}

	public void setAnio(String anio) {
		Anio = anio;
	}

	public Docente getDocente() {
		return Docente;
	}

	public void setDocente(Docente docente) {
		Docente = docente;
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

	public void igualar(Curso cur) {
		this.Anio = cur.getAnio();
		this.Cuatrimestre = cur.getCuatrimestre();
		this.ID = cur.getID();
		this.Docente = new Docente(cur.getDocente());
		this.Materia = new Materia(cur.getMateria());

	}

	public Curso(Curso cur) {
		super();
		this.ID = cur.getID();
		this.Cuatrimestre = cur.getCuatrimestre();
		this.Anio = cur.Anio;
		this.Docente = new Docente(cur.getDocente());
		this.Materia = new Materia(cur.getMateria());
	}

}

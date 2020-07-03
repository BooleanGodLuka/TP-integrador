package dominio;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String cuatrimestre;
	private String a�o;
	private int id_docente;
	private int id_materia;
	
	
	
	
	
	
	
	public Curso(int id, String cuatrimestre, String a�o, int id_docente, int id_materia) {
		super();
		this.id = id;
		this.cuatrimestre = cuatrimestre;
		this.a�o = a�o;
		this.id_docente = id_docente;
		this.id_materia = id_materia;
	}
	
	
	



	public Curso() {
		// TODO Auto-generated constructor stub
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
	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
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
	
	
	public boolean validar_exist ( ArrayList<Curso> lista) {
		boolean validar = false;
		for (int i =0; i<lista.size();i++) {
			String temp;
			temp = lista.get(i).toString();
			if (temp == this.toString()) {
				validar = true;
			}
			
		}
		return validar;
	}
	
	
}

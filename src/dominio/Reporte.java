package dominio;

public class Reporte {
	
	private String materia;
	private String cuatri;
	private String docente;
	private int cant_alumn;
	private int cant_aprob;
	private int cant_desaprob;
	private float porcentaje;
	private String año;
	
	
	
	
	
	
	
	public Reporte() {
		super();
	}
	public Reporte(String materia, String cuatri, String docente, int cant_alumn, int cant_aprob, int cant_desaprob) {
		super();
		this.materia = materia;
		this.cuatri = cuatri;
		this.docente = docente;
		this.cant_alumn = cant_alumn;
		this.cant_aprob = cant_aprob;
		this.cant_desaprob = cant_desaprob;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getCuatri() {
		return cuatri;
	}
	public void setCuatri(String cuatri) {
		this.cuatri = cuatri;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public int getCant_alumn() {
		return cant_alumn;
	}
	public void setCant_alumn(int cant_alumn) {
		this.cant_alumn = cant_alumn;
	}
	public int getCant_aprob() {
		return cant_aprob;
	}
	public void setCant_aprob(int cant_aprob) {
		this.cant_aprob = cant_aprob;
	}
	public int getCant_desaprob() {
		return cant_desaprob;
	}
	public void setCant_desaprob(int cant_desaprob) {
		this.cant_desaprob = cant_desaprob;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public void cargar_porcentaje() {
		this.porcentaje = (this.cant_aprob*100)/this.cant_alumn;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	
	
	
	
}

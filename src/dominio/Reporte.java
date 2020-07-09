package dominio;

public class Reporte {

	private Curso Curso;
	private int Cant_alumn;
	private int Cant_aprob;
	private int Cant_desaprob;
	private float Porcentaje;

	public Reporte() {
		super();
	}

	public Reporte(int idmateria, int cuatrimestre, int anio, int iddocente, int cant_alumn, int cant_aprob, int cant_desaprob) {
		super();
		this.Curso.getMateria().setID(idmateria);
		this.Curso.setCuatrimestre(cuatrimestre);
		this.Curso.setAnio(anio);
		this.Curso.getDocente().setLegajo(iddocente);
		this.Cant_alumn = cant_alumn;
		this.Cant_aprob = cant_aprob;
		this.Cant_desaprob = cant_desaprob;
	}

	
	
	public Curso getCurso() {
		return Curso;
	}

	public void setCurso(Curso curso) {
		Curso = curso;
	}

	public int getCant_alumn() {
		return Cant_alumn;
	}

	public void setCant_alumn(int cant_alumn) {
		Cant_alumn = cant_alumn;
	}

	public int getCant_aprob() {
		return Cant_aprob;
	}

	public void setCant_aprob(int cant_aprob) {
		Cant_aprob = cant_aprob;
	}

	public int getCant_desaprob() {
		return Cant_desaprob;
	}

	public void setCant_desaprob(int cant_desaprob) {
		Cant_desaprob = cant_desaprob;
	}

	public float getPorcentaje() {
		return Porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		Porcentaje = porcentaje;
	}

	public void cargar_porcentaje() {
		this.Porcentaje = (this.Cant_aprob * 100) / this.Cant_alumn;
	}

}

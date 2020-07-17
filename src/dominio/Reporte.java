package dominio;

public class Reporte {

	private Curso Curso;
	private int CantAlum;
	private int CantAprob;
	private int CantDesaprob;
	private float Porcentaje;

	public Reporte() {
		super();
		Curso = new Curso();
	}

	public Reporte(int idmateria, String cuatrimestre, String anio, int iddocente, int cantalum, int cantaprob, int cantdesaprob) {
		super();
		this.Curso.getMateria().setID(idmateria);
		this.Curso.setCuatrimestre(cuatrimestre);
		this.Curso.setAnio(anio);
		this.Curso.getDocente().setLegajo(iddocente);
		this.CantAlum = cantalum;
		this.CantAprob = cantaprob;
		this.CantDesaprob = cantdesaprob;
	}

	
	
	public Curso getCurso() {
		return Curso;
	}

	public void setCurso(Curso curso) {
		Curso = curso;
	}

	public int getCant_alumn() {
		return CantAlum;
	}

	public void setCant_alumn(int cantalum) {
		CantAlum = cantalum;
	}

	public int getCant_aprob() {
		return CantAprob;
	}

	public void setCant_aprob(int cantaprob) {
		CantAprob = cantaprob;
	}

	public int getCant_desaprob() {
		return CantDesaprob;
	}

	public void setCant_desaprob(int cantdesaprob) {
		CantDesaprob = cantdesaprob;
	}

	public float getPorcentaje() {
		return Porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		Porcentaje = porcentaje;
	}

	public void cargar_porcentaje() {
		this.Porcentaje = (this.CantDesaprob * 100) / this.CantAlum;
	}

}

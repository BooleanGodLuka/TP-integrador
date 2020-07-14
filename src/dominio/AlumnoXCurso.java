package dominio;

public class AlumnoXCurso {

	private Alumno Alumno;
	private Curso Curso;
	private int Nota1;
	private int Nota2;
	private int Nota3;
	private int Nota4;
	private String Regularidad;

	public AlumnoXCurso() {
		Alumno = new Alumno();
		Curso = new Curso();
	}
 
	public AlumnoXCurso(AlumnoXCurso axc) {
		Alumno = new Alumno(axc.getAlumno());
		Curso = new Curso(axc.getCurso());
	}

	public AlumnoXCurso(int idalumno, int idcurso, int nota1, int nota2, int nota3, int nota4, String nombre,
			String apellido, String regularidad) {
		super();
		Alumno = new Alumno();
		Alumno.setLegajo(idalumno);
		Curso = new Curso();
		Curso.setID(idcurso);
		this.Nota1 = nota1;
		this.Nota2 = nota2;
		this.Nota3 = nota3;
		this.Nota4 = nota4;
		this.Regularidad = regularidad;
	}

	public Alumno getAlumno() {
		return Alumno;
	}

	public void setAlumno(Alumno alumno) {
		Alumno = alumno;
	}

	public Curso getCurso() {
		return Curso;
	}

	public void setCurso(Curso curso) {
		Curso = curso;
	}

	public int getNota1() {
		return Nota1;
	}

	public void setNota1(int nota1) {
		Nota1 = nota1;
	}

	public int getNota2() {
		return Nota2;
	}

	public void setNota2(int nota2) {
		Nota2 = nota2;
	}

	public int getNota3() {
		return Nota3;
	}

	public void setNota3(int nota3) {
		Nota3 = nota3;
	}

	public int getNota4() {
		return Nota4;
	}

	public void setNota4(int nota4) {
		Nota4 = nota4;
	}

	public String getRegularidad() {
		return Regularidad;
	}

	public void setRegularidad(String regularidad) {
		Regularidad = regularidad;
	}
	
	public void igualar (AlumnoXCurso al) {
		this.Alumno = new Alumno(al.getAlumno());
		this.Curso = new Curso(al.getCurso());
		//this.Alumno.igualar(al.getAlumno());
		//this.Curso.igualar(al.getCurso());
		this.Nota1 = al.getNota1();
		this.Nota2 = al.getNota2();
		this.Nota3 = al.getNota3();
		this.Nota4 = al.getNota4();
		this.Regularidad = al.getRegularidad();
	}
	

}

package dominio;

public class alumnoXcurso {

	private Alumno Alumno;
	private Curso Curso;
	private String Nombre;
	private String Apellido;
	private int Nota1;
	private int Nota2;
	private int Nota3;
	private int Nota4;
	private String Regularidad;

	public alumnoXcurso() {
		super();
	}

	public alumnoXcurso(alumnoXcurso axc) {
		super();
		
	}

	public alumnoXcurso(int id_alumno, int id_curso, int nota1, int nota2, int nota3, int nota4, String nombre,
			String apellido, String r) {
		super();
		Alumno = new Alumno();
		Alumno.setLegajo(id_alumno);
		Alumno.setNombre(nombre);
		Alumno.setApellido(apellido);
		Curso = new Curso();
		Curso.setID(id_curso);
		this.Nota1 = nota1;
		this.Nota2 = nota2;
		this.Nota3 = nota3;
		this.Nota4 = nota4;
		this.Regularidad = r;
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
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
		this.Regularidad = regularidad;
	}

}

package dominio;

public class alumnoXcurso {

	private int id_alumno;
	private int id_curso;
	private String nombre;
	private String apellido;
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	
	
	
	
	
	public alumnoXcurso() {
		super();
	}


	public alumnoXcurso(int id_alumno, int id_curso, int nota1, int nota2, int nota3, int nota4, String nombre, String apellido) {
		super();
		this.id_alumno = id_alumno;
		this.id_curso = id_curso;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	public int getNota4() {
		return nota4;
	}
	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	
}

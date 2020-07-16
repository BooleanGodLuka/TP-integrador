package dominio;

public class Materia {

	private int ID;
	String Nombre;

	public Materia() {
		super();
	}

	public Materia(Materia materia) {
		super();
		this.ID = materia.getID();
		this.Nombre = materia.getNombre();
	}

	public Materia(int id, String nombre) {
		super();
		this.ID = id;
		this.Nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}

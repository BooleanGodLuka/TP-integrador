package dominio;

public class Materia {

	int ID;
	String Nombre;

	public Materia(int id, String nombre) {
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

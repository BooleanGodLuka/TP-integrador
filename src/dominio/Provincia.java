package dominio;

public class Provincia {
	
	private int ID;
	private String Nombre;
	
	public Provincia(int id, String nombre) {
		this.ID = id;
		this.Nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	@Override
	public String toString() {
		return Nombre;
	}

}
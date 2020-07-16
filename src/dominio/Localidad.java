package dominio;

public class Localidad {
	
	private int ID;
	private String Nombre;
	private int IDProvincia;

	public Localidad() {
		super();
	}

	public Localidad(int id, String nombre, int idprovincia) {
		this.ID = id;
		this.Nombre = nombre;
		this.IDProvincia = idprovincia;
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
	
	public int getIDProvincia() {
		return IDProvincia;
	}
	
	public void setIDProvincia(int idprovincia) {
		IDProvincia = idprovincia;
	}
	
	@Override
	public String toString() {
		return Nombre;
	}

}
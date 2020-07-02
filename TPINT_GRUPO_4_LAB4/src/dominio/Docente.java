package dominio;

public class Docente {

	private int id;
	private int dni;
	private String nombre;
	private String apellido;
	private String fechanacimiento;
	private String email;
	private String direccion;
	private int idlocalidad;
	
	
	
	public Docente(int id, int dni, String nombre, String apellido, String fechanacimiento, String email,
			String direccion, int idlocalidad) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.email = email;
		this.direccion = direccion;
		this.idlocalidad = idlocalidad;
	}



	public int getId() {
		return id;
	}



	public int getDni() {
		return dni;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public String getFechanacimiento() {
		return fechanacimiento;
	}



	public String getEmail() {
		return email;
	}



	public String getDireccion() {
		return direccion;
	}



	public int getIdlocalidad() {
		return idlocalidad;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setDni(int dni) {
		this.dni = dni;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}



	@Override
	public String toString() {
		return "Docente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechanacimiento=" + fechanacimiento + ", email=" + email + ", direccion=" + direccion
				+ ", idlocalidad=" + idlocalidad + "]";
	}



	
	

}

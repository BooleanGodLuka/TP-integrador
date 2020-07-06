package dominio;

import java.util.ArrayList;


public class Alumno {

	private int ID;
	private int Dni;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Email;
	private String Direccion;
	private String IDLocalidad;
	//private int Telefono;
	
	
	public Alumno(int id, int dni, String nombre, String apellido, String fnacimiento, String email,
			String direccion, String idlocalidad/*, int telefono*/) {
		super();
		this.ID = id;
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fnacimiento;
		this.Email = email;
		this.Direccion = direccion;
		this.IDLocalidad = idlocalidad;
		//this.Telefono = telefono;
	}
	
	
	public int getID() {
		return ID;
	}
	
	public int getDni() {
		return Dni;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getDireccion() {
		return Direccion;
	}
	
	public String getIDLocalidad() {
		return IDLocalidad;
	}
	
	/*public int getTelefono() {
		return Telefono;
	}*/
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public void setDni(int dni) {
		this.Dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	
	public void setFechaNacimiento(String fechanacimiento) {
		this.FechaNacimiento = fechanacimiento;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}
	
	public void setIDLocalidad(String idlocalidad) {
		this.IDLocalidad = idlocalidad;
	}
	
	/*public void setTelefono(int telefono) {
		this.Telefono = telefono;
	}*/
	
	
	public boolean validar_exist ( ArrayList<Alumno> lista) {
		boolean validar = false;
		for (int i =0; i<lista.size();i++) {
			String temp;
			temp = lista.get(i).toString();
			if (temp == this.toString()) {
				validar = true;
			}
			
		}
		return validar;
	}
	
	
	@Override
	public String toString() {
		return "Alumno [id=" + ID + ", dni=" + Dni + ", nombre=" + Nombre + ", apellido=" + Apellido
				+ ", fechanacimiento=" + FechaNacimiento + ", email=" + Email + ", direccion=" + Direccion
				+ ", idlocalidad=" + IDLocalidad /*+ ", telefono=" + Telefono */+ "]";
	}
	
	

}

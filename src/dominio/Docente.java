package dominio;

import java.util.ArrayList;

public class Docente {

	private int Legajo;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Direccion;
	private String IDProvincia;
	private String IDLocalidad;
	private String Email;
	private String Telefono;
	private Boolean Activo;

	public Docente() {
		super();
	}

	public Docente(Docente a) {
		super();
		this.Legajo = a.Legajo;
		this.Dni = a.Dni;
		this.Nombre = a.Nombre;
		this.Apellido = a.Apellido;
		this.FechaNacimiento = a.FechaNacimiento;
		this.Direccion = a.Direccion;
		this.IDProvincia = a.IDProvincia;
		this.IDLocalidad = a.IDLocalidad;
		this.Email = a.Email;
		this.Telefono = a.Telefono;
		this.Activo = a.Activo;
	}

	public Docente(int id, String dni, String nombre, String apellido, String fnacimiento, String direccion,
			String idprovincia, String idlocalidad, String email, String telefono, Boolean activo) {
		super();
		this.Legajo = id;
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fnacimiento;
		this.Direccion = direccion;
		this.IDLocalidad = idlocalidad;
		this.Email = email;
		this.Telefono = telefono;
		this.Activo = activo;
	}

	public Docente(String dni, String nombre, String apellido, String fnacimiento, String direccion, String idprovincia,
			String idlocalidad, String email, String telefono, Boolean activo) {
		super();
		this.Legajo = 0;
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fnacimiento;
		this.Direccion = direccion;
		this.IDProvincia = idprovincia;
		this.IDLocalidad = idlocalidad;
		this.Email = email;
		this.Telefono = telefono;
		this.Activo = activo;
	}

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
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

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getIDLocalidad() {
		return IDLocalidad;
	}

	public void setIDLocalidad(String iDLocalidad) {
		IDLocalidad = iDLocalidad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Boolean getActivo() {
		return Activo;
	}

	public void setActivo(Boolean activo) {
		Activo = activo;
	}

	@Override
	public String toString() {
		return "Docente " + Apellido + ", " + Nombre + " - Legajo Nº " + Legajo;
	}

	public boolean validar_exist(ArrayList<Docente> lista) {
		boolean validar = false;
		for (int i = 0; i < lista.size(); i++) {
			String temp;
			temp = lista.get(i).toString();
			if (temp == this.toString()) {
				validar = true;
			}

		}
		return validar;
	}

	public void igualar(Docente doc) {
		this.Activo = doc.Activo;
		this.Apellido = doc.Apellido;
		this.Direccion = doc.Direccion;
		this.Dni = doc.Dni;
		this.Email = doc.Email;
		this.FechaNacimiento = doc.FechaNacimiento;
		this.IDLocalidad = doc.IDLocalidad;
		this.Legajo = doc.Legajo;
		this.Nombre = doc.Nombre;
		this.Telefono = doc.Telefono;
	}

	public String getIDProvincia() {
		return IDProvincia;
	}

	public void setIDProvincia(String iDProvincia) {
		IDProvincia = iDProvincia;
	}
	
	

}

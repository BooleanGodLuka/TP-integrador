package dominio;

import java.util.ArrayList;

public class Docente {

	private int Legajo;
	private int Dni;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Email;
	private String Direccion;
	private String IDLocalidad;
	private int Telefono;
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
		this.Email = a.Email;
		this.Direccion = a.Direccion;
		this.IDLocalidad = a.IDLocalidad;
		this.Telefono = a.Telefono;
		this.Activo = a.Activo;
	}

	public Docente(int id, int dni, String nombre, String apellido, String fnacimiento, String email,
			String direccion, String idlocalidad, int telefono, Boolean activo) {
		super();
		this.Legajo = id;
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fnacimiento;
		this.Email = email;
		this.Direccion = direccion;
		this.IDLocalidad = idlocalidad;
		this.Telefono = telefono;
		this.Activo = activo;
	}

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
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
		return "Docente [id=" + Legajo + ", dni=" + Dni + ", nombre=" + Nombre + ", apellido=" + Apellido
				+ ", fechanacimiento=" + FechaNacimiento + ", email=" + Email + ", direccion=" + Direccion
				+ ", idlocalidad=" + IDLocalidad + "]";
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

}

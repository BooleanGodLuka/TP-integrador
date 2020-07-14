package dominio;

public class Usuario {
	
	private int IDUsuario;
	private int IDDocente;
	private String Usuario;
	private String Clave;
	boolean Activo;
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(int Idusuario, int Iddocente, String Usuario, String Clave, boolean Activo) {
		super();
		this.IDUsuario = Idusuario;
		this.IDDocente = Iddocente;
		this.Usuario = Usuario;
		this.Clave = Clave;
		this.Activo = true;
	}
	
	

	public Usuario(String Usuario, String Clave) {
		super();
		this.Usuario = Usuario;
		this.Clave = Clave;
	}


	public int getIDUsuario() {
		return IDUsuario;
	}



	public int getIDDocente() {
		return IDDocente;
	}



	public String getUsuario() {
		return Usuario;
	}



	public String getClave() {
		return Clave;
	}
	
	public boolean getEstado() {
		return Activo;
	}



	public void setIDUsuario(int Idusuario) {
		this.IDUsuario = Idusuario;
	}



	public void setIDDocente(int Iddocente) {
		this.IDDocente = Iddocente;
	}



	public void setUsuario(String Usuario) {
		this.Usuario = Usuario;
	}



	public void setClave(String Clave) {
		this.Clave = Clave;
	}
	

	public void setEstado(boolean Activo) {
		this.Activo = Activo;
	}



	@Override
	public String toString() {
		return "Usuario [IDUsuario=" + IDUsuario + ", IDDocente=" + IDDocente + ", Usuario=" + Usuario + ", Clave="
				+ Clave + ", Activo=" + Activo + "]";
	}

	
	
}

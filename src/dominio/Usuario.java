package dominio;

public class Usuario {
	
	private int IDUsuario;
	private int IDDocente;
	private String Usuario;
	private String Clave;
	boolean Activo;
	
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


	public int getIdusuario() {
		return IDUsuario;
	}



	public int getIddocente() {
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



	public void setIdusuario(int Idusuario) {
		this.IDUsuario = Idusuario;
	}



	public void setIddocente(int Iddocente) {
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
		return "Usuario [idUsuario=" + IDUsuario + ", Iddocente=" + IDDocente + ", Usuario=" + Usuario + ", Clave="
				+ Clave + ", Activo=" + Activo + "]";
	}

	
	
	
}

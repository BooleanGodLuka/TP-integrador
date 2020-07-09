package dominio;

public class Usuario {
	
	private String Idusuario;
	private String Iddocente;
	private String Usuario;
	private String Clave;
	boolean Activo;
	
	public Usuario(String Idusuario, String Iddocente, String Usuario, String Clave, boolean Activo) {
		super();
		this.Idusuario = Idusuario;
		this.Iddocente = Iddocente;
		this.Usuario = Usuario;
		this.Clave = Clave;
		this.Activo = true;
	}
	
	

	public Usuario(String Usuario, String Clave) {
		super();
		this.Usuario = Usuario;
		this.Clave = Clave;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	public String getIdusuario() {
		return Idusuario;
	}



	public String getIddocente() {
		return Iddocente;
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



	public void setIdusuario(String Idusuario) {
		this.Idusuario = Idusuario;
	}



	public void setIddocente(String Iddocente) {
		this.Iddocente = Iddocente;
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
		return "Usuario [idUsuario=" + Idusuario + ", Iddocente=" + Iddocente + ", Usuario=" + Usuario + ", Clave="
				+ Clave + ", Activo=" + Activo + "]";
	}

	
	
	
}

package dominio;

public class Usuario {
	
	private String idusuario;
	private String iddocente;
	private String usuario;
	private String clave;
	boolean estado;
	
	public Usuario(String idusuario, String iddocente, String usuario, String clave, boolean estado) {
		super();
		this.idusuario = idusuario;
		this.iddocente = iddocente;
		this.usuario = usuario;
		this.clave = clave;
		this.estado = true;
	}
	
	

	public Usuario(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	public String getIdusuario() {
		return idusuario;
	}



	public String getIddocente() {
		return iddocente;
	}



	public String getUsuario() {
		return usuario;
	}



	public String getClave() {
		return clave;
	}
	
	public boolean getEstado() {
		return estado;
	}



	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}



	public void setIddocente(String iddocente) {
		this.iddocente = iddocente;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}
	

	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", iddocente=" + iddocente + ", usuario=" + usuario + ", clave="
				+ clave + ", estado=" + estado + "]";
	}

	
	
	
}

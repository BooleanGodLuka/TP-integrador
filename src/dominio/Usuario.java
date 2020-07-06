package dominio;

public class Usuario {
	
	private String idusuario;
	private String usuario;
	private String clave;
	
	public Usuario(String idusuario, String usuario, String clave) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.clave = clave;
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

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", usuario=" + usuario + ", clave=" + clave + "]";
	}
	
	
	
}

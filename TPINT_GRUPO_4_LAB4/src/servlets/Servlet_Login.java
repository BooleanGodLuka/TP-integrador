package servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;

@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Servlet_Login() {
        super();

    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*Lo que hace el servlet una vez que obtiene el form con metodo POST del login, si el usuario es un docente*/
		
		/*crear variable session*/
		HttpSession session = request.getSession(true);
		
		/*usuario que se va a extraer de la bdd*/
		Usuario usuario = new Usuario();
		
		/*parametros a obtener y el home a mostrar*/
		String nusuario = "";
		String clave = "";
		int profile = 0;
		
		if (request.getParameter("btnAceptar")!=null)
		{
			
			if (request.getParameter("txtUser") !=null && request.getParameter("txtPassword")!=null){
			nusuario = request.getParameter("txtUser");
			clave = request.getParameter("txtPassword");
			UsuarioDaoImpl usuarioImpl = new UsuarioDaoImpl();
			ResultSet resultset = 
			usuario = usuarioImpl.get_usuario(resultset);
			profile = Integer.parseInt(usuario.getIdusuario());
			
			}
			
			String url = "";
			
			if(profile == 1) {
			session.setAttribute("Usuario", nusuario);
			url = "/Home.jsp";
			}
			else {
				url = "/Home.jsp";
			}

			//requestdispatcher
			request.setAttribute("Usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);


	}

																																
}


}

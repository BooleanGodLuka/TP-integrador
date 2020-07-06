package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

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
		Usuario user = new Usuario();

		
		/*parametros a obtener y el home a mostrar*/
		String nusuario = "";
		String claveu = "";
		String iduser = "";
		boolean exists = false;
		String direccion = "";
		String error = "";
		
		if (request.getParameter("btnAceptar")!=null)
		{
			
			if (request.getParameter("txtUser") !=null && request.getParameter("txtPassword")!=null){
				nusuario = request.getParameter("txtUser");
				claveu = request.getParameter("txtPassword");
				UsuarioDaoImpl usuarioImpl = new UsuarioDaoImpl();
				exists = usuarioImpl.validate_usuario(user);
				if (exists == true) {
					user = usuarioImpl.get_usuario(usuario)
					}
			else {
					error = "No existe el usuario cargado.";
					}
				
				}
		
			
			if(user.getIdusuario() == "1") {
			session.setAttribute("Usuario", nusuario);
			direccion = "/Home.jsp";
			}
			
			else {
				session.setAttribute("Usuario", nusuario);
				direccion = "/Home.jsp";
			}

			//requestdispatcher
			request.setAttribute("Usuario", nusuario);
			RequestDispatcher rd = request.getRequestDispatcher(direccion);
			rd.forward(request, response);


		}

																																
	}


}

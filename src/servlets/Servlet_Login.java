package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;

@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Servlet_Login() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDao usdao = new UsuarioDaoImpl();
		
		String direccion = "";
		
		if (request.getParameter("btnAceptar")!=null)
		{
			/*invalidar anterior session*/
			request.getSession().invalidate();
			
			/*crear nueva session*/
			HttpSession session = request.getSession(true);
	
			if (request.getParameter("txtUser") !=null && request.getParameter("txtPassword")!=null)
			{
				
				/*parametros a obtener*/
				String nusuario = request.getParameter("txtUser");
				String claveu = request.getParameter("txtPassword");
				Usuario usu = new Usuario();
				usu = usdao.validate_usuario(nusuario, claveu);
				
				/*el home a mostrar*/
				if (usu.getIdusuario() == "1") {
					session.setAttribute("Usuario", usu);
					
					direccion = "Home.jsp";
					}
				if (usu.getIdusuario() != "1") {
					session.setAttribute("Usuario", usu);
					
					direccion = "Home.jsp";
				}
				
			else {
				boolean exists = false;
				request.setAttribute("login", exists);
				direccion = "login_JSP.jsp";
					}
				
			}

			//requestdispatcher
			RequestDispatcher rd = request.getRequestDispatcher(direccion);
			rd.forward(request, response);
			doGet(request, response);

		}

																																
    }


}

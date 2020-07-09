package servlets;

import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;

/**
 * Servlet implementation class ServletListarAlumnos
 */
@WebServlet("/ServletListarAlumnos")
public class ServletListarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 ServletListarAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("listar") != null)
			
		{
			AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();
			
			List listaAlum = (List) alumnoNeg.readall();
			
			request.setAttribute("listaAlum", listaAlum);	
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarAlumnos.jsp");   
	        rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

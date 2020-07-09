package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Alumno;
import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;


@WebServlet("/ServletListarAlumnos")
public class ServletListarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 ServletListarAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();
		
		if (request.getParameter("dropdown_ListarAlumnos") != null) {
		
		ArrayList<Alumno> lista = alumnoNeg.readall();
		
		request.setAttribute("listaAlum", lista);	
		
		RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarAlumnos.jsp");   
        rd.forward(request, response);
		doGet(request, response);
		}
		
	
	}
	
}

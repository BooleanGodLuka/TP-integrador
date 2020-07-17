package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Alumno;
import dominio.AlumnoXCurso;
import negocio.AlumnoNegocio;
import negocio.AlumnoXCursoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.AlumnoXCursoNegocioImpl;

@WebServlet("/ServletListarAlumnos")
public class ServletListarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();
		
		if (request.getParameter("btn_ModificarCurso") != null) {
			String id = request.getParameter("idCurso");
		
			request.setAttribute("id", id);
			
			RequestDispatcher rd = request.getRequestDispatcher("ServletModificarCurso.java");
			rd.forward(request, response);
			
		}
		
		ArrayList<Alumno> lista = alumnoNeg.readall();

		request.setAttribute("listaAlum", lista);

		RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarAlumnos.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

}

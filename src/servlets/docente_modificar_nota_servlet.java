package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.alumnoXcurso;
import negocioImpl.CursoNegocioImpl;

/**
 * Servlet implementation class docente_modificar_nota_servlet
 */
@WebServlet("/docente_modificar_nota_servlet")
public class docente_modificar_nota_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public docente_modificar_nota_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CursoNegocioImpl cudao = new CursoNegocioImpl();
		
		if (request.getParameter("btn_alumnos") != null) {
			
			ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(request.getParameter("id_curso")) ;
			
			request.setAttribute("lista_alumnos", lista);
			
			RequestDispatcher rd =request.getRequestDispatcher("Docente/Docente_ModificarNotas.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

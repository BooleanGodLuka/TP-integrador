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


import dominio.Curso;
import negocio.CursoNegocio;
import negocioImpl.CursoNegocioImpl;


@WebServlet("/ServletListarCurso")
public class ServletListarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	  }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CursoNegocio cursoNeg = new CursoNegocioImpl();

		ArrayList<Curso> lista = cursoNeg.readall();

		request.setAttribute("listacur", lista);

		RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarCursos.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

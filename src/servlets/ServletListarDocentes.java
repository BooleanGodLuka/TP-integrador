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

import negocio.DocenteNegocio;
import negocioImpl.DocenteNegocioImpl;
import dominio.Docente;


@WebServlet("/ServletListarDocentes")
public class ServletListarDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			DocenteNegocio docenteneg = new DocenteNegocioImpl();
			
			ArrayList<Docente> lista = (ArrayList<Docente>) docenteneg.readall();
			
			request.setAttribute("listaDoc", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarDocentes.jsp");   
	        rd.forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

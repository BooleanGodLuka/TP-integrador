package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Docente;
import dominio.Localidad;
import negocio.LocalidadNegocio;
import negocioImpl.LocalidadNegocioImpl;

@WebServlet("/ServletLocalidades")
public class ServletLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLocalidades() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");

		String idprov = request.getParameter("prov");

		PrintWriter out = response.getWriter();

		out.print("<option value='' selected>- Seleccione Localidad -</option>");

		LocalidadNegocio locneg = new LocalidadNegocioImpl();

		ArrayList<Localidad> listLoc = new ArrayList<Localidad>();

		listLoc = locneg.readall(idprov);

		for (Localidad loc : listLoc) {
			out.println("<option value='" + loc.getID() + "'>" + loc.getNombre() + "</option>");
		}
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Localidad;
import dominio.Provincia;
import negocio.LocalidadNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

@WebServlet("/ServletProvincias")
public class ServletProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProvincias() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("param2") != null) {

			ProvinciaNegocio provneg = new ProvinciaNegocioImpl();

			ArrayList<Provincia> listProv = provneg.readall();

			request.setAttribute("ListaProvincias", listProv);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaAlumno.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("param") != null) {

			ProvinciaNegocio provneg = new ProvinciaNegocioImpl();

			ArrayList<Provincia> listProv = provneg.readall();

			request.setAttribute("ListaProvincias", listProv);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaDocente.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

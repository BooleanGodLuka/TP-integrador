package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Docente;
import dominio.Localidad;
import dominio.Provincia;
import negocio.DocenteNegocio;
import negocioImpl.DocenteNegocioImpl;

@WebServlet("/ServletAltaDocentes")
public class ServletAltaDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAltaDocentes() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DocenteNegocio docneg = new DocenteNegocioImpl();

		if (request.getParameter("btnAltaDocente") != null) {
			Docente docente = new Docente();

			docente.setNombre(request.getParameter("nombre"));
			docente.setApellido(request.getParameter("apellido"));
			docente.setDni(request.getParameter("dni"));
			docente.setFechaNacimiento(request.getParameter("fechanacimiento").toString());
			docente.setEmail(request.getParameter("email"));
			docente.setTelefono(request.getParameter("telefono"));

			Provincia provincia = new Provincia();
			provincia.setID(Integer.parseInt(request.getParameter("slctProvincia")));
			Localidad localidad = new Localidad();
			localidad.setID(Integer.parseInt(request.getParameter("slctLocalidad")));
			localidad.setIDProvincia(provincia.getID());

			docente.setIDLocalidad(Integer.toString(localidad.getID()));

			docente.setDireccion(request.getParameter("direccion"));

			boolean agrego = docneg.insert(docente);

			request.setAttribute("agrego", agrego);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaAlumno.jsp");
			rd.forward(request, response);

		}

	}

}

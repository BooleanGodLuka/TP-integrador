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
import negocio.LocalidadNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

/**
 * Servlet implementation class ServletAltaDocentes
 */
@WebServlet("/ServletAltaDocentes")
public class ServletAltaDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProvinciaNegocio provinciaNeg = new ProvinciaNegocioImpl();
	LocalidadNegocio localidadNeg = new LocalidadNegocioImpl();
	DocenteNegocio docenteNeg = new DocenteNegocioImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAltaDocentes() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Provincia> provincias = provinciaNeg.readall();
			request.setAttribute("ListaProvincias", provincias);

			List<Localidad> localidades = localidadNeg.readall();
			request.setAttribute("ListaLocalidades", localidades);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaDocente.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO la idea era cargar el combobox mandando un form por post... al apretar
		// un boton, no se como hacerlo en "onchange="
		// int idProvincia = Integer.parseInt(request.getParameter("idprovincia"));
		// request.setAttribute("selectedProvId", idProvincia);

		// TODO así que ahora envía los datos del alumno al server.
		try {

			cargarPersona(request);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Docente cargarPersona(HttpServletRequest request) {
		Docente docente = new Docente();
		docente.setDni(Integer.parseInt(request.getParameter("dni")));
		docente.setNombre(request.getParameter("nombre"));
		docente.setApellido(request.getParameter("apellido"));
		docente.setFechaNacimiento(request.getParameter("fechanacimiento"));
		docente.setEmail(request.getParameter("email"));
		docente.setDireccion(request.getParameter("direccion"));
		docente.setIDLocalidad(request.getParameter("localidad"));
		docente.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		docente.setActivo(Boolean.getBoolean(request.getParameter("activo")));

		docenteNeg.insert(docente);

		return docente;
	}

}

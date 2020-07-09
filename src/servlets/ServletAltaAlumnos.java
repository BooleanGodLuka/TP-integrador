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

import dominio.Alumno;
import dominio.Localidad;
import dominio.Provincia;
import negocio.AlumnoNegocio;
import negocio.LocalidadNegocio;
import negocio.ProvinciaNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

/**
 * Servlet implementation class ServletAltaAlumnos
 */
@WebServlet("/ServletAltaAlumnos")
public class ServletAltaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProvinciaNegocio provinciaNeg = new ProvinciaNegocioImpl();
	LocalidadNegocio localidadNeg = new LocalidadNegocioImpl();
	AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();

	public ServletAltaAlumnos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Provincia> provincias = provinciaNeg.readall();
			request.setAttribute("ListaProvincias", provincias);

			List<Localidad> localidades = localidadNeg.readall();
			request.setAttribute("ListaLocalidades", localidades);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaAlumno.jsp");
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

			Alumno alumno = cargarPersona(request);
			alumnoNeg.insert(alumno);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Alumno cargarPersona(HttpServletRequest request) {
		Alumno alumno = new Alumno();
		alumno.setDni(Integer.parseInt(request.getParameter("dni")));
		alumno.setNombre(request.getParameter("nombre"));
		alumno.setApellido(request.getParameter("apellido"));
		alumno.setFechaNacimiento(request.getParameter("fechanacimiento"));
		alumno.setEmail(request.getParameter("email"));
		alumno.setDireccion(request.getParameter("direccion"));
		alumno.setIDLocalidad(request.getParameter("localidad"));
		alumno.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		alumno.setActivo(Boolean.getBoolean(request.getParameter("activo")));

		return alumno;
	}
}
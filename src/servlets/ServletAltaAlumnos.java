package servlets;

import java.io.IOException;


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
import negocioImpl.AlumnoNegocioImpl;


/**
 * Servlet implementation class ServletAltaAlumnos
 */
@WebServlet("/ServletAltaAlumnos")
public class ServletAltaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAltaAlumnos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AlumnoNegocio alumnoneg = new AlumnoNegocioImpl();
		
		if (request.getParameter("btnAltaAlumno") != null) {
			Alumno alumno = new Alumno();

			alumno.setNombre(request.getParameter("nombre"));
			alumno.setApellido(request.getParameter("apellido"));
			alumno.setDni(request.getParameter("dni"));
			alumno.setFechaNacimiento(request.getParameter("fechanacimiento").toString());
			alumno.setEmail(request.getParameter("email"));
			alumno.setTelefono(request.getParameter("telefono"));
			alumno.setIDProvincia(request.getParameter("slctProvincia"));
			alumno.setIDLocalidad(request.getParameter("slctLocalidad"));
			alumno.setDireccion(request.getParameter("direccion"));
			
			boolean agrego = alumnoneg.insert(alumno);

			request.setAttribute("agrego", agrego);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaAlumno.jsp");
			rd.forward(request, response);
		}

	}

}
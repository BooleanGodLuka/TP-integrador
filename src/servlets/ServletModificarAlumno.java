package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Alumno;
import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;

/**
 * Servlet implementation class ServletModificarAlumno
 */
@WebServlet("/ServletModificarAlumno")
public class ServletModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();
	
	public ServletModificarAlumno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Alumno alumno = new Alumno();
			cargarAlumno(alumno, request);
			
			request.setAttribute("Alumno", alumno);

			RequestDispatcher rd = request.getRequestDispatcher("Aministrador_ModificarAlumno.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Alumno alumno = new Alumno();
			cargarAlumno(alumno, request);
			alumnoNeg.insert(alumno);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ListarAlumnos.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarAlumno(Alumno alumno, HttpServletRequest request) {
		alumno.setLegajo(Integer.parseInt(request.getParameter("legajo")));
		alumno.setDni(Integer.parseInt(request.getParameter("dni")));
		alumno.setNombre(request.getParameter("nombre"));
		alumno.setApellido(request.getParameter("apellido"));
		alumno.setFechaNacimiento(request.getParameter("fechanacimiento"));
		alumno.setEmail(request.getParameter("email"));
		alumno.setDireccion(request.getParameter("direccion"));
		alumno.setIDLocalidad(request.getParameter("localidad"));
		alumno.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		alumno.setActivo(Boolean.getBoolean(request.getParameter("activo")));
	}

}

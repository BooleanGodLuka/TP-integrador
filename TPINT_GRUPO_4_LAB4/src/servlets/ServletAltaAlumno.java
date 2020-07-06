package servlets;

import java.io.IOException;
import java.util.Date;
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

@WebServlet(name = "ServletAltaAlumno", urlPatterns = { "/ServletAltaAlumno" })
public class ServletAltaAlumno extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProvinciaNegocio provinciaNeg = new ProvinciaNegocioImpl();
	LocalidadNegocio localidadNeg = new LocalidadNegocioImpl();
	AlumnoNegocio alumNeg = new AlumnoNegocioImpl();

	public ServletAltaAlumno() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("Param") != null) {
				List<Provincia> provincias = provinciaNeg.readall();
				request.setAttribute("ListaProvincias", provincias);
				listLocalidades(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO la idea era cargar el combobox mandando un form por post... al apretar un boton, no se como hacerlo en "onchange="
		//int idProvincia = Integer.parseInt(request.getParameter("idprovincia"));
		//request.setAttribute("selectedProvId", idProvincia);
		
		//TODO así que ahora envía los datos del alumno al server.
		try {
			if (request.getParameter("btnAltaAlumno") != null) {
				int dni = Integer.parseInt(request.getParameter("dni"));
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String fnacimiento = request.getParameter("fechanacimiento");
				String email = request.getParameter("email");
				String direccion = request.getParameter("direccion");
				String idlocalidad = request.getParameter("localidad");
				//int telefono = Integer.parseInt(request.getParameter("telefono"));
				Alumno alumno = new Alumno (0, dni, nombre, apellido, fnacimiento, email, direccion, idlocalidad/*, telefono*/);
				alumNeg.insert(alumno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listLocalidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		try {
			if (request.getParameter("Param") != null) {
				List<Provincia> provincias = provinciaNeg.readall();
				request.setAttribute("ListaProvincias", provincias);
				
				List<Localidad> localidades = localidadNeg.readall();
				request.setAttribute("ListaLocalidades", localidades);

				RequestDispatcher rd = request.getRequestDispatcher("administrador/Altas/Administrador_AltaAlumno.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

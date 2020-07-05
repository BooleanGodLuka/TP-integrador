package servlets;

import java.io.IOException;
import java.util.List;
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

@WebServlet(name = "ServletAltaAlumno", urlPatterns = { "/ServletAltaAlumno" })
public class ServletAltaAlumno extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProvinciaNegocio provinciaNeg = new ProvinciaNegocioImpl();
	LocalidadNegocio localidadNeg = new LocalidadNegocioImpl();

	public ServletAltaAlumno() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}

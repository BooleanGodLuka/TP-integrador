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
import negocio.LocalidadNegocio;
import negocioImpl.LocalidadNegocioImpl;

@WebServlet(name = "ServletAltaAlumno", urlPatterns = { "/ServletAltaAlumno" })
public class ServletAltaAlumno extends HttpServlet {

	private static final long serialVersionUID = 1L;
	LocalidadNegocio lneg = new LocalidadNegocioImpl();

	public ServletAltaAlumno() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String aux="ejemplo";
		aux+="s";
		try {
			if (request.getParameter("Param") != null) {
				List<Localidad> localidades = lneg.readall();

				//request.setAttribute("ListaProvincias", provincias);
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

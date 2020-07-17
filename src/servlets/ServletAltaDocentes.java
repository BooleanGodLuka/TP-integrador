package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Docente;
import dominio.Localidad;
import dominio.Usuario;
import negocio.DocenteNegocio;
import negocio.UsuarioNegocio;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

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
		UsuarioNegocio usneg = new UsuarioNegocioImpl();

		if (request.getParameter("btnAltaDocente") != null) {
			Docente docente = new Docente();
			Usuario usuario = new Usuario();

			docente.setNombre(request.getParameter("nombre"));
			docente.setApellido(request.getParameter("apellido"));
			docente.setDni(request.getParameter("dni"));
			docente.setFechaNacimiento(request.getParameter("fechanacimiento").toString());
			docente.setEmail(request.getParameter("email"));
			docente.setTelefono(request.getParameter("telefono"));
			docente.setIDLocalidad(request.getParameter("slctLocalidad"));
			docente.setDireccion(request.getParameter("direccion"));

			boolean agrego = docneg.insert(docente);
			
			///nususario
			
			//usuario.setIDDocente(request.getParameter(""));
			
			usneg.insert(usuario);

			request.setAttribute("agrego", agrego);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaDocente.jsp");
			rd.forward(request, response);

		}

	}

}

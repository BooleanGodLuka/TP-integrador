package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Docente;
import dominio.Localidad;
import dominio.Provincia;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

/**
 * Servlet implementation class ServletModificarDocente
 */
@WebServlet("/ServletModificarDocente")
public class ServletModificarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Docente doc = new Docente();
		DocenteNegocioImpl docdao = new DocenteNegocioImpl();
		LocalidadNegocioImpl locdao = new LocalidadNegocioImpl();
		ProvinciaNegocioImpl provdao = new ProvinciaNegocioImpl();
		
		
		if (request.getParameter("btn_EliminarDocente") != null) {
			String id = request.getParameter("ID_Docente");
			docdao.delete(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		
		
		
		}else if (request.getParameter("btn_ModDocente") != null) {
			doc.setActivo(true);
			doc.setApellido(request.getParameter("Apellido_Docente"));
			doc.setDireccion(request.getParameter("Direccion_Docente"));
			doc.setDni(request.getParameter("DNI_Docente"));
			doc.setEmail(request.getParameter("Email_Docente"));
			doc.setLegajo(Integer.parseInt(request.getParameter("ID_Docente")));
			doc.setNombre(request.getParameter("Nombre_Docente"));
			doc.setTelefono(request.getParameter("Telefono_Docente"));
			doc.setFechaNacimiento(request.getParameter("a�o") + "-" + request.getParameter("mes") + "-" + request.getParameter("dia"));
			doc.setIDLocalidad(request.getParameter("localidad"));
			
			docdao.update(doc);
			
			request.setAttribute("docente", doc);
			
			ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			provincias = (ArrayList<Provincia>) provdao.readall();
			request.setAttribute("provincias", provincias);
			
			ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			localidades = (ArrayList<Localidad>) locdao.readall();
			request.setAttribute("localidades", localidades);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarDocente.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		
		if (request.getParameter("btn_ModificarDocente") != null) {
			doc.igualar(docdao.readall(" WHERE id=" + request.getParameter("id_doc")).get(0));
			
			request.setAttribute("docente", doc);
			
			ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			provincias = (ArrayList<Provincia>) provdao.readall();
			request.setAttribute("provincias", provincias);
			
			ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			localidades = (ArrayList<Localidad>) locdao.readall();
			request.setAttribute("localidades", localidades);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarDocente.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

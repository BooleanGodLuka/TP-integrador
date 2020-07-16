package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
import negocioImpl.LocalidadNegocioImpl;
import negocioImpl.ProvinciaNegocioImpl;

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
		Alumno al = new Alumno();
		AlumnoNegocioImpl aldao = new AlumnoNegocioImpl();
		ProvinciaNegocioImpl prodao = new ProvinciaNegocioImpl();
		LocalidadNegocioImpl locdao = new LocalidadNegocioImpl();
		
		
		if (request.getParameter("btn_ModificarAlumno") != null) {
		
			String id = request.getParameter("id_alumno");
			al.igualar(aldao.readall(id).get(0));
			request.setAttribute("alumno", al);
			
			ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			provincias = (ArrayList<Provincia>) prodao.readall();
			request.setAttribute("provincias", provincias);
			
			ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			localidades = (ArrayList<Localidad>) locdao.readall();
			request.setAttribute("localidades", localidades);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarAlumno.jsp");
			rd.forward(request, response);

		}
		
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Alumno alumno = new Alumno();
			//cargarAlumno(alumno, request);
			alumnoNeg.insert(alumno);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

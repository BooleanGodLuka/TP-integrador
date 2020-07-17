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
import negocio.ProvinciaNegocio;
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
		
		ProvinciaNegocio provneg = new ProvinciaNegocioImpl();

		ArrayList<Provincia> listProv = provneg.readall();

		request.setAttribute("ListaProvincias", listProv);
		
		if (request.getParameter("btn_EliminarAlumno") != null) {	//Si entra al boton de eliminar
			String id_alumno = request.getParameter("id");
			aldao.delete(id_alumno);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		
		
		}else if (request.getParameter("btn_ModAlumno") != null) {	//Si entra al boton de modificar
			al.setActivo(true);
			al.setApellido(request.getParameter("apellido"));
			al.setDireccion(request.getParameter("direccion"));
			al.setDni(request.getParameter("dni"));
			al.setEmail(request.getParameter("email"));
			al.setFechaNacimiento(request.getParameter("fechanacimiento").toString());
			al.setLegajo(Integer.parseInt(request.getParameter("id")));
			al.setNombre(request.getParameter("nombre"));
			al.setTelefono(request.getParameter("telefono"));
			al.setIDLocalidad(request.getParameter("slctLocalidad"));
			al.setIDProvincia(request.getParameter("slctProvincia"));
			
			
			boolean temp= aldao.update(al);
			
			ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			provincias = (ArrayList<Provincia>) prodao.readall();
			request.setAttribute("provincias", provincias);
			
			ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			localidades = (ArrayList<Localidad>) locdao.readall();
			request.setAttribute("localidades", localidades);
			
			request.setAttribute("alumno", al);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarAlumno.jsp");
			rd.forward(request, response);

			
		}else if (request.getParameter("btn_ModificarAlumno") != null) {	//Si entra a la pantalla por el listar cursos
		
			String id = request.getParameter("id_alumno");
			al.igualar(aldao.readall("id="+id).get(0));
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
		// TODO Auto-generated method stub
				doGet(request, response);
	}


}

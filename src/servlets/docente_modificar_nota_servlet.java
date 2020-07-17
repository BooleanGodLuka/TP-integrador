package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.AlumnoDaoImpl;
import dominio.Alumno;
import dominio.AlumnoXCurso;
import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.AlumnoXCursoNegocioImpl;
import negocioImpl.CursoNegocioImpl;

/**
 * Servlet implementation class docente_modificar_nota_servlet
 */
@WebServlet("/docente_modificar_nota_servlet")
public class docente_modificar_nota_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public docente_modificar_nota_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		CursoNegocioImpl cudao = new CursoNegocioImpl();
		AlumnoXCursoNegocioImpl aldao = new AlumnoXCursoNegocioImpl();
		ArrayList<AlumnoXCurso> lista = aldao.leer_alumnoXcurso(Integer.parseInt(request.getParameter("id_curso")));
		AlumnoNegocio al = new AlumnoNegocioImpl();

		
		if (request.getParameter("btn_guardar") != null) {
			AlumnoXCurso axc = new AlumnoXCurso();
			
			for (int i = 0; i < lista.size(); i++) {
				axc.igualar(lista.get(i));

				axc.setNota1(Integer.parseInt(request.getParameter("nota1_" + axc.getAlumno().getLegajo())));
				axc.setNota2(Integer.parseInt(request.getParameter("nota2_" + axc.getAlumno().getLegajo())));
				axc.setNota3(Integer.parseInt(request.getParameter("nota3_" + axc.getAlumno().getLegajo())));
				axc.setNota4(Integer.parseInt(request.getParameter("nota4_" + axc.getAlumno().getLegajo())));
				axc.setRegularidad(request.getParameter("Estado"+ axc.getAlumno().getLegajo()));
				axc.setAprobado(Boolean.parseBoolean(request.getParameter("aprobacion_"+axc.getAlumno().getLegajo())));
				
				aldao.actualizar_alumnoXcurso(axc);
				//lista.set(i, axc);
			}

			lista = null;
			lista =aldao.leer_alumnoXcurso(Integer.parseInt(request.getParameter("id_curso")));
			
			
			 
			for (int i = 0; i < lista.size(); i++) {
				axc = new AlumnoXCurso(lista.get(i));
				if (al.readall(" id=" + axc.getAlumno().getLegajo()) != null) {
				Alumno cursante = new Alumno((Alumno) al.readall(" id=" + axc.getAlumno().getLegajo()).get(0));
				axc.setAlumno(cursante);

					lista.set(i, axc);
			

				}
			}
			request.setAttribute("lista_alumnos", lista);

			request.setAttribute("id_curso", request.getParameter("id_curso"));
					
			
			
			
		}else if (request.getParameter("btn_alumnos") != null) {

			
			
			AlumnoXCurso axc;
			ArrayList<AlumnoXCurso> lista_final = new ArrayList<AlumnoXCurso>();
			 
			for (int i = 0; i < lista.size(); i++) {
				axc = new AlumnoXCurso(lista.get(i));
				if (al.readall(" id=" + axc.getAlumno().getLegajo()) != null) {
				Alumno cursante = new Alumno((Alumno) al.readall(" id=" + axc.getAlumno().getLegajo()).get(0));
				axc.setAlumno(cursante);
				/*axc.getAlumno().setActivo(cursante.getActivo());
				axc.getAlumno().setApellido(cursante.getApellido());
				axc.getAlumno().setDireccion(cursante.getDireccion());
				axc.getAlumno().setDni(cursante.getDni());
				axc.getAlumno().setEmail(cursante.getEmail());
				axc.getAlumno().setFechaNacimiento(cursante.getFechaNacimiento());
				axc.getAlumno().setIDLocalidad(cursante.getIDLocalidad());
				axc.getAlumno().setIDProvincia(cursante.getIDProvincia());
				axc.getAlumno().setLegajo(cursante.getLegajo());
				axc.getAlumno().setNombre(cursante.getNombre());
				axc.getAlumno().setTelefono(cursante.getTelefono());*/

					lista.set(i, axc);
				//lista_final.add(axc);

				}
			}
		
			request.setAttribute("lista_alumnos", lista);
			//request.setAttribute("lista_alumnos", lista_final);

		
		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Docente_ModificarNotas.jsp");
		rd.forward(request, response);
	
		

	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		doGet(request, response);
	}

}

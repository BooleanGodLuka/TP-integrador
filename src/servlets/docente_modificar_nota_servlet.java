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

		/*if (request.getParameter("btn_guardar") != null) {
			ArrayList<AlumnoXCurso> lis = cudao.leer_alumnoXcurso(Integer.parseInt(request.getParameter("id_curso")));
			ArrayList<AlumnoXCurso> temp = lis;

			for (AlumnoXCurso axc : lis) {
				axc.setNota1(Integer.parseInt(request.getParameter("nota1_" + axc.getAlumno().getLegajo())));
				axc.setNota1(Integer.parseInt(request.getParameter("nota2_" + axc.getAlumno().getLegajo())));
				axc.setNota1(Integer.parseInt(request.getParameter("nota3_" + axc.getAlumno().getLegajo())));
				axc.setNota1(Integer.parseInt(request.getParameter("nota4_" + axc.getAlumno().getLegajo())));

				temp.add(axc);
				cudao.actualizar_alumnoXcurso(axc);
			}

			request.setAttribute("lista_alumnos", temp);

			RequestDispatcher rd = request.getRequestDispatcher("Docente/Docente_ModificarNotas.jsp");
			rd.forward(request, response);

		}*/

		if (request.getParameter("btn_alumnos") != null) {
			AlumnoNegocio al = new AlumnoNegocioImpl();
			
			ArrayList<AlumnoXCurso> lista = aldao.leer_alumnoXcurso(Integer.parseInt(request.getParameter("id_curso")));
			ArrayList<AlumnoXCurso> lista_final = new ArrayList<AlumnoXCurso>();
			int cont =0;
			
			AlumnoXCurso axc = new AlumnoXCurso();
			
			 
			for (int i = 0; i < lista.size(); i++) {
				axc.igualar(lista.get(i));
				if (al.readall(" id=" + axc.getAlumno().getLegajo()) != null) {
				Alumno cursante = new Alumno((Alumno) al.readall(" id=" + axc.getAlumno().getLegajo()).get(0));
				axc.setAlumno(cursante);
				//if (cursante.getActivo()) {
					
					/*lista_final.add(cont,axc);
					cont ++;*/
					lista.set(i+1, axc);
					//}
				}
			}
		
			request.setAttribute("lista_alumnos", lista);
			//request.setAttribute("lista_alumnos", lista_final);

			RequestDispatcher rd = request.getRequestDispatcher("Docente_ModificarNotas.jsp");
			rd.forward(request, response);
		
		
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

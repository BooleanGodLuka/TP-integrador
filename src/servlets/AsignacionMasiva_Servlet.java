package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Alumno;
import dominio.Provincia;
import dominio.alumnoXcurso;
import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursoNegocioImpl;

/**
 * Servlet implementation class AsignacionMasiva_Servlet
 */
@WebServlet("/AsignacionMasiva_Servlet")
public class AsignacionMasiva_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AlumnoNegocio alumnoNeg = new AlumnoNegocioImpl();

	public AsignacionMasiva_Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("btnAltaCurso") != null) {
				List<Alumno> provincias = alumnoNeg.readall();
				request.setAttribute("lista_alumnos", provincias);

				RequestDispatcher rd = request.getRequestDispatcher("Administrador_AsignacionMasiva.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btn_cargar") != null) {

			String[] alumnos_seleccionados = request.getParameterValues("seleccionado");
			ArrayList<Alumno> lista_alumnos = new ArrayList<Alumno>();
			lista_alumnos = (ArrayList<Alumno>) request.getAttribute("lista_alumnos");
			boolean bandera;

			CursoNegocioImpl cudao = new CursoNegocioImpl();

			for (Alumno al : lista_alumnos) {
				bandera = true;

				for (String id : alumnos_seleccionados) {
					if (Integer.toString(al.getLegajo()) == id) {
						bandera = false;
					}
				}
				if (bandera) {
					lista_alumnos.remove(al);
				}

			}

			int id_curso = Integer.parseInt(cudao.leer_ultimo_curso_id());
			alumnoXcurso cursante;
			for (Alumno alu : lista_alumnos) {
				cursante = new alumnoXcurso();
				cursante.setAlumno(alu);
				cursante.setId_curso(id_curso);
				cursante.setNota1(0);
				cursante.setNota2(0);
				cursante.setNota3(0);
				cursante.setNota4(0);
				cursante.setRegularidad("Regular");
				cudao.insert_alumnoXcurso(cursante);
			}

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("cursito") != null) {

			ArrayList<Alumno> lista_alumnos = new ArrayList<Alumno>();
			AlumnoNegocioImpl aldao = new AlumnoNegocioImpl();
			lista_alumnos = aldao.readall();

			for (Alumno al : lista_alumnos) {
				if (al.getActivo() != true) {
					lista_alumnos.remove(al);
				}
			}
			request.setAttribute("lista_alumnos", lista_alumnos);
			RequestDispatcher rd = request.getRequestDispatcher("Docente_ListarCursos.jsp");
			rd.forward(request, response);

		}

		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dominio.Curso;
import dominio.Docente;
import dominio.Materia;
import negocio.CursoNegocio;
import negocio.DocenteNegocio;
import negocio.MateriaNegocio;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

@WebServlet("/ServletAltaCursos")
public class ServletAltaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MateriaNegocio materiaNeg = new MateriaNegocioImpl();
	DocenteNegocio docenteNeg = new DocenteNegocioImpl();
	CursoNegocio cursoNeg = new CursoNegocioImpl();

	public ServletAltaCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Materia> materias = materiaNeg.readall();
			request.setAttribute("ListaMaterias", materias);

			List<Docente> docentes = docenteNeg.readall();
			request.setAttribute("ListaDocentes", docentes);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaCurso.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Curso curso = new Curso();
			
			cargarCurso(curso, request);
			
			cursoNeg.insert(curso);
			
			JOptionPane.showMessageDialog(null, "Curso agregado exitosamente!");

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaCurso.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarCurso(Curso curso, HttpServletRequest request) {
		curso.getMateria().setID(Integer.parseInt(request.getParameter("materia")));
		curso.setCuatrimestre(Integer.parseInt(request.getParameter("cuatrimestre")));
		curso.setAnio(Integer.parseInt(request.getParameter("anio")));
		curso.getDocente().setLegajo(Integer.parseInt(request.getParameter("docente")));
	}

}

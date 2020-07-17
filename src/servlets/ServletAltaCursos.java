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
		Curso cur = new Curso();
		CursoNegocioImpl curdao = new CursoNegocioImpl();
		
		
		if (request.getParameter("btnAltaCurso") != null) {
		cur.setAnio(request.getParameter("anio"));
		cur.setCuatrimestre(request.getParameter("cuatrimestre"));
		cur.getDocente().setLegajo(Integer.parseInt(request.getParameter("docente")));
		cur.getMateria().setID(Integer.parseInt(request.getParameter("materia")));
			
		boolean temp =curdao.insert(cur);
		
		if (temp) {
			int id_cur = curdao.leer_ultimo_curso_id().get(0).getID();
			request.setAttribute("id_curso", id_cur);
			
			RequestDispatcher rd = request.getRequestDispatcher("AsignacionMasiva_Servlet");
			rd.forward(request, response);
		}
		
			
		}else {

			ArrayList<Materia> materias = materiaNeg.readall();
			request.setAttribute("ListaMaterias", materias);

			ArrayList<Docente> docentes = docenteNeg.readall();
			request.setAttribute("ListaDocentes", docentes);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_AltaCurso.jsp");
			rd.forward(request, response);

		}
		
		
		

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}

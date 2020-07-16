package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Curso;
import dominio.Docente;
import dominio.Materia;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

/**
 * Servlet implementation class ServletModificarCurso
 */
@WebServlet("/ServletModificarCurso")
public class ServletModificarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Curso cur = new Curso();
		CursoNegocioImpl curdao = new CursoNegocioImpl();
		MateriaNegocioImpl matdao = new MateriaNegocioImpl();
		DocenteNegocioImpl docdao = new DocenteNegocioImpl();
		
		if (request.getParameter("btn_EliminarCurso")!= null) {
			String id =(request.getParameter("ID_Curso"));
			curdao.delete(Integer.parseInt(id));
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		
		
		}else if(request.getParameter("btn_ModificarCurso") !=null) {
			
			cur.setAnio(request.getParameter("A�o"));
			cur.setCuatrimestre(request.getParameter("Cuatrimestre"));
			cur.getDocente().setLegajo(Integer.parseInt(request.getParameter("Docente")));
			cur.setID(Integer.parseInt(request.getParameter("ID_Curso")));
			cur.getMateria().setID(Integer.parseInt(request.getParameter("Materia")));
			
			curdao.update(cur);
			
			request.setAttribute("curso", cur);
			
			ArrayList<Materia> materias = new ArrayList<Materia>();
			materias = matdao.readall();
			request.setAttribute("materias", materias);
			
			ArrayList<Docente> profesores = new ArrayList<Docente>();
			profesores = docdao.readall();
			request.setAttribute("docentes", profesores);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarCurso.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		if (request.getParameter("id") != null) {
		
			cur.igualar(curdao.readall("id="+request.getParameter("id")).get(0));
			request.setAttribute("curso", cur);
			
			ArrayList<Materia> materias = new ArrayList<Materia>();
			materias = matdao.readall();
			request.setAttribute("materias", materias);
			
			ArrayList<Docente> profesores = new ArrayList<Docente>();
			profesores = docdao.readall();
			request.setAttribute("docentes", profesores);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarCurso.jsp");
			rd.forward(request, response);

					
					
			
		}
		
		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

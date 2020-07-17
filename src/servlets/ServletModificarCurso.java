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
import dominio.AlumnoXCurso;
import dominio.Curso;
import dominio.Docente;
import dominio.Materia;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.AlumnoXCursoNegocioImpl;
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
		
		
		}else if(request.getParameter("btn_ModCurso") !=null) {
			
			cur.setAnio(request.getParameter("Anio"));
			cur.setCuatrimestre(request.getParameter("Cuatrimestre"));
			cur.getDocente().setLegajo(Integer.parseInt(request.getParameter("Docente")));
			cur.setID(Integer.parseInt(request.getParameter("ID_Curso")));
			cur.getMateria().setID(Integer.parseInt(request.getParameter("Materia")));
			
			boolean temp =curdao.update(cur);
			
			request.setAttribute("curso", cur);
			
			ArrayList<Materia> materias = new ArrayList<Materia>();
			materias = matdao.readall();
			request.setAttribute("materias", materias);
			
			ArrayList<Docente> profesores = new ArrayList<Docente>();
			profesores = docdao.readall();
			request.setAttribute("docentes", profesores);

			RequestDispatcher rd = request.getRequestDispatcher("Administrador_ModificarCurso.jsp");
			rd.forward(request, response);
			
			
		}else if (request.getParameter("btn_AgregarAlumn") != null) {
			
			AlumnoNegocioImpl aldao = new AlumnoNegocioImpl();
			AlumnoXCurso cursante = new AlumnoXCurso();
			int id_curso = Integer.parseInt(request.getParameter("idCurso"));
			Alumno al = new Alumno();
			AlumnoXCursoNegocioImpl alcurdao = new AlumnoXCursoNegocioImpl();
			String id = request.getParameter("legajo_alum");
			al.igualar(aldao.readall("id="+id).get(0));
			//al.igualar(aldao.read(id)); 
			
			cursante.setAlumno(al);
			cursante.setAprobado(false);
			cursante.getCurso().setID(id_curso);
			cursante.setRegularidad("Regular");
			cursante.setNota1(0);
			cursante.setNota2(0);
			cursante.setNota3(0);
			cursante.setNota4(0);
			boolean temp = alcurdao.insert_alumnoXcurso(cursante);
			
			
			cur.igualar(curdao.readall("id="+id_curso).get(0));
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
		
		
		if (request.getParameter("btn_ModificarCurso") != null) {
		
			String id = request.getParameter("idCurso");
			cur.igualar(curdao.readall("id="+id).get(0));
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

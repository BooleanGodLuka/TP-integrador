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
import dominio.alumnoXcurso;
import negocio.AlumnoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursosNegocioImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
			
		CursosNegocioImpl cudao = new CursosNegocioImpl();
		
		if (request.getParameter("btn_guardar")!= null) {
			ArrayList<alumnoXcurso> lis = cudao.leer_alumnoXcurso(request.getParameter("id_curso")) ;
			ArrayList<alumnoXcurso> temp = lis;
			
			for (alumnoXcurso a : lis) {
				a.setNota1(Integer.parseInt(request.getParameter("nota1_"+a.getId_alumno())) );
				a.setNota1(Integer.parseInt(request.getParameter("nota2_"+a.getId_alumno())) );
				a.setNota1(Integer.parseInt(request.getParameter("nota3_"+a.getId_alumno())) );
				a.setNota1(Integer.parseInt(request.getParameter("nota4_"+a.getId_alumno())) );
				
				temp.add(a);
				cudao.actualizar_alumnoXcurso(a);
			}
			
			request.setAttribute("lista_alumnos", temp);
			
			
			RequestDispatcher rd =request.getRequestDispatcher("Docente/Docente_ModificarNotas.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		if (request.getParameter("btn_alumnos") != null) {
			AlumnoNegocio al = new AlumnoNegocioImpl();
			ArrayList<alumnoXcurso> lista = cudao.leer_alumnoXcurso(request.getParameter("id_curso")) ;
			
			for (alumnoXcurso alumno: lista) {
				 Alumno cursante = (Alumno) al.readall(" WHERE idalumno=" + alumno.getId_alumno()).get(0);
				 
				 
				 
				 if (!cursante.getActivo()) {
					 lista.remove(lista.indexOf(cursante));
				 }
			}
			
			
			request.setAttribute("lista_alumnos", lista);
			
			RequestDispatcher rd =request.getRequestDispatcher("Docente/Docente_ModificarNotas.jsp");
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

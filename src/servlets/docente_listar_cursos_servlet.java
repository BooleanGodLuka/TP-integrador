package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dominio.Curso;
import dominio.Docente;
import dominio.Usuario;
import negocioImpl.CursosNegocioImpl;

/**
 * Servlet implementation class docente_listar_cursos_servlet
 */
@WebServlet("/docente_listar_cursos_servlet")
public class docente_listar_cursos_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public docente_listar_cursos_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		
		//String consulta = "iddocente = " + usuario.getIddocente();
		String consulta = "iddocente = 4";
		
		
		
		CursosNegocioImpl cudao = new CursosNegocioImpl();
				
		
		ArrayList<Curso> lista = cudao.leer_todo_curso_consigna(consulta);
		
		/*Curso cur = new Curso();
		String materia="";
		for (int i=0; i<lista.size();i++) {
			cur.igualar(lista.get(i));
			materia = cudao.leer_materia(Integer.toString(cur.getId_materia()));
			cur.setNombre_materia(materia);
			lista.set(i, cur);
			System.out.println(lista.get(i).getNombre_materia());
		}*/
		
		request.setAttribute("lista_cursos", lista);
		
		RequestDispatcher rd =request.getRequestDispatcher("Docente_ListarCursos.jsp");
		rd.forward(request, response);
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

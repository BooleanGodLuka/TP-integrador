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
import negocioImpl.CursoNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

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
		
		String consulta = "iddocente = " + usuario.getIddocente();
		
		
		CursoNegocioImpl cursoNegocio = new CursoNegocioImpl();
		MateriaNegocioImpl matdao = new MateriaNegocioImpl();
				
		
		ArrayList<Curso> lista = cursoNegocio.readall(consulta);
		
		Curso cur ;
		String materia="";
		for (int i=0; i<lista.size();i++) {
			cur = new Curso(lista.get(i));
			materia = matdao.read(cur.getMateria().getID()).getNombre();
			cur.getMateria().setNombre(materia);
			lista.set(i, cur);
			System.out.println(lista.get(i).getMateria().getNombre());
		}
		
		request.setAttribute("lista_cursos", lista);
		
		RequestDispatcher rd =request.getRequestDispatcher("Docente_ListarCursos.jsp");
		rd.forward(request, response);
		
		//ahre
		
		
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

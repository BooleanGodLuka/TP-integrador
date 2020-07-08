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
import dominio.Reporte;
import negocio.CursosNegocio;
import negocio.DocenteNegocio;
import negocioImpl.CursosNegocioImpl;
import negocioImpl.DocenteNegocioImpl;

/**
 * Servlet implementation class reporte_servlet
 */
@WebServlet("/reporte_servlet")
public class reporte_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reporte_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Reporte> lista = new ArrayList<Reporte>();
		Reporte rep = new Reporte();
		CursosNegocio cudao = new CursosNegocioImpl();
		
		
		ArrayList<Curso> cursos = cudao.leer_todo_curso();
		
		for (Curso cur : cursos) {
			rep.setCuatri(cur.getCuatrimestre());
			rep.setAño(cur.getAño());
			rep.setDocente(buscar_docente(Integer.toString(cur.getId_docente())));
			rep.setCant_alumn(cudao.calcular_cant_alumnXcurso(Integer.toString(cur.getId())));
			rep.setCant_aprob(cudao.calcular_cant_alumnXcurso_aprob(Integer.toString(cur.getId())));
			rep.setCant_desaprob(cudao.calcular_cant_alumnXcurso_desap(Integer.toString(cur.getId())));
			rep.cargar_porcentaje();
			rep.setMateria(cudao.leer_materia(Integer.toString(cur.getId_materia())));
			
			lista.add(rep);
		}
		
		request.setAttribute("lista_reportes", lista);
		
		RequestDispatcher rd =request.getRequestDispatcher("administrador/Administrador_Reporte");
		rd.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	private String buscar_docente (String iddocente) {
		DocenteNegocio docdao = new DocenteNegocioImpl();
		
		Docente doc = docdao.readall(" WHERE id=" + iddocente).get(0);
		
		String nombre = doc.getNombre() + doc.getApellido();
		
		return nombre;
	}
	
	
}

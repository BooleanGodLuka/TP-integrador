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
import negocio.CursoNegocio;
import negocio.DocenteNegocio;
import negocioImpl.CursoNegocioImpl;
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
		CursoNegocio cursoNeg = new CursoNegocioImpl();
		
		
		ArrayList<Curso> cursos = cursoNeg.readall();
		
		for (Curso cur : cursos) {
			rep.getCurso().setCuatrimestre(cur.getCuatrimestre());
			rep.getCurso().setAnio(cur.getAnio());
			rep.setCant_alumn(cursoNeg.calcular_cant_alumnXcurso(Integer.toString(cur.getID())));
			rep.setCant_aprob(cursoNeg.calcular_cant_alumnXcurso_aprob(Integer.toString(cur.getID())));
			rep.setCant_desaprob(cursoNeg.calcular_cant_alumnXcurso_desap(Integer.toString(cur.getID())));
			rep.cargar_porcentaje();
			//TODO Dittu: no se que se supone que hay que mostrar en la linea a de abajo, si me explicas yo lo arreglo
			rep.getCurso().getMateria().setID(cursoNeg.leer_materia(cur.getMateria().getID()));
			
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
		DocenteNegocio docenteNeg = new DocenteNegocioImpl();
		
		Docente doc = docenteNeg.readall(" WHERE id=" + iddocente).get(0);
		
		String nombre = doc.getNombre() + doc.getApellido();
		
		return nombre;
	}
	
	
}

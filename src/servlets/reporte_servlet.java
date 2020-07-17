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
import dominio.Reporte;
import negocio.CursoNegocio;
import negocio.DocenteNegocio;
import negocioImpl.AlumnoXCursoNegocioImpl;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

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
		Reporte rep;
		CursoNegocio cursoNeg = new CursoNegocioImpl();
		AlumnoXCursoNegocioImpl aldao = new AlumnoXCursoNegocioImpl();
		MateriaNegocioImpl matdao = new MateriaNegocioImpl();
		DocenteNegocioImpl docdao = new DocenteNegocioImpl();
		String consulta ="";
		if (request.getParameter("btn_filtrar") != null) {
			
			String a = request.getParameter("materia");
			
			if (request.getParameter("materia") != "empty") {
				consulta += " idmateria=" + request.getParameter("materia");
			}
			
			String b = request.getParameter("anio");
			
			if (request.getParameter("anio") != "empty") {
				if (consulta == "") {
					consulta += " anio= " + "'" +request.getParameter("anio") +"'";
				}else {
					consulta += " AND anio=" +"'" +  request.getParameter("anio") + "'";
				}
				
			}
			
			String c = request.getParameter("cuatrimestre");
			
			if (request.getParameter("cuatrimestre") != "empty") {
				if (consulta == "") {
					consulta += " cuatrimestre=" +"'" +request.getParameter("cuatrimestre")+"'";
				}else {
					consulta += " AND cuatrimestre="+"'" + request.getParameter("cuatrimestre")+"'";
				}
			}
			
			
		}
		
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		if (consulta == "") {
			cursos = cursoNeg.readall();	
		}else {
			cursos = cursoNeg.readall(consulta);
		}
		
		
		for (Curso cur : cursos) {
			rep = new Reporte();
			rep.getCurso().setAnio(cur.getAnio());
			rep.getCurso().setCuatrimestre(cur.getCuatrimestre());
			rep.getCurso().setID(cur.getID());
			rep.getCurso().setDocente(docdao.readall(" WHERE id=" + cur.getDocente().getLegajo()).get(0));
			rep.getCurso().getMateria().setNombre(matdao.getNombreMateria(cur.getMateria().getID()));
			rep.setCant_alumn(aldao.calcular_cant_alumnXcurso(cur.getID()));
			rep.setCant_aprob(aldao.calcular_cant_alumnXcurso_aprob(cur.getID()));
			rep.setCant_desaprob(aldao.calcular_cant_alumnXcurso_desap(cur.getID()));
			rep.cargar_porcentaje();
			lista.add(rep);
		}
		
		request.setAttribute("lista_reportes", lista);
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias = matdao.readall();
		request.setAttribute("materias", materias);
		
		
		
		RequestDispatcher rd =request.getRequestDispatcher("Administrador_Reporte.jsp");
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

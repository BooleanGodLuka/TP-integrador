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
import negocio.AlumnoXCursoNegocio;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.AlumnoXCursoNegocioImpl;


@WebServlet("/ServletAlumnoXCurso")
public class ServletAlumnoXCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletAlumnoXCurso() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AlumnoXCursoNegocio axcneg = new AlumnoXCursoNegocioImpl();
		
		if(request.getParameter("btn_VerAlumnos") != null)
		{
			
			if(request.getParameter("idCurso") != null) 
			{
				
			AlumnoXCurso axc;
			AlumnoNegocioImpl al = new AlumnoNegocioImpl();
			
			int idcurso = Integer.parseInt(request.getParameter("idCurso"));
			
			ArrayList<AlumnoXCurso> listaAxc = (ArrayList<AlumnoXCurso>) axcneg.leer_alumnoXcurso(idcurso);
			
			for (int i = 0; i < listaAxc.size(); i++) {
				axc = new AlumnoXCurso(listaAxc.get(i));
				if (al.readall(" id=" + axc.getAlumno().getLegajo()) != null) {
				Alumno cursante = new Alumno((Alumno) al.readall(" id=" + axc.getAlumno().getLegajo()).get(0));
				axc.setAlumno(cursante);

				listaAxc.set(i, axc);
			

				}
			}
			
			if(listaAxc.size() != 0) 
			{
				request.setAttribute("listaLlena", 1);
			}
			
			request.setAttribute("listaAxc", listaAxc);
			
			RequestDispatcher rd = request.getRequestDispatcher("Docente_ListarAlumnos.jsp");
			rd.forward(request, response);
			
			}
			
		}	
	}

}

package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Materia;
import negocio.MateriaNegocio;
import negocioImpl.MateriaNegocioImpl;

@WebServlet("/ServletAltaCursos")
public class ServletAltaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MateriaNegocio materiaNeg = new MateriaNegocioImpl();

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
		try {
			if (request.getParameter("Param") != null) {

				List<Materia> materias = materiaNeg.readall();
				request.setAttribute("ListaMaterias", materias);

			}

			RequestDispatcher rd = request.getRequestDispatcher("/Administrador/Alta/Administrador_AltaCursos.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

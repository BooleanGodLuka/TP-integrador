package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.UsuarioDaoImpl;
import dominio.Usuario;

@WebServlet("/Usuario_servlet")
public class Usuario_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Usuario_servlet() {
        super();

    }
    
/*conexion MYSQL credenciales y db name*/
	String host = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String pass = "root";
	String dbName = "db_grupo4_labo4";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		/*Lo que hace el servlet una vez que obtiene el form con metodo POST del login, si el usuario es un docente*/
		int filas=0;
		if (request.getParameter("btnAceptar")!=null)
		{
			String user = request.getParameter("txtUser");
			String pass = request.getParameter("txtPassword");
			
			String query = "SELECT * from usuarios WHERE usuario='"+user+" and clave='"+pass+"'";
			Connection cn = null;			
			try
			{
				cn = DriverManager.getConnection(host+dbName,user,pass);
				Statement st = cn.createStatement();
				filas = st.executeUpdate(query);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			/*
			
			//requestdispatcher
			request.setAttribute("cantFilas", "filas");
			RequestDispatcher rd = request.getRequestDispatcher(/*jsp del home con navbar de docentes );
			rd.forward(request, response);

		*/

	}

																															}
	
}

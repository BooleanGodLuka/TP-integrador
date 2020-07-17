<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.http.HttpSession"%>
<%@page import="dominio.*" %>
<%@page import="negocio.*" %>
<%@page import="negocioImpl.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>

</head>






<body>

   <div>
  <%
      		int idusuario;
  			int iddocente;
  			String nombre = "";
  			String apellido = "";
  			UsuarioNegocio usneg =  new UsuarioNegocioImpl();
	      	HttpSession misession = request.getSession();
      		Usuario usu = new Usuario();
      		usu = (Usuario)misession.getAttribute("Usuario");
      		idusuario = usu.getIDUsuario();
      		iddocente = usu.getIDDocente();
      		nombre = usu.getUsuario();
      		if (idusuario == 1){
   %>
   </div>
  
<div>
<header class="w3-top">
  <div class="navbar">
  <a href="Home.jsp">Home</a>
  <div class="dropdown">
    <button class="dropbtn" style="color: black;" >Alta 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="ServletProvincias?param=1" style="color: black;">Docente</a>
      <a href="ServletAltaCursos" style="color: black;">Curso</a>
      <a href="ServletProvincias?param2=1" style="color: black;">Alumno</a>
    </div>
    </div>
    <div class="dropdown">
    <button class="dropbtn" style="color: black;">Listar 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
    <form action="ServletListarDocentes" method="get">
      <a href="ServletListarDocentes" name="dropdown_ListarDocentes" style="color: black;">Docente</a>
    </form>
    <form action ="ServletListarCurso" method ="get">
      <a href="ServletListarCurso" name="dropdown_ListarCurso" style="color: black;">Curso</a>
      </form>
      <form action="ServletListarAlumnos" method="get">
      <a href="ServletListarAlumnos" name="dropdown_ListarAlumnos" style="color: black;">Alumno</a>
      </form>
    </div>
  </div>
 <form action="reporte_servlet" method="get">
  <a href="reporte_servlet" style="color: white;">Reporte</a>
  </form>
  <a href="login_JSP.jsp">Cerrar Sesion</a>
<div style="text-align: right;color: white; font-size:20px"><%=nombre%></div>
</div>
</header> 
</div>


<%}
      		

      	else {
      		nombre = usneg.getNombreDocente(iddocente);
      		apellido = usneg.getApellidoDocente(iddocente);
      		
%>


<div>
<header class="w3-top">
  <div class="navbar">
  <a href="Home.jsp">Home</a>
  <form action="docente_listar_cursos_servlet" method="get">
  <a href="docente_listar_cursos_servlet">Cursos</a>
  </form>
  <a href="#">Alumnos</a>
  <a href="login_JSP.jsp">Cerrar Sesion</a>
  <div style="text-align: right;color: white; font-size:20px" ><%=nombre%> <%=apellido%></div>
</div>
</header>
</div>
<%

      	}

%>

</body>




</html>
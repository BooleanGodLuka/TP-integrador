<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dominio.*" %>
<%@page import="negocioImpl.*" %>
<%@page import="negocio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Cursos</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style>
#Listados{
  font-family: Verdana, Arial, Helvetica, sans-serif;
  border-collapse: collapse;
}

#Listados td, #Listados th {
  border: 1px solid #ddd;
  padding: 15px;
}

#Listados tr:nth-child(even){background-color: #f2f2f2;}

#Listados tr:hover {background-color: #006666;}

#Listados th {
  padding-top: 13px;
  padding-bottom: 13px;
  text-align: center;
  background-color: #008080;
  color: white;
}

</style>
</head>
<body>

<jsp:include page="Navegacion.jsp"></jsp:include>

<h2 ALIGN="center">LISTADO DE CURSOS</h2>

<div align="center">
			<form action="/action_page.php" method="get">
				<input type="text" name="txtFiltroCriterio" class="textbox" placeholder="Filtrar" style= "width: 500px;">
			    <input type="submit" value="Buscar" style= "width: 100px"/>
			    <h3>Filtrar por:</h3>
				  <input type="radio" id="legajo" name="criterio" value="legajo">
				  <label for="legajo">Legajo</label>
				  <input type="radio" id="nombre" name="criterio" value="nombre">
				  <label for="nombre">Nombre</label>
				  <input type="radio" id="apellido" name="criterio" value="apellido">
				  <label for="apellido">Apellido</label>
    		</form>
		</div>
		<br>
	
	<div align="center">
		<form action="/action_page.php" method="get">
				<select>
				<option value="empty">Materia</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br>
			</select>
			
			<select>
				<option value="empty">Cuatrimestre</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br>
			</select>
			
			<select>
				<option value="empty">A�o</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br><br>
			</select>
		</form>
	</div>
	<br>

<table ALIGN="center" id="Listados" width=100%>

<thead>
<tr>
	<th>Curso</th>
	<th>Materia</th>
	<th>Cuatrimestre</th>
	<th>A�o</th>
	<th>Docente</th>
	<th>Alumnos</th>
	<th>Modificar</th>
</tr>
</thead>

<tbody>
<% 
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	
		MateriaNegocio mneg = new MateriaNegocioImpl();
						  
		DocenteNegocio docneg = new DocenteNegocioImpl();
						  
		if(request.getAttribute("listacur") != null)
		{
			listaCursos = (ArrayList<Curso>)request.getAttribute("listacur");
		}
		
	    if(listaCursos != null)
	  	{	
			for(Curso cur : listaCursos) 
			{
				
	  %>
<tr>

<form action="ServletListarAlumnos" method="get">

<td><%=cur.getID() %> <input type="hidden" name="idCurso" value="<%=cur.getID()%>"> </td> 
<td><%=mneg.getNombreMateria(cur.getMateria().getID())%></td>
<td><%=cur.getCuatrimestre() %></td> 
<td><%=cur.getAnio() %></td> 
<td><%=docneg.getApellidoDocente(cur.getDocente().getLegajo())%></td> 
<td style="text-align:center"> <input type="button" value="Ver Alumnos" name="btn_VerAlumnos"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
<td style="text-align:center"> <input type="button" value="Modificar Curso" name="btn_ModificarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>

</form>

</tr>


<%
			}
		
	  	}


%>

</tbody>

</table>

<p>P�g.</p>
<input type="submit" value="1">

</body>
</html>
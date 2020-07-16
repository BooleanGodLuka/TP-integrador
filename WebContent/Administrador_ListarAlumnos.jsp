<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dominio.*" %>
<%@page import="negocio.*" %>
<%@page import="negocioImpl.*" %>

<head>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listado Alumnos</title>
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

	<h2 align="center">LISTADO DE ALUMNOS</h2>
	
	<div align="center">
			<form action="/ServletFiltrosxCriterio" align="center">
				<input type="text" name="txtFiltroCriterio" class="textbox" placeholder="Filtrar" style= "width: 500px;">
			    <input type="submit" value="Buscar"/>
			    
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
	<form action="/ServletFiltrosxCurso" method="post">
	<h3>Filtro por Curso:
		<select>
			<option value="empty">- Seleccione Curso -</option>
			  <option value="Laboratorio IV">Laboratorio IV</option>
			  <option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
			  <option value="Diseño y Administracion de Base de Datos I">Diseño y Administracion de Base de Datos I</option><br><br>
		</select>
		</h3>
		</form>
	</div>
	<br>

<table align="center" id="Listados" width=100%>

<thead>
 <tr>
    <th>Legajo</th>
    <th>Nombre/s</th>
    <th>Apellido/s</th>
    <th>DNI</th>
    <th>Email</th>
    <th>Fecha de Nacimiento</th>
    <th>Direccion</th>
  	<th>Provincia</th>
    <th>Localidad</th>
    <th>Telefono</th>
   <!-- <th>Regularidad</th>-->
    <th>Modificar</th>
  </tr>
</thead>

<tbody>

	 <% 

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	 
	 	ProvinciaNegocio provneg = new ProvinciaNegocioImpl();
	 	
	 	LocalidadNegocio lneg = new LocalidadNegocioImpl();

		if(request.getAttribute("listaAlum") != null)
		{
			listaAlumnos = (ArrayList<Alumno>)request.getAttribute("listaAlum");
		}
		
	    if(listaAlumnos != null)
	  	{	
			for(Alumno alumno : listaAlumnos) 
			{
				
				if (alumno.getActivo() == true){
	  %>
	
  <tr>

					<form action="ServletModificarAlumno" method="get">
					<td><%=alumno.getLegajo() %></td>	 <input type="hidden" name="id_alumno" value ="<%=alumno.getLegajo()%>">
					<td><%=alumno.getNombre() %></td> 
					<td><%=alumno.getApellido() %></td>
					<td><%=alumno.getDni() %></td> 
					<td><%=alumno.getEmail()%></td>
					<td><%=alumno.getFechaNacimiento()%></td>
					<td><%=alumno.getDireccion()%></td> 
					<td><%=provneg.getNombreProvincia(alumno.getIDLocalidad()) %></td>
					<td><%=lneg.getNombreLocalidad(alumno.getIDLocalidad()) %></td>
					<td><%=alumno.getTelefono() %></td>	
					<td> <input type="submit" value="Modificar Alumno" name="btn_ModificarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
					</form>
					  
					
 </tr>
 
 <%
				}
			}
	  	}			
 %>
  
</tbody>
</table>

<p>Pág.</p>
<input type="submit" value="1">

</body>
</html>
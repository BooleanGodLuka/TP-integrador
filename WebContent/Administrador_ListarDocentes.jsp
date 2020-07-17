<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dominio.*" %>
<%@page import="negocio.*" %>
<%@page import="negocioImpl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Docentes</title>
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

<h2 ALIGN="center">LISTADO DE DOCENTES</h2>

<div align="center">
			<form action="/action_page.php" align="center">
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


<table ALIGN="center" id="Listados" width=100%>


<thead>
 <tr>
 	<th>Legajo</th>
    <th>Nombre/s</th>
    <th>Apellido/s</th>
    <th>DNI</th>
    <th>Email</th>
    <th>Fecha de Nacimiento</th>
    <th>Provincia</th>
    <th>Localidad</th>
    <th>Telefono</th>
    <th>Modificar</th>
  </tr>
</thead>

<tbody>

	 <% 

		ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
						  
		ProvinciaNegocio provneg = new ProvinciaNegocioImpl();
						  
		LocalidadNegocio lneg = new LocalidadNegocioImpl();

		if(request.getAttribute("listaDoc") != null)
		{
			listaDocentes = (ArrayList<Docente>)request.getAttribute("listaDoc");
		}
		
	    if(listaDocentes != null)
	  	{	
			for(Docente docente : listaDocentes) 
			{
				if (docente.getActivo() == true){
	  %>
<tr>
<form action="ServletModificarDocente" method="post"> 

					<td><%=docente.getLegajo() %></td> <input type="hidden" name="id_doc" value="<%=docente.getLegajo()%>">
					<td><%=docente.getNombre() %></td> 
					<td><%=docente.getApellido()%></td>  
					<td><%=docente.getDni()%></td>  
					<td><%=docente.getEmail()%></td> 
					<td><%=docente.getFechaNacimiento()%></td> 
					<td><%=provneg.getNombreProvincia(docente.getIDLocalidad()) %></td>
					<td><%=lneg.getNombreLocalidad(docente.getIDLocalidad()) %></td>
					<td><%=docente.getTelefono() %></td>

<td style="text-align:center"> <input type="submit" value="Modificar Docente" name="btn_ModificarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>

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
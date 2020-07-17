<html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dominio.*" %>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos por Curso</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">



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

<h2 ALIGN="center">Alumnos por Curso</h2>

<table ALIGN="center" id="Listados" width=100%>

<thead>
<tr>
	<th>Legajo</th>
	<th>DNI</th>
	<th>Nombre</th>
	<th>Apellido</th>
	<th>Parcial 1</th>
	<th>Parcial 2</th>
	<th>Recuperatorio 1</th>
	<th>Recuperatorio 2</th>
	<th>Estado</th>
</tr>
</thead>

<tbody>
<% 
ArrayList<AlumnoXCurso> lista = null;

if(request.getAttribute("listaAxc") != null)
{
	lista = (ArrayList<AlumnoXCurso>) request.getAttribute("listaAxc");
}

if(lista != null)
	{	
	for(AlumnoXCurso axc : lista) 
	{
				
	  %>
<tr>  
	<td><%=axc.getAlumno().getLegajo()%> <input type="hidden" name="idAlumno" value="<%=axc.getAlumno().getLegajo()%>"> </td> 
	<td><%=axc.getAlumno().getDni() %> <input type="hidden" name="idCurso" value="<%=axc.getCurso().getID()%>"> </td>   
	<td><%=axc.getAlumno().getNombre() %> </td> 
	<td><%=axc.getAlumno().getApellido() %> </td>
	<td><%=axc.getNota1()%></td>   
	<td><%=axc.getNota2()%></td>    
	<td><%=axc.getNota3()%></td>     
	<td><%=axc.getNota4()%></td>  
	<td><%=axc.getRegularidad()%></td>
	</tr>


<%
			}
		
	  	}


%>

</tbody>

</table>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"  src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"  src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js">
</script>
<script>
  $(document).ready(function(){
    $('#Listados').dataTable();
  });
</script>

</body>
</html>
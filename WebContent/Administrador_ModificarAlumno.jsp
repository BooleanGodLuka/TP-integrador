
<%@page import="dominio.*"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Alumno</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style>

#Modificaciones{
  font-family: Verdana, Arial, Helvetica, sans-serif;
  border-collapse: collapse;
}

#Modificaciones td, #Modificaciones th {
  border: 1px solid #ddd;
  padding: 15px;
}

#Modificaciones tr:nth-child(even){background-color: #f2f2f2;}

#Modificaciones th {
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
  background-color: #7a0607;
  color: white;
}

</style>

</head>
<body>

<jsp:include page="Localidades.jsp"/>
<jsp:include page="Navegacion.jsp"/>

<h2 align="center">MODIFICAR ALUMNO</h2>

<table ALIGN="center" id="Modificaciones" width=80%>
	<thead>
	<tr>
		<th>ID</th>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Fecha de Nacimiento</th>
		<th>Email</th>
		<th>Telefono</th>
		<th>Direccion</th>
	    <th>Provincia</th>
	    <th>Localidad</th>
	    <th>Modificar</th>
	    <th>Eliminar</th>
	</tr>
	</thead>
  
	<tbody>
	<form action="ServletModificarAlumno" method="get">
	<%
		if (request.getAttribute("alumno") != null){
	Alumno al = new Alumno();		
	al.igualar((Alumno)request.getAttribute("alumno"));
	%>
	
	<tr>
	    <td><input type="text" name="id" value="<%=al.getLegajo()%>" readonly></td>
	    <td><input type="text" name="dni" value="<%=al.getDni()%>" maxlength="8" pattern="\d{8}" title="Se requieren 8 digitos." onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))"></td> 
	    <td><input type="text" name="nombre" value="<%=al.getNombre()%>" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))"></td>
	    <td><input type="text" name="apellido" value="<%=al.getApellido()%>" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))"></td>
	    <td><input type="date" name="fechanacimiento" value="<%=al.getFechaNacimiento() %>"></td>
	    <td><input type="email" name="email" value="<%=al.getEmail()%>"></td>
	    <td><input type="text" name="telefono" value="<%=al.getTelefono()%>" maxlength="10" onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))"></td>
	    <td><input type="text" name="direccion" value="<%=al.getDireccion()%>"></td>
    	<td><select id="slctProvincia" name="slctProvincia" required onchange="llenarLocalidades()">
					<option value="0" selected>- Seleccione Provincia -</option>
					<%
						ArrayList<Provincia> listProvincias = null;
					
						if (request.getAttribute("ListaProvincias") != null) 
						{
							listProvincias = (ArrayList<Provincia>) request.getAttribute("ListaProvincias");
						}
		
						if (listProvincias != null) 
						{
							
							for (Provincia prov : listProvincias) 
							{
					%>
					<option value=" <%=prov.getID()%> "> <%=prov.getNombre()%> </option>
					<%
							}
							
						}
					%>
				</select></td>
				
				<td><select	id="slctLocalidad" required name="slctLocalidad" > 
					<option value="0" selected>- Seleccione Localidad -</option>
				</select></td>
    <td style="text-align:center"> <input type="submit" value="Actualizar" name="btn_ModAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="submit" value="Eliminar" name="btn_EliminarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
	<%
				if(request.getAttribute("modifico") != null)
				{	
					String var = request.getAttribute("modifico").toString();
			%>
				<script type="text/javascript">
					<% 
						String mensaje = null;
						if(var.equals("1")){
							mensaje = "El alumno se modifico correctamente.";
						} else if (var.equals("0")) {
							mensaje = "No se pudo modificar el alumno.";
						}
						
						else if (var.equals("4")){
							mensaje = "El alumno se elimino correctamente.";
						}
						
						else if (var.equals("3")){
							mensaje = "El alumno no se pudo eliminar.";
						}
						
					%>
					var msg = "<%=mensaje%>";
					$(document).ready(function(){
						   setTimeout(function(){
			   					alert(msg);
						   },5); // 5000 to load it after 5 seconds from page load
						});
					
				</script>
				
			<%		
				}
			%>
	
	</form>
	
	<% 
	}
	%>
	
</tbody>

</table>

</body>
</html>
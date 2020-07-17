
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Docente</title>
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
<jsp:include page="Navegacion.jsp"></jsp:include>

<h2 align="center">MODIFICAR DOCENTE</h2>

<table ALIGN="center" id="Modificaciones" width=100%>
  <thead>
  <tr>
  	<th>ID</th>	<!--  -->
  	<th>DNI</th>	<!--  -->
	<th>Nombre/s</th>
	<th>Apellido/s</th>
	<th>Fecha de Nacimiento</th>
	<th>Direccion</th>	<!--  -->
	<th>Email</th>	<!--  -->
	<th>Telefono</th>	<!--  -->
    <th>Provincia</th>
    <th>Localidad</th>
    <th>Modificar</th>
    <th>Eliminar</th>
</tr>
</thead> 
  
  <tbody>
  
  <%if (request.getAttribute("docente") != null){
	  Docente doc = new Docente();
	  doc.igualar((Docente) request.getAttribute("docente"));
	
	  
	  
	   
	  %>
  
  <form action="ServletModificarDocente" method="get">
  
  <tr>
  	<td><input type="text" name="ID_Docente" value="<%=doc.getLegajo() %>" readonly="readonly"></td>
  	<td><input type="text" name="DNI_Docente" value= "<%=doc.getDni() %>" maxlength="8" pattern="\d{8}" title="Se requieren 8 digitos." onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))"></td>
    <td><input type="text" name="Nombre_Docente" value= "<%=doc.getNombre() %>" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))"></td>
    <td><input type="text" name="Apellido_Docente" value= "<%=doc.getApellido() %>" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))"></td>
    <td><input type="date" name="fechanacimiento" value="<%=doc.getFechaNacimiento() %>" ></td>
    <td><input type="text" name="Direccion_Docente" value="<%=doc.getDireccion()%>" ></td>
    <td><input type="email" name="Email_Docente" value="<%=doc.getEmail() %>" ></td>
    <td><input type="text" name="Telefono_Docente" value="<%=doc.getTelefono() %>" maxlength="10" onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))" ></td>
    <td><select id="slctProvincia" name="slctProvincia" onchange="llenarLocalidades()">
					<option value="0" selected required>- Seleccione Provincia -</option>
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
				<td><select	id="slctLocalidad" name="slctLocalidad"> 
					<option value="0" selected required>- Seleccione Localidad -</option>
				</select></td>
    
    <td style="text-align:center"> <input type="submit" value="Actualizar" name="btn_ModDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="submit" value="Eliminar" name="btn_EliminarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
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
							mensaje = "El docente se modifico correctamente.";
						} else if (var.equals("0")) {
							mensaje = "No se pudo modificar el docente.";
						}
						
						else if (var.equals("4")){
							mensaje = "El docente se elimino correctamente.";
						}
						
						else if (var.equals("3")){
							mensaje = "El docente no se pudo eliminar.";
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
  
<% }%>
</tbody>

</table>

</body>
</html>
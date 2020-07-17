<%@page import="java.sql.*"%>
<%@ page import="dominio.*"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="EstilosAlta.css" type="text/css" />
<title>Alta de Docente</title>
</head>

<body>
	<jsp:include page="Localidades.jsp"/>
	<jsp:include page="Navegacion.jsp"/>
		
	<h1>Alta Docente</h1>
	
	<div class="container">
		<form action="ServletAltaDocentes" method="post">
		
			<label for="txtNombre"> Nombre: </label><br>
				<input type="text" id="txtNombre" name="nombre" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))" required/><br>
	
				<label for="txtApellido"> Apellido: </label><br>
				<input type="text" id="txtApellido" name="apellido" onkeypress="return (event.charCode ==32 || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 65 && event.charCode <= 90))" required/><br>
	
				<label for="txtDni"> DNI: </label><br>
				<input type="text" id="txtDni" name="dni" maxlength="8" pattern="\d{8}" title="Se requieren 8 digitos." onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))" required/><br>
				
				<label for="dateFechaNacimiento"> Fecha de nacimiento: </label><br>
				<input type="date" id="dateFechaNacimiento" name="fechanacimiento" required/><br>
	
				<label for="txtEmail"> Email: </label><br><br>
				<input type="email" id="txtEmail" name="email" placeholder="email@ejemplo.com" required/><br>
				<br>
				<label for="txtTelefono"> Teléfono: </label><br>
				<input type="text" id="txtTelefono" name="telefono" maxlength="10" onkeypress="return ((event.charCode >= 48 && event.charCode <= 57))" required/><br>
			

			<label for="slctProvincia"> Provincia: </label><br>
				<select id="slctProvincia" name="slctProvincia" required onchange="llenarLocalidades()">
					<option value="" selected>- Seleccione Provincia -</option>
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
				</select><br>
				
				<label for="slctLocalidad">Localidad: </label> <br> 
				<select	id="slctLocalidad" name="slctLocalidad" required> 
					<option value="" selected>- Seleccione Localidad -</option>
				</select> <br>
				
				<label for="txtDireccion"> Direccion: </label><br>
				<input type="text" id="txtDireccion" name="direccion" required></input><br>

			<input type="submit" name="btnAltaDocente" value="Aceptar"><br><br>
			
				<%
				if(request.getAttribute("agrego") != null){
					String exito = request.getAttribute("agrego").toString();
					if (exito.equals("true")){
					%>
					<label class='subtitle' style="color:red;"> El docente se agrego correctamente. </label>
				<%
				}
					
					else{
				%>
				<label class='subtitle' style="color:red;"> No se pudo agregar el docente. </label>
				<%
				}
					
				}
				%>

		</form>
	</div>



</body>
</html>
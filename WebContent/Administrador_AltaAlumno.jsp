<%@ page import="dominio.*"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="EstilosAlta.css" type="text/css" />
		
		<title>Alta de Alumno</title>
	
	</head>
	
	<body>
	
		<jsp:include page="Navegacion.jsp"/>
			
		<h1>Alta de alumno</h1>
		
		<div class="container">
			<form method="post" action="ServletAltaAlumnos">
	
				<label for="txtNombre"> Nombre: </label><br>
				<input type="text" id="txtNombre" name="nombre" required></input><br>
	
				<label for="txtApellido"> Apellido: </label><br>
				<input type="text" id="txtApellido" name="apellido" required></input><br>
	
				<label for="txtDni"> DNI: </label><br>
				<input type="text" id="txtDni" name="dni" required></input><br>
				
				<label for="dateFechaNacimiento"> Fecha de nacimiento: </label><br>
				<input type="date" id="dateFechaNacimiento" name="fechanacimiento" required></input><br>
	
				<label for="txtEmail"> Email: </label><br>
				<input type="text" id="txtEmail" name="email" placeholder="email@ejemplo.com" required></input><br>
	
				<label for="txtTelefono"> Teléfono: </label><br>
				<input type="text" id="txtTelefono" name="telefono" required></input><br>
			
				<label for="slctProvincia"> Provincia: </label><br>
				<select id="slctProvincia" name="slctProvincia" required onchange="this.form1.submit()">
					<option value="0">- Seleccione Provincia -</option>
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
				
				<script>
				function myFunction() {
 				 document.getElementById("mySelect").value = "banana";
			}
				</script>
				
				<label for="cbLocalidad">Localidad: </label> <br> 
				<select	id="cbLocalidad" name="localidad" required> 
					<option value="0">- Seleccione Localidad -</option>
					<%
					ArrayList<Localidad> listLocalidades = null;
					 	if (request.getAttribute("ListaLocalidades") != null) {
					 		listLocalidades = (ArrayList<Localidad>) request.getAttribute("ListaLocalidades");
					 	}

					//	int idprovincia = document.getElementById("cbProvincias").value;
					 	
					 	if (listLocalidades != null) {
							for (Localidad loc : listLocalidades) {
								//if(loc.getIDProvincia() == e.options[e.selectedIndex].value){
								%>
								<option value=" <%=loc.getID()%> "> <%=loc.getNombre()%> </option>
								<%
								}
						}
					%>
					
				</select> <br>
				
				<label for="txtDireccion"> Direccion: </label><br>
				<input type="text" id="txtDireccion" name="direccion" required></input><br>
	
				<input type="submit" value="Guardar" name="btnAltaAlumno"></input>
				
			</form>
		</div>
	</body>
</html>
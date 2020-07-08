<%@ page import="dominio.Provincia"%>
<%@ page import="dominio.Localidad"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="../../css/Alta.css" type="text/css" />
		
		<title>Alta de Alumno</title>
	
	</head>
	
	<body>
	
		<jsp:include page="/Navegacion.html"/>
			
		<h1>Alta de alumno</h1>
		
		<a href="../../ServletAlta?Param=1"> Cargar provincias y paises </a>
		
		<div class="container">
			<form name="form1" method="post" action="../../ServletAlta">
	
				<label for="txtNombre"> Nombre: </label><br>
				<input type="text" id="txtNombre" name="nombre"><br>
	
				<label for="txtApellido"> Apellido: </label><br>
				<input type="text" id="txtApellido" name="apellido"><br>
	
				<label for="txtDni"> DNI: </label><br>
				<input type="text" id="txtDni" name="dni"><br>
				
				<label for="dateFechaNacimiento"> Fecha de nacimiento: </label><br>
				<input type="date" id="dateFechaNacimiento"><br>
	
				<label for="txtEmail"> Email: </label><br>
				<input type="text" id="txtEmail" name="email" placeholder="email@ejemplo.com"><br>
	
				<label for="txtTelefono"> Teléfono: </label><br>
				<input type="text" id="txtTelefono" name="telefono"><br>
				
				<input type="hidden" id="hiddenProvincia" name="hprovincia" value="this.formProvincia.cbProvincia.value">
				<input type="hidden" id="hiddenLocalidad" name="hlocalidad" value="this.formLocalidad.cbLocalidad.value">
			
				<label for="cbProvincia"> Provincia: </label><br>
				<select id="cbProvincias" name="provincia" onchange="this.form1.submit()">
					<option value="0"> Seleccione una Provincia </option>
					<%
						List<Provincia> listProvincias = null;
						if (request.getAttribute("ListaProvincias") != null) {
							listProvincias = (List<Provincia>) request.getAttribute("ListaProvincias");
						}
		
						if (listProvincias != null) {
							for (Provincia prov : listProvincias) {
					%>
					
					<option value=" <%=prov.getID()%> "> <%=prov.getNombre()%> </option>
					<%
						}
						}
					%>
				</select><br>
				
				<label for="cbLocalidad">Localidades</label> <br> 
				<select	id="cbLocalidad" name="localidad"> 
					<option value="0"> Seleccione una Localidad </option>
					<%
						List<Localidad> listLocalidades = null;
					 	if (request.getAttribute("ListaLocalidades") != null) {
					 		listLocalidades = (List<Localidad>) request.getAttribute("ListaLocalidades");
					 	}
					 	//int e = document.getElementById("cbProvincias");
					 	
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
	
				<input type=submit value="Guardar" name="btnAltaAlumno">
				
			</form>
		</div>
	</body>
</html>
<%@ page import="dominio.Provincia"%>
<%@ page import="dominio.Localidad"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Alumno</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 500px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=date] {
	width: 200px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>

</head>
<body>

	<a href="../../ServletAltaAlumno?Param=1">Alta Alumno</a>

	<jsp:include page="/Otros/Navegacion.html"></jsp:include>


	<h3>Alta de alumno</h3>
	
	<div class="container">
		<form name="form1" method="post" action="ServletAltaAlumno">
			<label for="legajo">Legajo: "Autonumerico"</label> <br>

			<label for="txtNombre">Nombre/s</label><br>
			<input type="text" id="txtNombre" name="nombre" placeholder="Nombres"><br>
				
			<label for="txtApellido">Apellido/s</label><br>
			<input type="text" id="txtApellido" name="apellido" placeholder="Apellidos"><br>

			<label for="txtDni">DNI</label><br>
			<input type="text" id="txtDni" name="dni" placeholder="DNI"><br>
			
			<label for="dateFechaNacimiento">Fecha de nacimiento:</label><br>
			<input type="date" id="dateFechaNacimiento" name="fechanacimiento"><br>
				
			<label for="txtEmail">Email</label><br>
			<input type="text" id="txtEmail" name="email" placeholder="email@ejemplo.com"><br>
			
			<label for="txtDireccion">Direccion</label><br>	
			<input type="text" id="txtDireccion" name="direccion" placeholder="Direccion"><br>
			
			<label for="txtTelefono">Telefono</label><br>	
			<input type="text" id="txtTelefono" name="telefono" placeholder="Telefono"><br>
				
			<label for="cbProvincia">Provincia</label><br>
			<select id="cbProvincias" name="provincia" onchange="test()">
				<option value="0">-Seleccione una Provincia-</option>
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
				<option value="0">-Seleccione una Localidad-</option>
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
				%>

				
				<%
					}
					//}

					/*
					int selectedProvId = 0;
					if (request.getAttribute("selectedProvId") != null){
						selectedProvId = (int)request.getAttribute("selectedProvId");
					}
					*/
				%>

				<!--	
 				<c:forEach items="${listLocalidades}" var="localidad">
					<option value="${localidad.id}"
						<c:if test="${localidad.id eq selectedProvId}">selected="selected"</c:if>
						>
						${localidad.nombre}
				</c:forEach>

				-->

			</select> <br>
			<!-- FUNCION TEST
			
			<script type="text/javascript">
					function test(){
						//var provSelected = document.form1.provincia[document.form1.provincia.selectedIndex].value;
						var e = document.getElementById("cbProvincias");
						var provSeleccionada = e.options[e.selectedIndex].value;
						if(provSeleccionada != '0'){
							List<Localidad> listLocalidades = null;
							if (request.getAttribute("ListaLocalidades") != null) {
								listLocalidades = (List<Provincia>) request.getAttribute("ListaLocalidades");
							}
							alert(listLocalidades[0]);
							for(Localidad loc : ListaLocalidades){
								if(loc.IDProvincia == provSelected){
									cant++;
									//document.form1.localidad.options
								}
							}
						}
						else{
							alert('se lo salteo');
						}
					}
			
			</script>
			 -->
			
			<!--     FUNCION CAMBIAR LOCALIDADES
			
			<script type="text/javascript">
				function cambiarLocalidades() {
					//se toma el valor de la provincia
					var provSelected = document.form1.provincia[document.form1.provincia.selectedIndex].value;
					//Si se eligió una provincia...
					if(provSelected != 0){
						
						// ...se seleccionan las localidades correspondientes
						List<Localidad> listLocalidades = null;
						if (request.getAttribute("ListaLocalidades") != null) {
							listLocalidades = (List<Provincia>) request.getAttribute("ListaLocalidades");
						}
						int cant = 0;
						for(Localidad loc : ListaLocalidades){
							if(loc.IDProvincia == provSelected){
								cant++;
								//document.form1.localidad.options
							}
						}
						document.form1.localidad.options.length = cant;
						for(Localidad loc : ListaLocalidades){
							if(loc.IDProvincia == provSelected){
								//asdadasdasdasdas
								document.form1.localidad.option
							}
						}
					}
					
				}
			</script>
			
			-->
			
			<input type=submit value="Guardar" name="btnAltaAlumno">
		</form>
	</div>
</body>
</html>
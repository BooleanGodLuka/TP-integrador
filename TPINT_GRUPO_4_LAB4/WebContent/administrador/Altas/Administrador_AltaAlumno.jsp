<%@ page import="dominio.Provincia"%>
<%@ page import="dominio.Localidad"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.swing.JOptionPane"%>
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

	<a href="../../ServletAltaAlumno?Param=1">Alta cliente</a>

	<jsp:include page="/Otros/Navegacion.html"></jsp:include>


	<h3>Alta de alumno</h3>
	
	
	
	<div class="container">
		<form name="form1" method="post" action="ServletAltaAlumno">
			<label for="legajo">Legajo: "Autonumerico"</label> <br>

			<label for="nombre">Nombre/s</label><br>
			<input type="text" id="idnombre" name="nombre" placeholder="Nombres"><br>
				
			<label for="apellido">Apellido/s</label><br>
			<input type="text" name="apellido" placeholder="Apellidos"><br>

			<label for="dni">DNI</label><br>
			<input type="text" name="dni" placeholder="DNI"><br>
			
			<label for="fechanacimiento">Fecha de nacimiento:</label><br>
			<input type="date" name="fechanacimiento"><br>
				
			<label for="email">Email</label><br>
			<input type="text" name="email" placeholder="email@ejemplo.com"><br>
			
			<label for="lname">Telefono</label><br>	
			<input type="text" id="lname" name="lastname" placeholder="Telefono"><br>
				
			<label for="provincia">Provincia</label><br>
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
			
			<label for="localidad">Localidades</label> <br> 
			<select	name="localidad">
				<option value="0">-Seleccione una Localidad-</option>
			</select>
			<br>
			
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
					<%
					%>
			
			</script>
			
			<!--     FUNCION CAMBIAR LOCALIDADES -->
			
			
			
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
			
			<!--                     -->
			
			<input type=submit value="Guardar" name="btnAltaAlumno">
		</form>
	</div>
</body>
</html>
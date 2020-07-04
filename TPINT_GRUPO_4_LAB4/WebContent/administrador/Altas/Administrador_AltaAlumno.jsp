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


	<jsp:include page="/Otros/Navegacion.html"></jsp:include>


	<h3>Alta de alumno</h3>


	<div class="container">
		<label for="fname">Legajo: "Autonumerico"</label> <br> <br>

		<label for="nombre">Nombre/s</label><br> <input type="text"
			id="nombre" name="nombre" placeholder="Nombres"><br> <label
			for="apellido">Apellido/s</label><br> <input type="text"
			id="apellido" name="apellido" placeholder="Apellidos"><br>

		<label for="dni">DNI</label><br> <input type="text" id="dni"
			name="dni" placeholder="DNI"><br> <label
			for="fechanacimiento">Fecha de nacimiento:</label><br> <input
			type="date" id="birthday" name="birthday"><br> <label
			for="lname">Email</label><br> <input type="text" id="lname"
			name="lastname" placeholder="email@ejemplo.com"><br> <label
			for="lname">Telefono</label><br> <input type="text" id="lname"
			name="lastname" placeholder="Telefono"><br> <label
			for="provincia">Provincia</label><br> <select id="provincia"
			name="provincia">
			<option value="Vacio">-Seleccione una Provincia-</option>
			<option value="BsAs">Buenos Aires</option>
			<option value="Santa Fe">Santa Fe</option>
			<option value="Chubut">Chubut</option>
		</select><br>


		<form method="post" action="ServletAltaAlumno">
			<label for="localidad">Localidades</label> <br> <select
				id="localidad" name="localidad">
				<option value="empty">-Seleccione una Localidad-</option>
				<%
					List<Localidad> listLocalidades = null;
					if (request.getAttribute("ListaLocalidades") != null) {
						listLocalidades = ((List<Localidad>) request.getAttribute("ListaLocalidades"));
					}

					if (listLocalidades != null) {

						for (Localidad loc : listLocalidades) {
				%>
				<option value=" <%=loc.getID()%> ">
					<%=loc.getNombre()%>
				</option>
				<%
					}
					}
				%>
			</select><br> <input type=submit value="Cargar Localidades"
				name="btnAltaAlumno">
		</form>
	</div>
</body>
</html>
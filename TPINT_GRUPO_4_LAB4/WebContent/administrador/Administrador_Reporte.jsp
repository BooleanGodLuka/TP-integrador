<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de cursos</title>


<link rel="StyleSheet" href="/Otros/HojaEstilos.css" type="text/css">

<style>
input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

/* Create a custom checkbox */
.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 25px;
	width: 25px;
	background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
	background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
	background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
	display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
	left: 9px;
	top: 5px;
	width: 5px;
	height: 10px;
	border: solid white;
	border-width: 0 3px 3px 0;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}
</style>



</head>
<body>

	<jsp:include page="/Otros/Navegacion.html"></jsp:include>
	
	

	<h1 align=center>Reporte de cursos</h1>

	<div align=center">
		<form action="/action_page.php">
				<select>
				<option value="empty">Materia</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br><br>
			</select>
			
			<select>
				<option value="empty">Cuatrimestre</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br><br>
			</select>
			
			<select>
				<option value="empty">A�o</option>
				<option value="Laboratorio IV">Laboratorio IV</option>
				<option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
				<option value="Dise�o y Administracion de Base de Datos I">Dise�o y Administracion de Base de Datos I</option><br><br>
			</select>
		</form>
	</div>
	<br>
	<br>
	
	<table id="customers">
		<tr>
			<th>Materia</th>
			<th>Cuatrimestre</th>
			<th>A�o</th>
			<th>Docente</th>
			<th>Cantidad de alumnos</th>
			<th>Aprobaciones</th>
			<th>Desaprobaciones</th>
			<th>Porcentaje</th>
		<tr>
			<td>Laboratorio 4</td>
			<td>2do</td>
			<td>2020</td>
			<td>Tamara Herrera</td>
			<td>100</td>
			<td>65</td>
			<td>35</td>
			<td>65%</td>
		</tr>
		<tr>
			<td>Laboratorio 3</td>
			<td>1ro</td>
			<td>2020</td>
			<td>Maximiliano Sar Fernandez</td>
			<td>200</td>
			<td>110</td>
			<td>90</td>
			<td>55%</td>
		</tr>
	</table>
	
	<br>
	<br>
	<p>P�g.</p>
<input type="submit" value="1"></input>


</body>
</html>
<%@page import=" dominio.Reporte"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de cursos</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

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
	
	<jsp:include page="Navegacion.jsp"></jsp:include>

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
			
			
<% if (request.getAttribute("lista_reportes") != null){
	ArrayList<Reporte> lista;
	lista = (ArrayList<Reporte>) request.getAttribute("lista_reportes");
	Reporte rep = new Reporte();
	 
	for (int i=0; i<lista.size(); i++){
		rep.igualar(lista.get(i));
		
%>		
		<tr>
			<td><%=rep.getCurso().getMateria().getNombre() %></td>
			<td><%=rep.getCurso().getCuatrimestre() %></td>
			<td><%=rep.getCurso().getAnio() %></td>
			<td><%=rep.getCurso().getDocente().getApellido() %></td>
			<td><%=rep.getCant_alumn() %></td>
			<td><%=rep.getCant_aprob() %></td>
			<td><%=rep.getCant_desaprob() %></td>
			<td><%=rep.getPorcentaje() %> %</td>
		
		</tr>
<%}} %>	
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
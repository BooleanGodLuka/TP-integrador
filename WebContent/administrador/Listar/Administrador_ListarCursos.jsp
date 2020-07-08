<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Cursos</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style>
#Listados{
  font-family: Verdana, Arial, Helvetica, sans-serif;
  border-collapse: collapse;
}

#Listados td, #Listados th {
  border: 1px solid #ddd;
  padding: 15px;
}

#Listados tr:nth-child(even){background-color: #f2f2f2;}

#Listados tr:hover {background-color: #006666;}

#Listados th {
  padding-top: 13px;
  padding-bottom: 13px;
  text-align: center;
  background-color: #008080;
  color: white;
}

</style>
</head>
<body>

<jsp:include page="/Otros/Navegacion.html"></jsp:include>

<h2 ALIGN="center">LISTADO DE CURSOS</h2>

<div align="center">
			<form action="/action_page.php" align="center">
				<input type="text" name="txtFiltroCriterio" class="textbox" placeholder="Filtrar" style= "width: 500px;">
			    <input type="submit" value="Buscar"/>
			    
			    <p>Filtrar por:</p>
				  <input type="radio" id="legajo" name="criterio" value="legajo">
				  <label for="legajo">Legajo</label>
				  <input type="radio" id="nombre" name="criterio" value="nombre">
				  <label for="nombre">Nombre</label>
				  <input type="radio" id="apellido" name="criterio" value="apellido">
				  <label for="apellido">Apellido</label>
    		</form>
		</div>
		<br>
	
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

<table ALIGN="center" id="Listados" width=100%>

<thead>
<tr>
	<th>Curso</th>
	<th>Cuatrimestre</th>
	<th>A�o</th>
	<th>Docente</th>
	<th>Alumnos</th>
	<th>Modificar</th>
</tr>
</thead>

<tbody>

<tr>
<td> Laboratorio de Computacion IV </td>
<td> 2� Cuatrimestre </td>
<td> 2020 </td>
<td> Tamara Herrera </td>
<td style="text-align:center"> <input type="button" value="Ver Alumnos" name="btn_VerAlumnos"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
<td style="text-align:center"> <input type="button" value="Modificar Curso" name="btn_ModificarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
</tr>

<tr>
<td> Metodologia de Sistemas I</td>
<td> 2� Cuatrimestre </td>
<td> 2020 </td>
<td> Lorena Palermo </td>
<td style="text-align:center"> <input type="button" value="Ver Alumnos" name="btn_VerAlumnos"style="BORDER: rgb(128,128,128)  3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
<td style="text-align:center"> <input type="button" value="Modificar Curso" name="btn_ModificarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
</tr>

<tr>
<td> Dise�o y Administracion de base de Datos I </td>
<td> 2� Cuatrimestre </td>
<td> 2020 </td>
<td> Ines Casanovas </td>
<td style="text-align:center"> <input type="button" value="Ver Alumnos" name="btn_VerAlumnos"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
<td style="text-align:center"> <input type="button" value="Modificar Curso" name="btn_ModificarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
</tr>
</tbody>

</table>

<p>P�g.</p>
<input type="submit" value="1">

</body>
</html>
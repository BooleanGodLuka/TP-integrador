<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
</html>

<head>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listado Alumnos</title>
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

<jsp:include page="/Navegacion.html"></jsp:include>

	<h2 align="center">LISTADO DE ALUMNOS</h2>
	
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
	
	<div align="center"><h3>Filtro por Curso:
		<select>
			  <option value="Laboratorio IV">Laboratorio IV</option>
			  <option value="Metodologia de Sistemas I">Metodologia de Sistemas I</option>
			  <option value="Diseño y Administracion de Base de Datos I">Diseño y Administracion de Base de Datos I</option><br><br>
		</select>
		</h3>
	</div>
	<br>

<table ALIGN="center" id="Listados" width=100%>

<thead>
 <tr>
    <th>Legajo</th>
    <th>Nombre/s</th>
    <th>Apellido/s</th>
    <th>DNI</th>
    <th>Email</th>
    <th>Fecha de Nacimiento</th>
    <th>Provincia</th>
    <th>Localidad</th>
    <th>Modificar</th>
  </tr>
</thead>

<tbody>
  <tr>
    <td style="text-align: center">1</td>
    <td>Lucas</td>
    <td>Franco Feldman</td>
    <td>39.560.447</td>
    <td>lucas.francofeldman@gmail.com</td>
    <td style="text-align: center">19/03/1996</td>
    <td>Buenos Aires</td>
    <td>El Talar</td>
    <td style="text-align:center"> <input type="button" value="Modificar Alumno" name="btn_ModificarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
  <tr>
    <td style="text-align: center">2</td>
    <td>Luca</td>
    <td>Di Tullio</td>
    <td>40.045.247</td>
    <td>luca_ditu@gmail.com</td>
    <td style="text-align: center">17/06/1995</td>
    <td>Buenos Aires</td>
    <td>Beccar</td>
    <td style="text-align:center"> <input align="middle" type="button" value="Modificar Alumno" name="btn_ModificarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
  <tr>
   	<td style="text-align: center">3</td>
    <td>Guido</td>
    <td>Amicci</td>
    <td>39.784.996</td>
    <td>guidoamicci1995@gmail.com</td>
    <td style="text-align: center">02/12/1996</td>
    <td>Buenos Aires</td>
    <td>Pacheco</td>
    <td style="text-align:center"> <input align="middle" type="button" value="Modificar Alumno" name="btn_ModificarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
</tbody>
</table>

<p>Pág.</p>
<input type="submit" value="1">

</body>
</html>
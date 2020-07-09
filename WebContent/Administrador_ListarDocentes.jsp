<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Docentes</title>
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

<jsp:include page="Navegacion.jsp"></jsp:include>

<h2 ALIGN="center">LISTADO DE DOCENTES</h2>

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

<table ALIGN="center" id="Listados" width=100%>


<thead>
 <tr>
 	<th>Legajo</th>
    <th>Usuario</th>
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
<td style="text-align: center"> 1 </td>
<td> cfernandez </td>
<td> Claudio </td>
<td> Fernandez </td>
<td> 25.247.145 </td>
<td> claudio_fernandez00@red.utn.frgp.edu.ar </td>
<td style="text-align: center">04/05/1970</td>
<td> Buenos Aires </td>
<td> Tigre </td>
<td style="text-align:center"> <input type="button" value="Modificar Docente" name="btn_ModificarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>	
</tr>

<tr>
<td style="text-align: center"> 2 </td>
<td> therrera </td>
<td> Tamara </td>
<td> Herrera </td>
<td> 30.478.634 </td>
<td> tamiherrera@red.utn.frgp.edu.ar </td>
<td style="text-align: center">15/02/1985</td>
<td> Buenos Aires </td>
<td> Vicente Lopez </td>
<td style="text-align:center"> <input type="button" value="Modificar Docente" name="btn_ModificarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
</tr>

<tr>
<td style="text-align: center"> 3 </td>
<td> crodriguez </td>
<td> Carlos Javier </td>
<td> Rodriguez </td>
<td> 33.145.777 </td>
<td>cjrodriguez@red.utn.frgp.edu.ar </td>
<td style="text-align: center">09/10/1977</td>
<td> Buenos Aires </td>
<td> EL Talar </td>
<td style="text-align:center"> <input type="button" value="Modificar Docente" name="btn_ModificarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
</tr>
</tbody>

</table>

<p>Pág.</p>
<input type="submit" value="1">

</body>
</html>
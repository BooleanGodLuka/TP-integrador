<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Alumno</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style>

#Modificaciones{
  font-family: Verdana, Arial, Helvetica, sans-serif;
  border-collapse: collapse;
}

#Modificaciones td, #Modificaciones th {
  border: 1px solid #ddd;
  padding: 15px;
}

#Modificaciones tr:nth-child(even){background-color: #f2f2f2;}

#Modificaciones th {
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
  background-color: #7a0607;
  color: white;
}

</style>

</head>
<body>


<jsp:include page="Navegacion.jsp"/>

<h2 align="center">MODIFICAR ALUMNO</h2>

	<%
		if (request.getAttribute("ListaProvincias") != null) {
			listProvincias = (List<Provincia>) request.getAttribute("ListaProvincias");
		}

		if (listProvincias != null) {
			for (Provincia prov : listProvincias) {
				
			}
		}
	%>

<table ALIGN="center" id="Modificaciones" width=80%>
	<thead>
	<tr>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Fecha de Nacimiento</th>
		<th>Email</th>
	    <th>Provincia</th>
	    <th>Localidad</th>
	    <th>Modificar</th>
	    <th>Eliminar</th>
	</tr>
	</thead>
  
	<tbody>
	<tr>
	    <td><input type="text" name="dni" placeholder="<%= Alumno.getdn %>>"></td>
	    <td><input type="text" name="nombre" placeholder="Nombre"></td>
	    <td><input type="text" name="apellido" placeholder="Apellido"></td>
	    <td><input type="date" name="fechanacimiento" placeholder="Fecha de Nacimiento"></td>
	    <td><input type="text" name="email" placeholder="email@ejemplo.com"></td>
    <td>
    <select id="provincia" name="provincia">
    	<option value="Vacio"> Seleccione una Provincia </option>
    	
    </select>
    </td>
    <td>
    <select id="localidad" name="localidad">
    	<option value="Vacio"> Seleccione una Localidad </option>

    </select>
    </td>
    <td style="text-align:center"> <input type="button" value="Actualizar" name="btn_ModificarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="button" value="Eliminar" name="btn_EliminarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>

</tbody>

</table>

</body>
</html>
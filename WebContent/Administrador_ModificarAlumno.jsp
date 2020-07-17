<%@page import="dominio.Localidad"%>
<%@page import="dominio.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Alumno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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

	<%/*
		if (request.getAttribute("ListaProvincias") != null) {
			listProvincias = (List<Provincia>) request.getAttribute("ListaProvincias");
		}

		if (listProvincias != null) {
			for (Provincia prov : listProvincias) {
				
			}
		}*/
	%>

<table ALIGN="center" id="Modificaciones" width=80%>
	<thead>
	<tr>
		<th>ID</th>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Fecha de Nacimiento</th>
		<th>Email</th>
		<th>Telefono</th>
		<th>Direccion</th>
	    <th>Provincia</th>
	    <th>Localidad</th>
	    <th>Modificar</th>
	    <th>Eliminar</th>
	</tr>
	</thead>
  
	<tbody>
	<form action="ServletModificarAlumno" method="get">
	<%
		if (request.getAttribute("alumno") != null){
	Alumno al = new Alumno();		
	al.igualar((Alumno)request.getAttribute("alumno"));
	
	
	%>
	
	<tr>
	    <td><input type="text" name="id" value="<%=al.getLegajo()%>" readonly></td>
	    <td><input type="text" name="dni" value="<%=al.getDni()%>"></td> 
	    <td><input type="text" name="nombre" value="<%=al.getNombre()%>"></td>
	    <td><input type="text" name="apellido" value="<%=al.getApellido()%>"></td>
	    <td><input type="date" name="fechanacimiento" value="<%=al.getFechaNacimiento() %>"></td>
	    <td><input type="text" name="email" value="<%=al.getEmail()%>"></td>
	    <td><input type="text" name="telefono" value="<%=al.getTelefono()%>"></td>
	    <td><input type="text" name="direccion" value="<%=al.getDireccion()%>"></td>
    
    
    
    
    <td>
    <select id="provincia" name="provincia">
    	<%ArrayList<Provincia> provincias = (ArrayList<Provincia>) request.getAttribute("provincias"); 
    	Provincia prov = new Provincia();
    	for (int i =0; i<provincias.size(); i++){ 
    		prov.setID(provincias.get(i).getID());
    		prov.setNombre(provincias.get(i).getNombre());
    	%>
    	<option name="prov_<%=prov.getID() %>" value="<%=prov.getID()%>"><%=prov.getNombre()%></option>
    	<%} %>
    </select>
    </td>
    
    
    
    <td>
    <select id="localidad" name="localidad">
    		<%ArrayList<Localidad> localidades = (ArrayList<Localidad>) request.getAttribute("localidades"); 
    	Localidad loc = new Localidad(); 
    	for (int i =0; i<localidades.size(); i++){ 
    		loc.setID(localidades.get(i).getID());
    		loc.setNombre(localidades.get(i).getNombre());
    		loc.setIDProvincia(localidades.get(i).getIDProvincia());
    	%>
    	<option name="loc_<%=loc.getID() %>" value="<%=loc.getID()%>"><%=loc.getNombre()%></option>
    	<%} %>
    </select>
    </td>
    <td style="text-align:center"> <input type="submit" value="Actualizar" name="btn_ModAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="submit" value="Eliminar" name="btn_EliminarAlumno"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
<%} %>
	
	</form>
	
</tbody>

</table>

</body>
</html>
<%@page import="dominio.Localidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Provincia"%>
<%@page import="dominio.Docente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Docente</title>
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


<jsp:include page="Navegacion.jsp"></jsp:include>

<h2 align="center">MODIFICAR DOCENTE</h2>

<table ALIGN="center" id="Modificaciones" width=100%>
  <thead>
  <tr>
  	<th>ID</th>	<!--  -->
  	<th>DNI</th>	<!--  -->
	<th>Nombre/s</th>
	<th>Apellido/s</th>
	<th>Fecha de Nacimiento</th>
	<th>Direccion</th>	<!--  -->
	<th>Email</th>	<!--  -->
	<th>Telefono</th>	<!--  -->
    <th>Provincia</th>
    <th>Localidad</th>
    <th>Modificar</th>
    <th>Eliminar</th>
</tr>
</thead> 
  
  <tbody>
  
  <%if (request.getAttribute("docente") != null){
	  Docente doc = new Docente();
	  doc.igualar((Docente) request.getAttribute("docente"));
	
	  
	  
	   
	  %>
  
  <form action="ServletModificarDocente" method="get">
  
  <tr>
  	<td><input type="text" name="ID_Docente" value="<%=doc.getLegajo() %>" readonly="readonly"></td>
  	<td><input type="text" name="DNI_Docente" value= "<%=doc.getDni() %>"></td>
    <td><input type="text" name="Nombre_Docente" value= "<%=doc.getNombre() %>"></td>
    <td><input type="text" name="Apellido_Docente" value= "<%=doc.getApellido() %>"></td>
    
    
    
    
    <td style="text-align: center">
    <div class="control-group">
  <div class="controls">
    <select name="dia" id="dia">
    
    <%for (int i=1;i<=31;i++){
    	
    	%>
    	<option value="<%=i %>"><%=i %></option>
    <%} %>
    </select>
    
    
    <select name="mes" id="mes">
      <%for (int i=1;i<=12;i++){
    	
    	%>
    	<option value="<%=i %>"><%=i %></option>
    <%} %>
    </select>
    
    
    
    
    <select name="anio" id="año">
      <%for (int i=2000;i>=1900;i--){
    	
    	%>
    	<option value="<%=i %>"><%=i %></option>
    <%} %>
    </select>
    
    
    
  </div>
</div>
</td>
    
    <td><input type="text" name="Direccion_Docente" value="<%=doc.getApellido()%>"></td>
    <td><input type="text" name="Email_Docente" value="<%=doc.getEmail() %>"></td>
    <td><input type="text" name="Telefono_Docente" value="<%=doc.getTelefono() %>"></td>
    
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
    		if (localidades.get(i).getID() == Integer.parseInt(doc.getIDLocalidad())){
    			loc.setID(localidades.get(i).getID());
    			loc.setNombre(localidades.get(i).getNombre());
    		}
    	}
  
    	%>
    	<option name="loc_<%=loc.getID() %>" value="<%=loc.getID()%>"><%=loc.getNombre()%></option>
    	
    	<%
    	
  
    	for (int i =0; i<localidades.size(); i++){ 
    		loc.setID(localidades.get(i).getID());
    		loc.setNombre(localidades.get(i).getNombre());
    		loc.setIDProvincia(localidades.get(i).getIDProvincia());
    	%>
    	<option name="loc_<%=loc.getID() %>" value="<%=loc.getID()%>"><%=loc.getNombre()%></option>
    	<%} %>
    </select>
    </td>
    
    
    
    
    <td style="text-align:center"> <input type="submit" value="Actualizar" name="btn_ModDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="submit" value="Eliminar" name="btn_EliminarDocente"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
  </tr>
  </form>
  
<% }%>
</tbody>

</table>

</body>
</html>
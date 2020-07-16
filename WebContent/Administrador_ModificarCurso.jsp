<%@page import="dominio.Docente"%>
<%@page import="dominio.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Curso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Curso</title>
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

<style>

#ModificacionesCurso{
  font-family: Verdana, Arial, Helvetica, sans-serif;
}

#ModificacionesCurso td, #ModificacionesCurso th {
  padding: 15px;
}


#ModificacionesCurso th {
  padding-top: 13px;
  padding-bottom: 13px;
  text-align: center;
  background-color: #7a0607;
  color: white;
}

</style>

</head>

<body>

<jsp:include page="Navegacion.jsp"></jsp:include>


<h2 align="center">MODIFICACION DE CURSO</h2>

<table ALIGN="center" id="Modificaciones" width=100%>
  <thead>
  <tr>
	<th>ID Curso</th>
	<th>Materia</th>
	<th>Cuatrimestre</th>
    <th>Año</th>
    <th>Docente</th>
    <th>Modificar</th>
    <th>Eliminar</th>
    
</tr>
</thead> 
  
  
  
  
  
  
  
  <tbody>
  
  <%if (request.getAttribute("curso") != null){
	 Curso cur = new Curso();
	 cur.igualar((Curso)request.getAttribute("curso"));
	  
  %>
  
  
  
  
  <tr>
  <form action="ServletModificarCurso" method="get">
  	<td><input type="text" name="ID_Curso" value="<%=cur.getID() %>" readonly="readonly"></td>
  	  
  	  
  	  
  	  
  	  <td>
    <select id="Materia" name="Materia">
 
    <%ArrayList<Materia> materias = (ArrayList)request.getAttribute("materias");
    Materia mat = new Materia();
 
    for (int i =0; i<materias.size(); i++){
    	if (materias.get(i).getID() == cur.getMateria().getID()){
    		cur.setMateria(materias.get(i));
    		break;
    	}
    }
 
    %>
    <option value ="<%=cur.getMateria().getID() %>"><%=cur.getMateria().getNombre() %>
    <%    
    
    
    for (int i =0; i<materias.size(); i++){
    	mat.setID(materias.get(i).getID());
    	mat.setNombre(materias.get(i).getNombre());
 	if (mat.getID() != cur.getMateria().getID()){
 		%>
 	      <option value="<%=mat.getID() %>"><%=mat.getNombre() %></option>
 	    <%} 	
 	}
    %>
 
    </select>
    </td>
 
 
     
    <td>
    <select id="Cuatrimestre" name="Cuatrimestre">
    <%if (cur.getCuatrimestre() == "1ro"){
    %>
      <option value="1ro">1° Cuatrimestre</option>
      <option value="2do">2° Cuatrimestre</option>
    <%}else { %>
      <option value="2do">2° Cuatrimestre</option>
      <option value="1ro">1° Cuatrimestre</option>
    <%} %>
    </select>
    </td>
 
 
    
    <td>
    <select id="Año" name="Anio">
    
    <option value="<%=cur.getAnio()%>"><%=cur.getAnio()%></option>
    
    <%for (int i=2000;i<=2020;i++){
    
    	if (i != Integer.parseInt(cur.getAnio())){
    		
    	%>
    	<option value="<%=i %>"><%=i %></option> 
    	
    	<%}
    	
    }%>	
    </select>
    </td>
 
 
    
    <td>
    <select id="Docente" name="Docente">
      
      <%ArrayList<Docente> docentes = (ArrayList)request.getAttribute("docentes");
    Docente doc = new Docente();
    for (int i =0; i<docentes.size(); i++){
    	if (cur.getDocente().getLegajo() == docentes.get(i).getLegajo()){
    		cur.setDocente(docentes.get(i));
    		break;
    	}
    }
    
    %>
    <option value="<%=cur.getDocente().getLegajo() %>"><%=cur.getDocente().getApellido()%>, <%=cur.getDocente().getNombre()%> </option>
    <%
    
    for (int i =0; i<docentes.size(); i++){
    	doc.igualar(docentes.get(i));
 		if (cur.getDocente().getLegajo() != doc.getLegajo()){
 			
 		
    %>
    
      <option value="<%=doc.getLegajo() %>"><%=doc.getApellido()%>, <%=doc.getNombre()%> </option>
    <%} }%>
    </select>
    </td>
    <td style="text-align:center"> <input type="submit" value="Actualizar Curso" name="btn_ModCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="submit" value="Eliminar Curso" name="btn_EliminarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    
    

  </form>
  </tr>
<%}%>
</tbody>

</table>

<h2 align="center">VISTA PREVIA DEL CURSO</h2>

<table ALIGN="center" id="ModificacionesCurso" width=100%>
<thead>
 <tr>
    <th>Legajo</th>
    <th>Nombre/s</th>
    <th>Apellido/s</th>
  </tr>
</thead>

<tbody>
  <tr>
    <td style="text-align: center">1</td>
    <td>Lucas</td>
    <td>Franco Feldman</td>
  </tr>
  <tr>
    <td style="text-align: center">2</td>
    <td>Luca</td>
    <td>Di Tullio</td>
   
  </tr>
  <tr>
   	<td style="text-align: center">3</td>
    <td>Guido</td>
    <td>Amicci</td>
  </tr>
</tbody>


</table>

</body>
</html>
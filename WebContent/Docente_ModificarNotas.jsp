<%@page import="java.util.ArrayList"%>
<%@page import="dominio.AlumnoXCurso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar notas</title>
<link rel="StyleSheet" href="/Otros/HojaEstilos.css" type="text/css">

<style>


#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px; 
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

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

input[type=submit] {
  width: 15%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

</style>



</head>
<body>

<jsp:include page="Navegacion.jsp"></jsp:include>

<div align="center">
			<form method="get" action="Docente_ModificarNotas.jsp" align="center">
				<input type="text" name="txtFiltroCriterio" class="textbox" placeholder="Filtrar" style= "width: 500px;">
			    <input type="submit" value="Buscar"/>
			    
			    <h3>Filtrar por:</h3>
				  <input type="radio" id="legajo" name="criterio" value="legajo">
				  <label for="legajo">Legajo</label>
				  <input type="radio" id="nombre" name="criterio" value="nombre">
				  <label for="nombre">Nombre</label>
				  <input type="radio" id="apellido" name="criterio" value="apellido">
				  <label for="apellido">Apellido</label>
    		</form>
		</div>
		<br>
 
<label for="fname">Curso Numero: <%=request.getAttribute("id_curso") %></label>
<br>
<form method="get" action="docente_modificar_nota_servlet">
<table id="customers">
  <tr>
    <th>Legajo</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Parcial 1</th>
    <th>Recuperatorio 1</th>
    <th>Parcial 2</th>
    <th>Recuperatorio 2</th>
    <th>Regularidad</th>
    <th>Aprobacion</th>
  </tr>
  
   
  <%
       	if (request.getAttribute("lista_alumnos") != null){
       	ArrayList<AlumnoXCurso> lista;
       	lista = (ArrayList<AlumnoXCurso>) request.getAttribute("lista_alumnos");
       	AlumnoXCurso axc = new AlumnoXCurso();
       	
       	for (int i=0; i<lista.size();i++ ){
       		axc.igualar(lista.get(i));
       		if (axc.getAlumno().getActivo()){
       			
       		
       %>  
  <tr>
    <td><%= axc.getAlumno().getLegajo() %></td> <!--  <input type="hidden" name ="alumno" value= "<%//axc.getAlumno().getLegajo() %>" >-->
    <td><%= axc.getAlumno().getNombre()%></td>
    <td><%= axc.getAlumno().getApellido() %></td>
    <td><input type="text" id="nota" name="nota1_<%= axc.getAlumno().getLegajo() %>" value="<%= axc.getNota1() %>"></td>
    <td><input type="text" id="nota" name="nota2_<%= axc.getAlumno().getLegajo() %>" value="<%= axc.getNota2() %>"></td>
    <td><input type="text" id="nota" name="nota3_<%= axc.getAlumno().getLegajo() %>" value="<%= axc.getNota3() %>"></td>
    <td><input type="text" id="nota" name="nota4_<%= axc.getAlumno().getLegajo() %>" value="<%= axc.getNota4() %>"></td>
    <td><select name="Estado<%= axc.getAlumno().getLegajo() %>">
	                    <%
	                    	if(axc.getRegularidad()== "Regular")
	                    	{
	                    		%>
	                    		
								    <option value="Regular">REGULAR</option>
								    <option value="Libre" selected>LIBRE</option>
								  	
							<%
							
	                    	}
	                    	else
	                    	{
	                    		%>
	                    		
								    <option value="Regular" selected>REGULAR</option>
								    <option value="Libre">LIBRE</option>
								
						<%
	                    	}
	                    
	                    %>
	                      </select></td>
	<td><%if (axc.isAprobado()){
		
	%>
	
	<input type="radio" name="aprobacion_<%=axc.getAlumno().getLegajo() %>" value="true" checked="checked"> Aprobado<br>
  <input type="radio" name="aprobacion_<%=axc.getAlumno().getLegajo() %>" value="false"> Desaprobado<br>
	
	<%		
	}else {
	%>
	<input type="radio" name="aprobacion_<%=axc.getAlumno().getLegajo() %>" value="true" > Aprobado<br>
  <input type="radio" name="aprobacion_<%=axc.getAlumno().getLegajo() %>" value="false" checked="checked"> Desaprobado<br>
	 
  <%} %>
  
  </td>
	
	
  </tr>
 <%}}%>
 <input type="hidden" name ="id_curso" value="<%=lista.get(0).getCurso().getID() %>">
 <%}%>
  
</table>


<input type="submit" name="btn_guardar" value="Guardar notas">

</form>

</body>
</html>
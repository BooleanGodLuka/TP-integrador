<%@ page import="dominio.Materia"%>
<%@ page import="dominio.Docente"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="EstilosAlta.css" type="text/css" />
		
		<title>Alta de curso</title>
	</head>
	
	<body>
		<jsp:include page="Navegacion.jsp"/>
		<h1>Alta de curso</h1>
		
		<div class="container" >
			<form action="ServletAltaCursos" method="post">
		  
				<label for="meteria"> Materia </label><br>
				<select id="cbMateria" name="materia">
					<option value="empty"> Seleccione una materia </option>
					<%
						List<Materia> listMaterias = null;
						if (request.getAttribute("ListaMaterias") != null) {
							listMaterias = (List<Materia>) request.getAttribute("ListaMaterias");
						}
	
						if (listMaterias != null) {
							for (Materia mat : listMaterias) {
					%>
					
					<option value="<%=mat.getID()%>"> <%=mat.getNombre()%> </option>
					<%
						}
						}
					%>
				</select><br>
			
				<label for="cuatrimestre"> Cuatrimestre </label><br>
				<select id="cbCuatrimestre" name="cuatrimestre">
					<option value="Vacio">-Seleccione un Cuatrimestre-</option>
					<option value="1">1°</option>
					<option value="2">2°</option>
				</select><br>
			    
				<label for="anio"> Año </label><br>
				<select id ="cbAnio" name="anio">
					<option value="empty"> Seleccione una año </option>
					<%
						for(int i=2020; i>2000; i--){
							%><option value ="<%=i%>"> <%=i%> </option><%
						}
					%>
			    </select><br>
			    
				<label for="docente"> Docente </label><br>
				<select id="cbDocente" name="docente">
					<option value="empty"> Seleccione un docente </option>
					<%
						List<Docente> listDocentes = null;
						if (request.getAttribute("ListaDocentes") != null) {
							listDocentes = (List<Docente>) request.getAttribute("ListaDocentes");
						}
	
						if (listDocentes != null) {
							for (Docente doc : listDocentes) {
					%>
					
					<option value="<%=doc.getLegajo()%>"> <%=doc.getNombre()%> </option>
					<%
							}
						}
					%>
				</select><br>
				
			    <input type="submit" name="btnAltaCurso" value="Aceptar"> <br>		  
			</form>
			
			<p>Presione el boton para proseguir con la asignacion de alumnos</p>
		</div>
	</body>
</html>
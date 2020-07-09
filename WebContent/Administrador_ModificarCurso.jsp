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
  <tr>
  	<td><input type="text" name="ID_Curso" placeholder="1"></td>
  	  <td>
    <select id="Materia" name="Materia">
      <option value="">-Seleccione la Materia-</option>
      <option value="">--------</option>
      <option value="LaboratorioIV">Laboratorio IV</option>
      <option value="MetodologiadeSistemasI">Metodologia de Sistemas I</option>
      <option value="DiseñoyAdministraciondeBasedeDatosI">Diseño y Administracion de Base de Datos I</option>
    </select>
    </td>
     
    <td>
    <select id="Cuatrimestre" name="Cuatrimestre">
      <option value="">-Seleccione el Cuatrimestre-</option>
      <option value="">--------</option>
      <option value="Primero">1° Cuatrimestre</option>
      <option value="Segundo">2° Cuatrimestre</option>
    </select>
    </td>
    
    <td>
    <select id="Año" name="Año">
      <option value="">-Seleccione el Año-</option>
      <option value="">--------</option>
      <option value="2020">2020</option>
      <option value="2019">2019</option>
      <option value="2018">2018</option>
      <option value="2017">2017</option>
      <option value="2016">2016</option>
      <option value="2015">2015</option>
	  <option value="2014">2014</option>
	  <option value="2013">2013</option>
      <option value="2012">2012</option>
      <option value="2011">2011</option>
      <option value="2010">2010</option>
      <option value="2009">2009</option>
      <option value="2008">2008</option>
      <option value="2007">2007</option>
      <option value="2006">2006</option>
      <option value="2005">2005</option>
      <option value="2004">2004</option>
      <option value="2003">2003</option>
      <option value="2002">2002</option>
      <option value="2001">2001</option>
      <option value="2000">2000</option>
    </select>
    </td>
    
    <td>
    <select id="Docente" name="Docente">
      <option value="">-Seleccionar Docente-</option>
      <option value="">--------</option>
      <option value="THerrera">Tamara Herrera</option>
      <option value="CFernandez">Claudio Fernandez</option>
      <option value="CJRodriguez">Carlos Javier Rodriguez</option>
    </select>
    </td>
    <td style="text-align:center"> <input type="button" value="Actualizar Curso" name="btn_ModificarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    <td style="text-align:center"> <input type="button" value="Eliminar Curso" name="btn_EliminarCurso"style="BORDER: rgb(128,128,128) 3px solid; WIDTH: 150px; FONT-SIZE: 10pt; FONT-FAMILY: Verdana;"></td>
    
  </tr>

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
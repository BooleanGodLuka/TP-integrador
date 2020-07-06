<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de curso</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<style type="text/css">
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 500px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=date] {
  width: 200px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

</head>
<body>



<jsp:include page="/Otros/Navegacion.html"></jsp:include>

<h3>Alta de curso</h3>

<div class="container" >
  <form action="/action_page.php">
  <label for="fname">ID: "Autonumerico"</label>
  <br><br>
  
    <label for="fname">Materia</label><br>
    <select id="country" name="country">
     <option value="Vacio">-Seleccione una Materia-</option>
      <option value="Laboratorio 2">Laboratorio 2</option>
      <option value="Estadistica">Estadistica</option>
      <option value="Ingles">Ingles</option>
    </select><br>

    <label for="lname">Cuatrimestre</label><br>
    <select id="cuatri" name="cuatri">
    <option value="Vacio">-Seleccione un Cuatrimestre-</option>
     <option value="1">1°</option>
      <option value="2">2°</option>
    </select><br>
    
    <label for="lname">Año</label><br>
    <select id ="año" name="año">
    <option value="Vacio">-Seleccione una Año-</option>
    <option value="1">2020</option>
      <option value="2">2019</option>
      <option value="3">2018</option>
      <option value="4">2017</option>
      <option value="5">2016</option>
    </select><br>
    
<label for="lname">Docente</label><br>
    <select id="Docente" name="Docente">
    <option value="Vacio">-Seleccione un Docente-</option>
     <option value="1">Tamara herrera</option>
      <option value="2">Daniel Kloster</option>
      <option value="3">Maxi Sar</option>
    </select><br>


    <input type="submit" value="Aceptar">
    <br>
    <label for="aclaracion">Presione el boton para proseguir con la asignacion de alumnos</label>
  
  </form>
</div>



</body>
</html>
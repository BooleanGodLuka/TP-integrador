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
<jsp:include page="/Otros/Navegacion.html"></jsp:include>

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
 
<label for="fname">Curso: [INSERTE NOMBRE DE CURSO AQU�]</label>
<br>
<form action="">
<table id="customers">
  <tr>
    <th>Legajo</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Parcial 1</th>
    <th>Recuperatorio</th>
    <th>Parcial 2</th>
    <th>Final</th>
  </tr>
  <tr>
    <td>0001</td>
    <td>Juan</td>
    <td>Perez</td>
    <td><input type="text" id="nota1" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota2" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota3" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota4" name="nota" placeholder="Nota"></td>
  </tr>
  
  <tr>
    <td>0002</td>
    <td>Jose</td>
    <td>Maria</td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
  </tr>
  
  <tr>
    <td>0003</td>
    <td>Luciano</td>
    <td>Gonsalez</td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
  </tr>
  
  <tr>
    <td>0004</td>
    <td>Mario</td>
    <td>Sanprieto</td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
  </tr>
  
  <tr>
    <td>Juan</td>
    <td>Rodriguez</td>
    <td>0005</td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
    <td><input type="text" id="nota" name="nota" placeholder="Nota"></td>
  </tr>
  
</table>
<input type="submit" value="Guardar notas">
</form>

</body>
</html>
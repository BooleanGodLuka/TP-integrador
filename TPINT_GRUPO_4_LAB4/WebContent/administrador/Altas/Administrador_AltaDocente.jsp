<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Docente</title>
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

<h3>Alta de Docente</h3>

<div class="container" >
  <form action="/action_page.php">
  <label for="fname">Legajo: "Autonumerico"</label>  <br>  <br>
    
	    <label for="txtNombre">Nombre/s</label><br>
	    <input type="text" id="txtNombre" name="nombre" placeholder="Nombres"><br>
	
	    <label for="txtApellido">Apellido/s</label><br>
	    <input type="text" id="txtApellido" name="apellido" placeholder="Apellidos"><br>
	    
	    <label for="txtDni">DNI</label><br>
	    <input type="text" id="txtDni" name="dni" placeholder="DNI"><br>
	    
	    <label for="dateFechaNacimiento">Fecha de nacimiento:</label><br>
		<input type="date" id="dateFechaNacimiento" name="fechaNacimiento"><br>
	
    <label for="txtEmail">Email</label><br>
    <input type="text" id="txtEmail" name="email" placeholder="email@ejemplo.com"><br>

    <label for="txtTelefono">Telefono</label><br>
    <input type="text" id="txtTelefono" name="telefono" placeholder="Telefono"><br>

    <label for="cbProvincia">Provincia</label><br>
    <select id="cbProvincia" name="provincia">
     <option value="Vacio">-Seleccione una Provincia-</option>
      <option value="BsAs">Buenos Aires</option>
      <option value="Santa Fe">Santa Fe</option>
      <option value="Chubut">Chubut</option>
    </select><br>
    
    <label for="cbLocalidad">Localidades</label><br>
    <select id="cbLocalidad" name="localidad">
		<option value="Vacio">-Seleccione una Localidad-</option>
		<option value="Pacheco">Pacheco</option>
		<option value="San Isidro">San Isidro</option>
		<option value="Capital Federal">Capital Federal</option>
    </select><br>

    <input type="submit" value="Aceptar">
  
  </form>
</div>



</body>
</html>
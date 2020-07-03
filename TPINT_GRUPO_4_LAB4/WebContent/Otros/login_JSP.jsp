<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesion</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">
</head>
<body>



<form method="post" action="Usuario_servlet">
<div class='bold-line'></div>
<div class='container'>
  <div class='window'>
    <div class='overlay'></div>
    <div class='content'>
      <div class='welcome'>Bienvenido!</div> <br>
      <div class='subtitle'>Por favor ingrese con sus credenciales</div>
      <div class='input-fields'>
        <input type='text' placeholder='Usuario' class='input-line full-width' name="txtUser" required></input> 
        <br> <br> 
        <input type='password' placeholder='Contraseņa' class='input-line full-width' name="txtPassword" minlength="6" required></input>

      </div>
      <div><br><br><button class='ghost-round full-width' name="btnAceptar">Aceptar</button></div>
    </div>
  </div>
</div>
</form>




</body>
</html>
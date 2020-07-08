<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Menu Administador</title>
<link rel="StyleSheet" href="HojaEstilos.css" type="text/css">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}
</style>




</head>
<body>

<jsp:include page="Navegacion.html"></jsp:include>



<form class="w3-container w3-red w3-center" style="padding:128px 16px">
<div class="about-section">
  <h1>Bienvenido!</h1> <br>
  <h3>Acerca de nosotros</h3> <br>
  <p>Somos una web administrativa para ayudar a la organizacion de la cursada y educativa</p>
</div>
</form>




</body>
</html>
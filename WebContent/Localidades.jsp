<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<script type="text/javascript">
				$(document).ready(function llenarLocalidades(){
					$('#slctProvincia').on('change', function(){
						var provincia = $("#slctProvincia option:selected").val();
						$.ajax({
							type: 'POST',
							data: {prov: provincia},
							url: 'ServletLocalidades',
							success: function(result){
								$('#slctLocalidad').html(result);
							}
						});
					});
				});
					
				</script>
</body>
</html>
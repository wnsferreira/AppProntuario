<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Atendimento</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
	
		<h2>Cadastro de atendimentos</h2>	
		<form action="/atendimento/incluir" method="post">
		
			<div class="form-group">
	      		<label>Descrição:</label> 
				<input type="text" placeholder="Entre com a especialização" name="descricao">
			</div>
						
			<div class="form-group">
	      		<label>Honorario:</label> 
				<input type="text"  placeholder="Entre com o valor" name="honorario">
			</div>
					
				<button type="submit">Cadastrar</button>
			
		</form>
	</div>
</body>
</html>
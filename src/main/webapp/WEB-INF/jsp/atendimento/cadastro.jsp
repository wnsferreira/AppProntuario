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
	
	<h2>Cadastro de atendimentos</h2>	
	<form action="/atendimento/incluir" method="post">
		
		<h3> 
			Descrição: <input type="text" placeholder="Entre com a especialização" name="descricao">
		</h3>
		
		<h3> 
			Honorario: <input type="text"  placeholder="Entre com o valor" name="honorario">
		</h3>
				
		<h3>
			<button type="submit">Cadastrar</button>
		</h3>
	</form>
</body>
</html>
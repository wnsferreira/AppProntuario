<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<h2>Cadastro de usuários</h2>	
	<form action="/solicitante/incluir" method="post">
		
		<h3> 
			Nome: <input type="text" placeholder="Entre com o seu nome" name="nome">
		</h3>
		<h3>
			Idade: <input type="text"  placeholder="Entre com a sua idade" name="idade">
		</h3>
		<h3> 
			Email: <input type="email"  placeholder="Entre com o seu email" name="email">
		</h3>	
		<h3>
			<button type="submit">Cadastrar</button>
		</h3>
	</form>
</body>
</html>
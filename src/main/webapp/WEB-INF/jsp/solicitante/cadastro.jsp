<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
	
		<h2>Cadastro de usuários</h2>	
		<form action="/solicitante/incluir" method="post">
			
			<div class="form-group">
	      		<label>Nome:</label> 
				<input type="text" placeholder="Entre com o seu nome" name="nome">
			</div>
			
			<div class="form-group">
	      		<label>Idade:</label>
				<input type="text"  placeholder="Entre com a sua idade" name="idade">
			</div>
			
			<div class="form-group">
	      		<label>Email:</label> 
				<input type="email"  placeholder="Entre com o seu email" name="email">
			</div>
			
				<button type="submit">Cadastrar</button>
		
		</form>
	</div>
</body>
</html>
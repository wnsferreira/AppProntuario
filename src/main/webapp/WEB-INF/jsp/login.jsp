<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		
	<c:if test="${not empty mensagem}">
		<div class="alert alert-danger">
 				<strong>Problema!</strong> ${mensagem}
		</div>	
	</c:if>
	
	<h2>AUTENTICAÇÃO</h2>	
	<form action="/login" method="post">
	  
	  	<div class="form-group">
	    	<label for="email">Email:</label>
	    	<input type="email" class="form-control" placeholder="Entre com o seu email" name="email">    
	  	</div>
	  	<div class="form-group">
	    	<label for="pwd">Senha:</label>
	    	<input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha">
	  	</div>
	 
	  	<button type="submit" class="btn btn-default">Entrar</button>
	  	
	</form>
</body>
</html>
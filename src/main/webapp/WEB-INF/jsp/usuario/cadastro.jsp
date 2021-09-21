<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Cadastro</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
		
	<c:if test="${not empty mensagem}">
		<div class="alert alert-danger">
 				<strong>Problema!</strong> ${mensagem}
		</div>	
	</c:if>
	
	<h2>Cadastramento de usuários</h2>	
	
		<form action="/cep" class="form-inline" method="post">
			<div class="form-group">
	    		<label for="email">Cep:</label>
	    		<input type="text" class="form-control" placeholder="Entre com o seu nome" name="cep">    
	  		</div>
	  		<button type="submit" class="btn btn-primary">Buscar</button>
  		</form>
	
	<form action="/usuario" method="post">
	  
	    	
	  	<div class="form-group">
	    	<label for="email">Nome:</label>
	    	<input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">    
	  	</div>
	  	<div class="form-group">
	    	<label for="email">Email:</label>
	    	<input type="email" class="form-control" placeholder="Entre com o seu email" name="email">    
	  	</div>
	  	<div class="form-group">
	    	<label for="pwd">Senha:</label>
	    	<input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha">
	  	</div>
	  	
	  	<c:import url="/WEB-INF/jsp/endereco.jsp"></c:import>
	  	 
	  		
	  	<button type="submit" class="btn btn-default">Cadastrar</button>
	  	
	</form>
</body>
</html>
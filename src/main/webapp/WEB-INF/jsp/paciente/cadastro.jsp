<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Cadastro de usuários</h2>	
	<form action="/paciente/incluir" method="post">
		
		<h3> 
			Nome: <input type="text" placeholder="Entre com o seu nome" name="nome">
		</h3>
		
		<h3> 
			Email: <input type="email"  placeholder="Entre com o seu email" name="email">
		</h3>
		
		<h3>
			Senha: <input type="text"  placeholder="Entre com a sua senha" name="senha">
		</h3>
	
		<h3>
			<button type="submit">Cadastrar</button>
		</h3>
	</form>
</body>
</html>
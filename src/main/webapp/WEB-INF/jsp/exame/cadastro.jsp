<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exame</title>
</head>
<body>
	<h2>Cadastro de Exame</h2>	
	<form action="/exame/incluir" method="post">
		
		<h3> 
			Tipo de exame: <input type="text" placeholder="Entre com a descrição" name="tipoExame">
		</h3>
		<h3> 
			Data: <input type="text" placeholder="Entre com a data" name="data">
		</h3>
		<h3> 
			Resultado: <input type="text" placeholder="Entre com a data" name="resultado">
		</h3>
				
		<h3> 
			<input class="checkbox-inline"><input type="checkbox" name="particular">Particular</label>
			<input class="checkbox-inline"><input type="checkbox" name="planoDeSaude">Plano de Saúde</label>
		
		</h3>	
		<h3>
			<button type="submit">Cadastrar</button>
		</h3>
	</form>
</body>
</html>
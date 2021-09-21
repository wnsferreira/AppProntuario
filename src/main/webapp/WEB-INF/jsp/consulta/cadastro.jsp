<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendamento de Consulta</title>
</head>
<body>
	<h2>Cadastro de consulta</h2>	
	<form action="/consulta/incluir" method="post">
		
		<h3> 
			Descrição: <input type="text" placeholder="Entre com a descrição" name="descricao">
		</h3>
		<h3> 
			Data marcada: <input type="text" placeholder="Entre com a data" name="dataMarcada">
		</h3>
		<h3> 
			Hora Marcada: <input type="text" placeholder="Entre com a data" name="horaMarcada">
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
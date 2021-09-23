<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Exame</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
	
		<h2>Cadastro de Exame</h2>	
		<form action="/exame/incluir" method="post">
			
			<div class="form-group">
	      		<label>Tipo de exame:</label>
				<input type="text" placeholder="Entre com a descrição" name="tipoExame">
			</div>
			
	<!-- 		<h3>  -->
	<!-- 			Data: <input type="text" placeholder="Entre com a data" name="data"> -->
	<!-- 		</h3> -->
	<!-- 		<h3>  -->
	<!-- 			Resultado: <input type="text" placeholder="Entre com o resultado" name="resultado"> -->
	<!-- 		</h3> -->
	
			<div class="form-group">
	      		<label>Descrição:</label>
				<input type="text" placeholder="Entre com o seu tipo sanguineo" name="descricao">
			</div>
					
			<div class="form-group">
	      		<label>Forma de pagamento:</label>
					<label class="checkbox-inline"><input type="checkbox" name="particular">Particular</label>
					<label class="checkbox-inline"><input type="checkbox" name="planoDeSaude">Plano de Saúde</label>
			
			</div>	
			
				<button type="submit">Cadastrar</button>
			
		</form>
	</div>
</body>
</html>
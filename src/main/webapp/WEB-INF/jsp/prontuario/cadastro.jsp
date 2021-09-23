<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Cadastro prontuario</title>
</head>
<body>
	
	<c:set var="botao" value=""></c:set>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
	
		<h2>Cadastro de Prontuário</h2>	
		<form action="/prontuario/incluir" method="post">
			
			<div class="form-group">
				<c:if test="${not empty solicitantes}">
					<label>Solicitante</label>
					<select class="form-control" name="solicitante.id">
						<c:forEach var="s" items="${solicitantes}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty solicitantes}">
					<c:set var="botao" value="disabled"></c:set>
					<label>Solicitante: não existem registros cadastrados!</label>
				</c:if>	
			</div>
			
			<div class="form-group">
				<label>Descrição:</label>
					<input value="Primeiro prontuario" type="text" placeholder="Entre com a descrição" name="descricao">
			</div>
			
			<div class="form-group">
				<c:if test="${not empty pedidos}">
					<label>Pedidos</label>
					<c:forEach var="p" items="${pedidos}">
						<div class="form-check">
							<label class="for-check-label">
							<input name="pedidosId" type="checkbox"  checked="checked" value="${p.id}">${p.descricao}
							</label>
						</div>
					</c:forEach>
				</c:if>	
				<c:if test="${empty pedidos}">
					<c:set var="botao" value="disabled"></c:set>
					<label>Pedidos: não existem registros cadastrados!</label>
				</c:if>	
			</div>
				<button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</body>
</html>
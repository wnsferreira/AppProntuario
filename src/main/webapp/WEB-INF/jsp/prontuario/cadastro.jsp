<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="botao" value=""></c:set>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
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
		
		<h3> 
			Descrição: <input type="text" placeholder="Entre com a descrição" name="descricao">
		</h3>
		
		<div class="form-group">
			<c:if test="${not empty pedidos}">
				<label>Pedidos</label>
				<c:forEach var="p" items="${pedidos}">
					<div class="form-check">
						<label class="for-check-label">
						<input name="pedidosId" type="checked"  checked="checked" value="${p.id}">${p.descricao}
						</label>
					</div>
				</c:forEach>
			</c:if>	
			<c:if test="${empty pedidos}">
				<c:set var="botao" value="disabled"></c:set>
				<label>Pedidos: não existem registros cadastrados!</label>
			</c:if>	
		</div>
		
		<h3>
			<button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
		</h3>
	</form>
</body>
</html>
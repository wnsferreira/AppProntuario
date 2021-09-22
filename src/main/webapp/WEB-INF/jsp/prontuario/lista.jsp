
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
		
		<form action="/prontuario" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
				
		<c:if test="${not empty lista}">
				<c:if test="${not empty msg}">
					<div class="alert alert-success">
 						<strong>Sucesso!</strong> ${msg}
					</div>	
				</c:if>
				
			<h3>Quantidade de prontuarios existentes: ${lista.size()}!</h3>
			
			<hr>
		        	
		  <table class="table table-striped">
		    <thead>
		      <tr>
		     	 <th>Id</th>
		        <th>Descrição</th>
		        <th>Solicitante</th>
		        <th>Pedidos</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="p" items="${lista}">
					<tr>
						<td>${p.id}</td>
						<td>${p.descricao}</td>
				        <td>${p.solicitante.nome}</td>
				        <td>${p.pedidos.size()}</td>
				        <td><a href="/prontuario/${p.id}/excluir"> Excluir</a></td>
					</tr>		    	
		    	</c:forEach>		     
		    </tbody>
		  </table>
	  </c:if>
	  
	  <c:if test="${empty lista}">
	  	<h4>Não existem prontuários cadastrados!</h4>
	  </c:if>
	  
	</div>
		
		
	<form action="/prontuario" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendamento de Exame</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
		
		<form action="/exame" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
				
		<c:if test="${not empty exames}">
				<c:if test="${not empty msg}">
					<div class="alert alert-success">
 						<strong>Sucesso!</strong> ${msg}
					</div>	
				</c:if>
				
			<h3>Quantidade de exames existentes: ${exames.size()}!</h3>
			
			<hr>
		        
		  <table class="table table-striped">
		    <thead>
		      <tr>
		     	<th>Id</th>
		     	<th>Tipo de exame</th>
		        <th>Data</th>
		        <th>Resultado</th>		        
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="e" items="${exames}">
					<tr>
						<td>${e.id}</td>
						<td>${e.tipoExame}</td>
						<td>${e.data}</td>
				        <td>${e.resultado}</td>
				        <td><a href="/exame/${e.id}/excluir"> Excluir</a></td>				        
					</tr>		    	
		    	</c:forEach>		     
		    </tbody>
		  </table>
	  </c:if>
	  
	  <c:if test="${empty exames}">
	  	<h4>Não existem exames cadastrados!</h4>
	  </c:if>
	  
	</div>
		
		
	<form action="/exame" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>
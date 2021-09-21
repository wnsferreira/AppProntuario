
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendamento de Consulta</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<div class="container">
		
		<form action="/consulta" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
				
		<c:if test="${not empty consultas}">
				<c:if test="${not empty msg}">
					<div class="alert alert-success">
 						<strong>Sucesso!</strong> ${msg}
					</div>	
				</c:if>
				
			<h3>Quantidade de consultas existentes: ${consultas.size()}!</h3>
			
			<hr>
		        
		  <table class="table table-striped">
		    <thead>
		      <tr>
		     	<th>Id</th>
		     	<th>descricao</th>
		        <th>Data</th>
		        <th>Hora</th>
		        <th>Convênio</th>
		         <th>Plano de saúde</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="c" items="${consultas}">
					<tr>
						<td>${c.id}</td>
						<td>${c.descricao}</td>
						<td>${c.dataMarcada}</td>
				        <td>${c.horaMarcada}</td>
				        <td>${c.convenio}</td>
				        <td>${c.planoDeSaude}</td>
				        <td><a href="/consulta/${c.id}/excluir"> Excluir</a></td>
					</tr>		    	
		    	</c:forEach>		     
		    </tbody>
		  </table>
	  </c:if>
	  
	  <c:if test="${empty consultas}">
	  	<h4>Não existem consultas cadastrados!</h4>
	  </c:if>
	  
	</div>
		
		
	<form action="/consulta" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppProntuario</title>
<meta charset="utf-8">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
		
	<div class="container">
		<h3>Java WEB</h3>
		<h4>AT</h4>
		
		<ul class="list-group">
	    <li class="list-group-item">Usuário <span class="badge">12</span></li>
	    <li class="list-group-item">Solicitante <span class="badge">5</span></li>
	    <li class="list-group-item">Consulta <span class="badge">3</span></li>
	    <li class="list-group-item">Atendimento <span class="badge">3</span></li>
	    <li class="list-group-item">Exame <span class="badge">3</span></li>
	    <li class="list-group-item">Prontuário <span class="badge">3</span></li>
 		 </ul>
		
	</div>
	
</body>
</html>
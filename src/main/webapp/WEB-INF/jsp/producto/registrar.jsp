<%@page import="pe.edu.tecsup.tienda.entities.Categoria"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>

	<%@include file="/WEB-INF/jsp/includes/head.jsp"%>
	<meta charset="UTF-8">
	<title>Registrar Servlet</title>
</head>
<body>

	<%@include file="/WEB-INF/jsp/includes/navbar.jsp"%>

	<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias"); %>

	<%=categorias %>
	
	
</body>
</html>
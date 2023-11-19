
<%@page import="pe.edu.tecsup.tienda.entities.Producto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/includes/head.jsp"%>
<meta charset="UTF-8">
<title>Carrito Ofertar</title>
</head>
<body>

	<%@include file="/WEB-INF/jsp/includes/navbar.jsp"%>


	<div class="container-fluid pt-3">
		<div class="display-4 mb-3">Catálogo de Productos</div>
		<c:if test="${sessionScope.success != null}">
			<div class="alert alert-success">
				<c:out value="${sessionScope.success}" />
			</div>
			<c:remove var="success" />
		</c:if>


		<div class="row">
		
			<c:forEach items="${productos}" var="producto">
		
				<div class="col-sm-4 col-md-3">
		
					<div class="card shadow mb-3">
		
						<div class="card-header">
							<c:out value="${producto.categoria.nombre}"></c:out>
						</div>
		
						<c:if test="${producto.imagen_nombre != null}">
							<img
								src="<%=request.getContextPath()%>/files/<c:out value="${producto.imagen_nombre}"/>"
								alt="" width="100%">
						</c:if>
						<div class="card-body">
							<p>
								<c:out value="${producto.nombre}"></c:out>
							</p>
							<p>
								<b>S/<c:out value="${producto.precio}"></c:out></b>
							</p>
						</div>
						<div class="card-footer">
							<a href="<%=request.getContextPath()%>/CarritoComprarServlet?id=<c:out value="${producto.id}"/>"
							   class="btn btn-primary">
								<i class="fa fa-shopping-cart"></i>Comprar
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>
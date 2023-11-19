<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/includes/head.jsp"%>
</head>
<body>

	<%@include file="/WEB-INF/jsp/includes/navbar.jsp"%>


	<div class="container-fluid pt-3">

		<div class="display-4 mb-3">Productos en Carrito</div>

		<c:if test="${sessionScope.success != null}">
			<div class="alert alert-success">
				<c:out value="${sessionScope.success}" />
			</div>
			<c:remove var="success" />
		</c:if>


		<div class="card">
			<div class="card-header">Lista de Productos</div>
			<div class="card-body">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>ID</th>
							<th>NOMBRE</th>
							<th>CATEGORÍA</th>
							<th>PRECIO</th>
							<th>IMAGEN</th>
							<th width="300"></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${productosCarrito}" var="producto">
							<tr>
								<td><c:out value="${producto.id}" /></td>
								<td><c:out value="${producto.nombre}" /></td>
								<td><c:out value="${producto.categoria.nombre}" /></td>
								<td><c:out value="${producto.precio}" /></td>
								<td><c:if test="${producto.imagen_nombre != null}">
										<img
											src="<%=request.getContextPath()%>/files/<c:out value="${producto.imagen_nombre}"/>"
											alt="" height="30">
									</c:if>
								<td class="text-right"><a href="#"
									class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>Retirar</a></td>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
			<div class="card-footer">
				<a href="#" class="btn btn-success"><i
					class="fa fa-shopping-cart"></i> Pagar</a> <a
					href="<%=request.getContextPath()%>/CarritoOfertarServlet"
					class="btn btn- secondary"> <i class="fa fa-chevron-left"></i>Seguir
					Comprando
				</a>
			</div>
		</div>
	</div>


</body>
</html>
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

	<%
	List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
	%>

	<div class="container-fluid pt-3">
		<div class="display-4 mb-3">Mantenimiento de Productos</div>
		<form action="<%=request.getContextPath()%>/ProductoRegistrarServlet"
			method="post">
			<div class="card">
				<div class="card-header">Registro de Producto</div>
				<div class="card-body">
					<div class="form-group">
						<label for="nombre">Nombre</label> <input type="text"
							name="nombre" id="nombre" class="form-control" maxlength="100"
							required>
					</div>
					<div class="form-group">
						<label for="categorias_id">Categoría</label> <select
							name="categorias_id" id="categorias_id" class="form-control"
							required>
							<option value="" selected disabled>Seleccione un valor</option>
							<%
							for (Categoria categoria : categorias) {
							%>
								<option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
							<%
							} // end foe 
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="precio">Precio</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">S/</div>
							</div>
							<input type="number" name="precio" id="precio"
								class="form-control" min="0" step="0.01">
						</div>
						<div class="form-group">
							<label for="stock">Stock</label> <input type="number"
								name="stock" id="stock" class="form-control" min="0">
						</div>
						<div class="form-group">
							<label for="imagen">Imagen</label>
							<div class="custom-file">

								<input type="file" id="imagen" name="imagen"
									class="custom-file-input" /> <label class="custom-file-label"
									for="foto">Seleccionar archivo</label>
							</div>
						</div>
						<div class="form-group">
							<label for="descripcion">Descripción</label>
							<textarea name="descripcion" id="descripcion"
								class="form-control ckeditor" rows="5"></textarea>
						</div>
					</div>
					<div class="card-footer">
						<button  type="submit" class="btn btn-primary">Guardar</button>
						<a id="linkGrabar"  href="<%=request.getContextPath()%>/ProductoListarServlet"
							class="btn btn- secondary">Cancelar</a>
					</div>
				</div>
		</form>
	</div>


</body>
</html>
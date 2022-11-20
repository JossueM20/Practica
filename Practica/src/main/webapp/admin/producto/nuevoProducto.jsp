<%@page import="com.productos.model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo</title>
<link href="css/estilos.css?1.0" rel="stylesheet" type="text/css">
</head>
<body>


	<nav>
		<a href="index.jsp">Inicio</a> <a
			href="ProductoController?accion=catalogo">Catalogo</a> <a
			href="ProductoController?accion=list">Ver Productos</a> <a
			href="ProductoController?accion=add">Registrar Producto</a> <a
			href="ProductoController?accion=add">Formulario</a> <a
			href="ProductoController?accion=list2">Ventas</a>
	</nav>

	<%
	ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("listaCategorias");
	%>

	<div>
		<h1 class="text-black">Producto: Agregar</h1>
		<hr>

		<div>
			<form action="ProductoController" method="POST"
				enctype="multipart/form-data">
				<div>
					<label for="categoria_id">Categoria</label>
					<div>
						<select name="categoria_id" required>
							<%
							for (Categoria item : categorias) {
							%>
							<option value="<%=item.getId()%>">
								<%=item%>
							</option>
							<%
							}
							%>
						</select>
					</div>
				</div>
				<br>

				<div>
					<label for="nombre">Nombre</label>
					<div>
						<input name="nombre" type="text" required>
					</div>
				</div>
				<br>

				<div>
					<label for="cantidad">Cantidad</label>
					<div>
						<input name="cantidad" type="number" min="0" required>
					</div>
				</div>
				<br>

				<div>
					<label for="precio">Precio</label>
					<div>
						<input name="precio" type="number" min="0" step="0.01" required>
					</div>
				</div>
				<br>

				<div>
					<label for="fileFoto">Imagen del producto</label>
					<div>
						<input name="fileFoto" type="file" required>
					</div>
				</div>
				<br>

				<div>
					<input name="accion" type="submit" value="Registrar">
				</div>

			</form>
		</div>
	</div>
</body>
</html>
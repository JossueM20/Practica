<%@page import="com.productos.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Consultar</title>
<link href="css/estilos.css?1.0" rel="stylesheet" type="text/css">

<style>
th, td {
	border: 1px solid;
}
</style>

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
	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("listaProductos");
	%>
	
	

	<div>
		<h1 class="text-black">Producto</h1>
		<div>

			<a href="ProductoController?accion=list">Consultar todos</a> <br>
			<a href="ProductoController?accion=list_by_categoria">Consultar
				por categorías</a> <br>
		</div>
		<hr>

		<div>
			<p><%=request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : ""%></p>
		</div>

		<div>
			<table class="table">
				<thead>
					<th>ID</th>
					<th>Producto</th>
					<th>Cantidad</th>
					<th>Precio</th>
					<th>Categoría</th>
					<th>Imagen</th>
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<%
					for (Producto item : productos) {
					%>
					<tr>
						<td><%=item.getId()%></td>
						<td><%=item.getNombre()%></td>
						<td><%=item.getCantidad()%></td>
						<td><%=item.getPrecio()%></td>
						<td><%=item.getCategoria()%></td>
						<td><img src="ImagenController?id=<%=item.getId()%>"
							width="80" height="80"></td>
						<td><a
							href="ProductoController?accion=edit&id=<%=item.getId()%>">Modificar</a></td>
						<td><a
							href="ProductoController?accion=delete&id=<%=item.getId()%>">Eliminar</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>
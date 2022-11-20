<%@page import="com.productos.model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Consultar categoria</title>
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
		<h1 class="text-black">Producto: Buscar por categoría</h1>
		<div>
			<a href="ProductoController?accion=list">Consultar todos</a> <br>
			<a href="ProductoController?accion=list_by_categoria">Consultar
				por categorías</a> <br>
		</div>
		<hr>
		<div>
			<form action="ProductoController" method="POST">
				<label>Escoja la categoría </label> <select name="categoria_id">
					<%
					for (Categoria item : categorias) {
					%>
					<option value="<%=item.getId()%>">
						<%=item%>
					</option>
					<%
					}
					%>
				</select> <input type="submit" name="accion" value="Buscar">
			</form>
		</div>
	</div>
</body>

</html>
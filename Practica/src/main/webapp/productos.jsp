<%@page import="com.productos.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Productos</title>

<link href="css/estilos.css?1.0" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>

<body>

	<%
	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("listaProductos");
	%>

	<main>


		<nav>
			<a href="index.jsp">Inicio</a> <a
				href="ProductoController?accion=catalogo">Catalogo</a> <a
				href="ProductoController?accion=list">Ver Productos</a> <a
				href="ProductoController?accion=add">Registrar Producto</a> 
		</nav>

		<div class="container-fluid">
			<h3 class=pp2>Modelos Populares</h3>

			<div class="row">
				<%
				for (Producto item : productos) {
				%>
				<div class="col-md-4">
					<h3 class=pp1><%=item.getNombre()%>
					</h3>
					<p>
						<%=item.getPrecio()%>$
					</p>
					<img class="img-fluid" src="ImagenController?id=<%=item.getId()%>"
						width="200" height="200" />
				</div>
				<%
				}
				%>
			</div>
		</div>
	</main>
</body>
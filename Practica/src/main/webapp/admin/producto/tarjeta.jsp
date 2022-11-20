<%@page import="com.productos.model.Categoria"%>
<%@page import="com.productos.model.Usuarios"%>
<%@page import="com.productos.model.Producto"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos tarjeta</title>
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
	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("listaProductos");
	%>
	
	<%
	ArrayList<Usuarios> usuario = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
	%>

	<div>
		<h1 class="text-black">Datos tarjeta</h1>
		<hr>

		<div>
			<form action="mensaje.jsp" method="POST"
				enctype="multipart/form-data">

				<div>
					<label for="num_tarjeta">Numero de tarjeta</label>
					<div>
						<input name="nombre" type="text" required>
					</div>
				</div>
				<br>

				<div>
					<label for="nombre">Nombre Titular</label>
					<div>
						<input name="nombre" type="text" required>
					</div>
				</div>
				<br>
				
				<div>
					<label for="fecha vencimiento">Fecha Vencimiento</label>
					<div>
						<input name="nombre" type="text" required>
					</div>
				</div>
				<br>

				<div>
					<label for="cantidad">CVV</label>
					<div>
						<input name="cantidad" type="number" min="0" required>
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
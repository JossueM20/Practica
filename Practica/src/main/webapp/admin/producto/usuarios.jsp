<%@page import="com.productos.controller.Usuario"%>
<%@page import="com.productos.model.Producto"%>
<%@page import="com.productos.model.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
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
			href="ProductoController?accion=listU">Ventas</a>
	</nav>

	<%
	ArrayList<Usuarios> usuario = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
	%>
	

	<div>
		<h1 class="text-black">Usuarios</h1>
		
		<hr>

		<div>
			<table class="table">
				<thead>
					<th>Nombre</th>
					<th>Cedula</th>
					<th>Contraseña</th>
					<th>Estado</th>
					<th>Residencia</th>
					<th>Fecha Nacimiento</th>
					<th>Color</th>
					<th>Email</th>
				</thead>
				<tbody>
					<%
					for (Usuarios item : usuario) {
					%>
					<tr>
						<td><%=item.getNombre() %></td>
						<td><%=item.getCedula() %></td>
						<td><%=item.getPass() %></td>
						<td><%=item.getEstado() %></td>
						<td><%=item.getResidencia() %></td>
						<td><%=item.getFechaNac() %></td>
						<td><%=item.getColor() %></td>
						<td><%=item.getEmail() %></td>		
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
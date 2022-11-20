<%@page import="com.productos.model.Categoria"%>
<%@page import="com.productos.model.Usuarios"%>
<%@page import="com.productos.model.Producto"%>
<%@page import="com.productos.dao.UsuariosDao"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venta</title>
<link href="css/estilos.css?1.0" rel="stylesheet" type="text/css">
</head>
<body>
	<nav>
		<a href="index.jsp">Inicio</a> <a
			href="ProductoController?accion=catalogo">Catalogo</a> <a
			href="ProductoController?accion=list">Ver Productos</a> <a
			href="ProductoController?accion=add">Registrar Producto</a> <a
			href="ProductoController?accion=add">Formulario</a> <a
			href="ProductoController?accion=listP">Ventas</a>
	</nav>
	
	<%
	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("listaProdu");
	%>
	
	<%
	ArrayList<Usuarios> usuario = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
	%>

	<div>
		<h1 class="text-black">Ventas</h1>
		<hr>

		<div>
			<form action="admin/producto/tarjeta.jsp" method="POST"
				enctype="multipart/form-data">
			
				
				<div>
					<label for="nombre">Usuario</label>
					<div>
						<input name="user" type="text" required>
					</div>
				</div>
				<br>
				
				
				<div>
					<label for="producto_id">Productos</label>
					<div>
						<select name="producto_id" required>
							<%
							for (Producto item : productos) {
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
					<label for="cantidad">Cantidad</label>
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
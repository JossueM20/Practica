<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<header>
		<title>Mr. Josue</title>
		<link href="css/estilos.css?1.0" rel="stylesheet" type="text/css">

		<h1>Mr. Josue</h1>

	</header>

	<nav>
		<a href="index.jsp">Inicio</a> <a
			href="ProductoController?accion=catalogo">Catalogo</a> <a
			href="ProductoController?accion=list">Ver Productos</a> <a
			href="ProductoController?accion=add">Registrar Producto</a> <a
			href="ProductoController?accion=add">Formulario</a> <a
			href="ProductoController?accion=listP">Ventas</a> <a
			href="ProductoController?accion=listU">Usuarios</a>
	</nav>

	<div>
		<section>
			<h3 class=pp2>Sobre Nosotros.</h3>
			<p>La marca Mr Josue, es un referente en moda joven. Se trata de
				una firma que ha conseguido un éxito continuo gracias a sus diseños
				coloristas y sus divertidas prendas de vestir.</p>

			<img src="imagenes/mrjossue.jpg" width="400" height="400" />
		</section>

		<aside>
			<img src="imagenes/masinfo.png" width="150" height="100" />
			<p></p>
			<a class=pp1 href="informacion.jsp">Ver mas informacion </a>
		</aside>
	</div>

	<footer>
		<a target="_blank" href="https://www.facebook.com/jossuesebastian23/">Facebook</a>
		<a target="_blank" href="https://www.instagram.com/jossue.sebastian/">Instagram</a>
	</footer>

</body>
</html>
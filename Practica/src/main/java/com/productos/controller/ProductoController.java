package com.productos.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.productos.dao.CategoriaDao;
import com.productos.dao.ProduDao;
import com.productos.dao.ProductoDao;
import com.productos.dao.UsuariosDao;
import com.productos.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoController")
@MultipartConfig
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String list = "admin/producto/todos.jsp";
	String list_by_categoria = "admin/producto/consultaCategoria.jsp";
	String resultado = "admin/producto/resultado.jsp";
	String add = "admin/producto/nuevoProducto.jsp";
	String edit = "admin/producto/editarProducto.jsp";
	String catalogo = "productos.jsp";
	String listP = "admin/producto/venta.jsp";
	String listU = "admin/producto/usuarios.jsp";
	Part part;
	InputStream inputStream;
	Producto object;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = "";
		try {
			String action = request.getParameter("accion");
			switch (action) {
			case "list":
				acceso = list;
				request.setAttribute("listaProductos", ProductoDao.list());
				break;
			case "add":
				acceso = add;
				request.setAttribute("listaCategorias", CategoriaDao.list());
				break;
			case "edit":
				acceso = edit;
				request.setAttribute("listaCategorias", CategoriaDao.list());
				request.setAttribute("producto", ProductoDao.search(Integer.parseInt(request.getParameter("id"))));
				break;
			case "delete":
				if (ProductoDao.delete(Integer.parseInt(request.getParameter("id")))) {
					acceso = list;
					request.setAttribute("mensaje", "Éxito! Producto eliminado correctamente");
				} else {
					acceso = list;
					request.setAttribute("mensaje", "Error! No se pudo eliminar el producto");
				}
				request.setAttribute("listaProductos", ProductoDao.list());
				break;
			case "list_by_categoria":
				acceso = list_by_categoria;
				request.setAttribute("listaCategorias", CategoriaDao.list());
				break;
			case "catalogo":
				acceso = catalogo;
				request.setAttribute("listaProductos", ProductoDao.list());
				break;
			case "listU":
				acceso = listU;
				request.setAttribute("listaUsuarios", UsuariosDao.listU());
				break;
			case "listP":
				acceso = listP;
				request.setAttribute("listaProdu", ProduDao.listP());
				break;
			default:
				acceso = list;
				request.setAttribute("listaProductos", ProductoDao.list());
				break;
			}
		} catch (Exception e) {
			acceso = list;
			request.setAttribute("listaProductos", ProductoDao.list());
		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = "";
		try {
			String action = request.getParameter("accion");
			switch (action) {
			case "Registrar":
				object = new Producto();
				object.setCategoria(CategoriaDao.search(Integer.parseInt(request.getParameter("categoria_id"))));
				object.setNombre(String.valueOf(request.getParameter("nombre")));
				object.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
				object.setPrecio(Double.parseDouble(request.getParameter("precio")));

				part = request.getPart("fileFoto");
				inputStream = part.getInputStream();
				object.setImagen(inputStream);

				if (ProductoDao.add(object)) {
					acceso = list;
					request.setAttribute("listaProductos", ProductoDao.list());
					request.setAttribute("mensaje", "Éxito! Producto registrado correctamente");
				} else {
					acceso = add;
					request.setAttribute("listaCategorias", CategoriaDao.list());
					request.setAttribute("mensaje", "Error! No se pudo registrar el producto");
				}
				break;
			case "Actualizar":
				object = new Producto();
				object.setId(Integer.parseInt(request.getParameter("id")));
				object.setCategoria(CategoriaDao.search(Integer.parseInt(request.getParameter("categoria_id"))));
				object.setNombre(String.valueOf(request.getParameter("nombre")));
				object.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
				object.setPrecio(Double.parseDouble(request.getParameter("precio")));

				part = request.getPart("fileFoto");
				inputStream = part.getInputStream();
				System.out.println(part.getSize());
				if (part.getSize() > 0) {
					object.setImagen(inputStream);
				} else {
					object.setImagen(null);
				}

				if (ProductoDao.edit(object)) {
					acceso = list;
					request.setAttribute("listaProductos", ProductoDao.list());
					request.setAttribute("mensaje", "Éxito! Producto actualizado correctamente");
				} else {
					acceso = edit;
					request.setAttribute("listaCategorias", CategoriaDao.list());
					request.setAttribute("producto", object);
					request.setAttribute("mensaje", "Error! No se pudo actualizar el producto");
				}
				break;
			case "Buscar":
				int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
				acceso = resultado;
				request.setAttribute("listaProductos", ProductoDao.listByCategoria(categoria_id));
				request.setAttribute("categoria", CategoriaDao.search(categoria_id));
				break;
			default:
				acceso = list;
				request.setAttribute("listaProductos", ProductoDao.list());
				break;
			}
		} catch (Exception e) {
			acceso = list;
			request.setAttribute("listaProductos", ProductoDao.list());
		}
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

}

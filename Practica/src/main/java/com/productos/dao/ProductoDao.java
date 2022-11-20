package com.productos.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import com.productos.config.Conexion;
import com.productos.model.Producto;


public class ProductoDao {
	public static ArrayList<Producto> executeQueryWithResult(String query) {
		ArrayList<Producto> lista = new ArrayList<>();
		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(toObject(rs));
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error in executeQueryWithResult Producto" + e.getMessage());
		}
		return lista;
	}

	public static boolean executeQuery(String query) {
		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error in executeQuery: " + e.getMessage());
		}
		return false;
	}

	public static Producto toObject(ResultSet rs) {

		try {
			Producto objeto = new Producto();
			objeto.setId(rs.getInt(1));
			objeto.setCategoria(CategoriaDao.search(rs.getInt(2)));
			objeto.setNombre(rs.getString(3));
			objeto.setCantidad(rs.getInt(4));
			objeto.setPrecio(rs.getDouble(5));
			objeto.setImagen(rs.getBinaryStream(6));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Producto. " + e.getMessage());
		}

		return null;
	}
	
	public static ArrayList<Producto> list() {
		String query = "SELECT * FROM tb_producto" + " ORDER BY id_pr";
		return executeQueryWithResult(query);
	}

	public static ArrayList<Producto> listByCategoria(int categoria_id) {
		String query = "SELECT * FROM tb_producto WHERE id_cat = " + categoria_id + " ORDER BY id_pr";
		return executeQueryWithResult(query);
	}

	public static Producto search(int id) {
		String query = "SELECT * FROM tb_producto WHERE Id_pr = " + id;
		ArrayList<Producto> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public static boolean add(Producto objeto) {
		String query = "INSERT INTO tb_producto (" + "id_cat, nombre_pr, cantidad_pr, precio_pr, imagen_pr"
				+ ") VALUES (" + "" + objeto.getCategoria().getId() + "," + "'" + objeto.getNombre() + "'," + ""
				+ objeto.getCantidad() + "," + "" + objeto.getPrecio() + "," + "?)";

		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);
			ps.setBinaryStream(1, objeto.getImagen());
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error in executeQuery: " + e.getMessage());
		}

		return false;
	}

	public static boolean edit(Producto objeto) {
		String query = "UPDATE tb_producto SET " + "id_cat = " + objeto.getCategoria().getId() + "," + "nombre_pr = '"
				+ objeto.getNombre() + "'," + "cantidad_pr = " + objeto.getCantidad() + "," + "precio_pr = "
				+ objeto.getPrecio() + " ";

		if (objeto.getImagen() != null) {
			query += ", imagen_pr = ?";
		}

		query += " WHERE id_pr = " + objeto.getId();

		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);

			if (objeto.getImagen() != null) {
				ps.setBinaryStream(1, objeto.getImagen());
			}

			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error in executeQuery: " + e.getMessage());
		}

		return false;
	}

	public static boolean delete(int id) {
		String query = "DELETE FROM tb_producto WHERE Id_pr = " + id;
		return executeQuery(query);
	}

	public static void ListarImagen(int id, HttpServletResponse response) {
		Producto p = search(id);

		if (p != null) {
			OutputStream outputStream = null;
			BufferedInputStream bufferedInputStream = null;
			BufferedOutputStream bufferedOutputStream = null;
			response.setContentType("image/*");
			try {
				outputStream = response.getOutputStream();
				bufferedInputStream = new BufferedInputStream(p.getImagen());
				bufferedOutputStream = new BufferedOutputStream(outputStream);
				int i = 0;
				while ((i = bufferedInputStream.read()) != -1) {
					bufferedOutputStream.write(i);
				}

			} catch (IOException ex) {
			} finally {
				try {
					outputStream.close();
				} catch (IOException ex) {
				}
			}
		}
	}
}

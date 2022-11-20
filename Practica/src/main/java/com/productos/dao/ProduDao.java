package com.productos.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.productos.config.Conexion;
import com.productos.model.Producto;
import com.productos.model.Usuarios;

public class ProduDao {
	
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

	public static ArrayList<Producto> listP() {
		String query = "SELECT * FROM tb_producto";
		return executeQueryWithResult(query);
	}
	
	public static Producto searchP(int id) {
		String query = "SELECT * FROM tb_producto WHERE Id_pr = " + id;
		ArrayList<Producto> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}
}

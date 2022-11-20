package com.productos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.productos.config.Conexion;
import com.productos.model.Categoria;

public class CategoriaDao {
	public static ArrayList<Categoria> executeQueryWithResult(String query) {
		ArrayList<Categoria> lista = new ArrayList<>();
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
			System.out.println("Error in executeQueryWithResult Categoria" + e.getMessage());
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

	public static Categoria toObject(ResultSet rs) {

		try {
			Categoria objeto = new Categoria();
			objeto.setId(rs.getInt(1));
			objeto.setNombre(rs.getString(2));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Categoria. " + e.getMessage());
		}

		return null;
	}

	public static ArrayList<Categoria> list() {
		String query = "SELECT * FROM tb_categoria";
		return executeQueryWithResult(query);
	}

	public static Categoria search(int id) {
		String query = "SELECT * FROM tb_categoria WHERE Id_cat = " + id;
		ArrayList<Categoria> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	
	
	
	
}

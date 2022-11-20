package com.productos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

import org.apache.catalina.User;

import com.productos.config.Conexion;
import com.productos.model.Usuarios;

public class UsuariosDao {

	public static ArrayList<Usuarios> executeQueryWithResult(String query) {
		ArrayList<Usuarios> lista = new ArrayList<>();
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

	public static Usuarios toObject(ResultSet rs) {

		try {
			Usuarios objeto = new Usuarios();
			objeto.setId(rs.getInt(1));
			objeto.setNombre (rs.getString(2));
			objeto.setCedula (rs.getString(3));
			objeto.setPass (rs.getString(4));
			objeto.setEstado (rs.getString(5));
			objeto.setResidencia (rs.getString(6));
			objeto.setFechaNac (rs.getString(7));
			objeto.setColor (rs.getString(8));
			objeto.setEmail (rs.getString(9));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Categoria. " + e.getMessage());
		}

		return null;
	}

	public static ArrayList<Usuarios> listU() {
		String query = "SELECT * FROM tb_cliente";
		return executeQueryWithResult(query);
	}

	public static Usuarios searchU(int id) {
		String query = "SELECT * FROM tb_cliente WHERE Id_cl = " + id;
		ArrayList<Usuarios> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}
}

package com.productos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	static final String database = "db_producto";
	static final String user = "postgres";
	static final String password = "12345";

	public static Connection getConnection() {

		Connection conexion = null;
		try {

			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user, password);

		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error." + ex.getMessage());
		}
		return conexion;
	}
}

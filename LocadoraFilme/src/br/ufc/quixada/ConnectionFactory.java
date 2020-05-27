package br.ufc.quixada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/**
	 * @author Anderson Uchoa
	 */

	private static final String url = "jdbc:postgresql://localhost:5432/LOCADORAQUIXADA";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usuario, senha);
	}

}

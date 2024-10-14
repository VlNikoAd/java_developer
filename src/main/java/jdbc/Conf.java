package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conf {

	private final static String DB_URL = "jdbc:postgresql://localhost:5433/promo-module"; //docker
	private final static String DB_USERNAME = "promo-module";
	private final static String DB_PASSWORD = "promo-module";

	public static Connection getConnection() {
		Connection connectionDb = null;

		try {
			connectionDb = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("Connection OK!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection FAIL!");
		}

		return connectionDb;
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection connection = Conf.getConnection();

		System.out.println("connection.getCatalog() = " + connection.getCatalog());
	}
}

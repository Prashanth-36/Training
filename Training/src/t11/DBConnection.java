package t11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import myException.CustomException;

public class DBConnection {
	private static Connection con;

	private DBConnection() {
	}

	public static Connection getConnection() throws CustomException {
		if (con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task11", "root", "root");
			} catch (SQLException e) {
				throw new CustomException("Db connection failed.", e);
			}
		}
		return con;
	}

	public static void close() throws SQLException {
		con.close();
	}
}

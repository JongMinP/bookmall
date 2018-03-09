package com.cafe24.bookmall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactroy {

	private static ConnectionFactroy instnace;
	private final static String url = "jdbc:mysql://localhost/bookmall";

	private ConnectionFactroy() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactroy getInstance() {
		if (instnace == null)
			instnace = new ConnectionFactroy();

		return instnace;
	}

	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, "bookmall", "bookmall");
	}

}

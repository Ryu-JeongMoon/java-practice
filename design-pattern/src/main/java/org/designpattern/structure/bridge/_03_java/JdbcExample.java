package org.designpattern.structure.bridge._03_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.h2.Driver");

		try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {

			String sql = "CREATE TABLE  ACCOUNT " +
				"(id INTEGER not NULL, " +
				" email VARCHAR(255), " +
				" password VARCHAR(255), " +
				" PRIMARY KEY ( id ))";

			Statement statement = conn.createStatement();
			statement.execute(sql);

			//            PreparedStatement statement1 = conn.prepareStatement(sql);
			//            ResultSet resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

/*
Driver가 변경되면 DB 종속적인 SQL은 변경될 필요가 있더라도 추상화해 둔 JDBC 코드는 변경되지 않는다
이 쪽 코드를 변경하지 않고도 세부 Driver를 바꿔버릴 수 있게 인터페이스를 통해 분리하자!?
 */

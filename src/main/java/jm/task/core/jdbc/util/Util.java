package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() throws SQLException {
        try {
//            DriverManager.registerDriver(new Driver());
            String DB_TYPE = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&serverTimezone=Europe/Moscow&useSSL=false";
            String login = "max";
            String password = "serov";
            return DriverManager.getConnection(DB_TYPE, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}

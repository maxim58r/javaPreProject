package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_NAME = "my_db";

    public static Connection getConnection() throws SQLException {
        try {
            String DB_TYPE = String.format ("jdbc:mysql://localhost:3306/%s" +
                    "?useUnicode=true&serverTimezone=Europe/Moscow&useSSL=false", DB_NAME);
            String login = "max";
            String password = "serov";
            return DriverManager.getConnection(DB_TYPE, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}

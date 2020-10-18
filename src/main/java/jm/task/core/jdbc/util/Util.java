package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            String DB_TYPE = "jdbc:mysql://localhost:3306/users_db?serverTimezone=Europe/Moscow";
            String login = "max";
            String password = "serov";
            String ssl = "useSSL=false";

            return DriverManager.getConnection(DB_TYPE, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

package jm.task.core.jdbc.util;

//import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
  public static  Connection connection;

    static Connection getConnection() {

        try {
//            DriverManager.registerDriver(new Driver());
            String DB_TYPE = "jdbc:mysql://localhost:3306/users_db?serverTimezone=Europe/Moscow";
            String login = "max";
            String password = "serov";
            String ssl = "useSSL=false";
            connection = DriverManager.getConnection(DB_TYPE, login, password);
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }
}

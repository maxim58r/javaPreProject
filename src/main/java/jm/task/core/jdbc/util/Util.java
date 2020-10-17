package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public Util() throws SQLException {


    }

    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            String DB_TYPE = "jdbc:mysql://localhost:3306/users_db?";
            String login = "max&";
            String password = "serov";

            return DriverManager.getConnection(DB_TYPE,login,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

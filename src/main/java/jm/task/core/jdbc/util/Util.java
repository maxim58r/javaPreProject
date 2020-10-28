package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DB_NAME = "my_db";
    private static final String USERNAME = "max";
    private static final String PASSWORD = "serov";
    private static final String HBM2DDL = "create-drop";
//    private static final String HBM2DDL = "update";
//    private static final String HBM2DDL = "drop";
//    private static final String HBM2DDL = "validate ";
//    private static final String HBM2DDL = "none ";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            String DB_TYPE = String.format("jdbc:mysql://localhost:3306/%s" +
                    "?useUnicode=true&serverTimezone=Europe/Moscow&useSSL=false", DB_NAME);
            connection = DriverManager.getConnection(DB_TYPE, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();

            properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/my_db?serverTimezone=Europe/Moscow");
            properties.setProperty("hibernate.connection.username", USERNAME);
            properties.setProperty("hibernate.connection.password", PASSWORD);
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.hbm2ddl.auto", HBM2DDL);
//            properties.setProperty("hibernate.connection.show_sql", "true");
//            properties.setProperty("hibernate.connection.pool_size", "2");
//            properties.setProperty("hibernate.connection.autocommit", "false");
//            properties.setProperty("hibernate.cache.use_query_cache", "false");
//            properties.setProperty("hibernate.current_session_context_class", "thread");

            try {
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
                if (!sessionFactory.isClosed()) {
                    System.out.println("Connection ok!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

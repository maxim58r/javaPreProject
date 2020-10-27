package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.setProperty("hibernate.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.url", "jdbc:mysql://localhost:3306/my_db?useUnicode=true&amp;serverTimezone=Europe/Moscow&amp;useSSL=false");
        properties.setProperty("hibernate.username", "max");
        properties.setProperty("hibernate.password", "serov");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        try {
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
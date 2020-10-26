package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateUtil {
    /* private static SessionFactory sessionFactory = null;

     static {
         try {
             Configuration configuration = new Configuration().;
             sessionFactory = configuration.buildSessionFactory();
         } catch (Throwable e) {
             System.out.println("ex");
             e.printStackTrace();
         }
     }

     public static SessionFactory getSessionFactory() {
         return sessionFactory;
     }*/
    private static SessionFactory sessionFactory = null;

    static {
//        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Configuration configuration = new Configuration();
        Properties dbSettings = new Properties();
        dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/my_db");
        dbSettings.put(Environment.CONNECTION_PREFIX, "useUnicode=true&amp;serverTimezone=Europe/Moscow&amp;useSSL=false");
        dbSettings.put(Environment.USER, "max");
        dbSettings.put(Environment.PASS, "serov");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//        dbSettings.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
//        dbSettings.setProperty("connection.url", "jdbc:mysql://localhost:3306/my_db?useUnicode=true&amp;serverTimezone=Europe/Moscow&amp;useSSL=false");
//        dbSettings.setProperty("connection.username", "max");
//        dbSettings.setProperty("connection.password", "serov");
//        dbSettings.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        dbSettings.setProperty("show_sql", "true");
//        dbSettings.setProperty("hbm2ddl.auto", "create-drop");
//        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//        // Apply database settings
//        registryBuilder.applySettings(dbSettings);
//        // Creating registry
//        standardServiceRegistry = registryBuilder.build();
//        // Creating MetadataSources
//        MetadataSources sources = new MetadataSources(standardServiceRegistry);
//        // Creating Metadata
//        Metadata metadata = sources.getMetadataBuilder().build();
//        // Creating SessionFactory
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
        try {
            configuration.setProperties(dbSettings);
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(registry.build());
//            configuration.addAnnotatedClass(User.class);
//            sessionFactory = configuration.addProperties(dbSettings).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("yu");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
       /* UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
        daoJDBC.dropUsersTable();
        daoJDBC.createUsersTable();
        daoJDBC.saveUser("Max", "Suhov", Byte.parseByte("38"));
        daoJDBC.saveUser("Serge", "Kohn", Byte.parseByte("26"));
        daoJDBC.saveUser("Vladislav", "Dud", Byte.parseByte("4"));
        daoJDBC.saveUser("Semen", "Robinovich", Byte.parseByte("111"));
        daoJDBC.getAllUsers()
                .stream()
                .map(User::toString)
                .forEach(System.out::println);
        daoJDBC.cleanUsersTable();
        daoJDBC.dropUsersTable();*/

//        SessionFactory factory = HibernateUtil.getSessionFactory();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
//        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.saveUser("Max", "Suhov", Byte.parseByte("38"));
        userDaoHibernate.saveUser("Serge", "Kohn", Byte.parseByte("26"));
        userDaoHibernate.saveUser("Vladislav", "Dud", Byte.parseByte("4"));
        userDaoHibernate.saveUser("Semen", "Robinovich", Byte.parseByte("111"));
//        userDaoHibernate.cleanUsersTable();
//        userDaoHibernate.dropUsersTable();
        userDaoHibernate.getAllUsers()
                .forEach(System.out::println);
        System.out.println();
        userDaoHibernate.removeUserById(2);
        System.out.println();
        userDaoHibernate.getAllUsers()
                .forEach(System.out::println);
    }
}

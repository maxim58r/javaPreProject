package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
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
        daoJDBC.dropUsersTable();
    }
}

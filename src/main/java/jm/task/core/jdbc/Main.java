package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
        daoJDBC.dropUsersTable();
        daoJDBC.createUsersTable();
//        daoJDBC.dropUsersTable();
//        daoJDBC.createUsersTable();
        daoJDBC.saveUser("max", "serov", Byte.parseByte("38"));
        daoJDBC.saveUser("maria", "serova", Byte.parseByte("26"));
        daoJDBC.saveUser("vladislav", "krivonos", Byte.parseByte("15"));
//        daoJDBC.removeUserById(4);
//        daoJDBC.getAllUsers()
//                .stream()
////                .map(User::getId)
////                .map(User::getName)
//                .map(User::getLastName)
////                .map(User::getAge)
//                .forEach(System.out::println);
        User user = daoJDBC.getAllUsers().get(0);
        System.out.println(user.getName());
    }
}

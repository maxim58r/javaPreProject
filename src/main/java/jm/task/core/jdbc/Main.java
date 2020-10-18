package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.DbConnection;

public class Main {
    public static void main(String[] args) throws Exception {
       try (DbConnection dbConnection = new DbConnection()){
           System.out.println(dbConnection.getMetaData());
       }
        UserServiceImpl service = new UserServiceImpl();
       service.createUsersTable();
    }
}

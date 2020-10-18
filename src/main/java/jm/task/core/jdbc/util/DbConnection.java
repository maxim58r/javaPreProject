package jm.task.core.jdbc.util;

import java.sql.Connection;

public class DbConnection implements AutoCloseable {
    private final Connection connection;

    public DbConnection() {
        connection = Util.getConnection();
    }

    public String getMetaData() {
        try {
            return "Connected to: " + connection.getMetaData().getURL() + "\n"
                    + "DB version: " + connection.getMetaData().getDatabaseProductVersion() + "\n"
                    + "DB name: " + connection.getMetaData().getDatabaseProductName() + "\n"
                    + "Driver: " + connection.getMetaData().getDriverName();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void close() throws Exception {

    }
}

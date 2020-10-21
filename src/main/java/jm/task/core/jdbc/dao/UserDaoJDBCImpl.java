package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    String table = "my_users";
    final String CREATE_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s (\n" +
            "  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NOT NULL,\n" +
            "  `lastName` VARCHAR(45) NOT NULL,\n" +
            "  `age` TINYINT(3) NOT NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8;", table);
    final String DROP_TABLE = String.format("DROP TABLE %s;", table);
    final String SAVE_USER = String.format("INSERT INTO %s (name, lastName, age) VALUES ((?), (?), (?));", table);
    final String DELETE_USER = String.format("DELETE FROM %s WHERE id = (?);", table);
    final String GET_USER = String.format("SELECT u.id, u.name, u.lastName, u.age FROM %s AS u ;", table);

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (PreparedStatement statement = Util.getConnection().prepareStatement(CREATE_TABLE)) {
            statement.execute();
            System.out.println("Create ok");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (PreparedStatement statement = Util.getConnection().prepareStatement(DROP_TABLE)) {
            statement.execute();
            System.out.println("Drop ok");
        } catch (SQLException sqle) {
//            sqle.printStackTrace();
            System.out.println("Table dont delete!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement statement = Util.getConnection().prepareStatement(SAVE_USER)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, String.valueOf(age));
            statement.executeUpdate();
            System.out.println("Save user ok: " + name);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement statement = Util.getConnection().prepareStatement(DELETE_USER)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Delete user id: " + id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = Util.getConnection().prepareStatement(GET_USER)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId(set.getLong("id"));
                user.setName(set.getString("name"));
                user.setLastName(set.getString("id"));
                user.setAge(set.getByte("id"));
                users.add(user);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {

    }
}

package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.getConnection();
    }


    public void createUsersTable() {

        try (Statement statement = connection.createStatement()) {
            statement.execute("Create table IF NOT EXISTS Users( id INT AUTO_INCREMENT  Primary key , name varchar (255), lastName varchar(255), age Integer);");
            Util.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF  EXISTS Users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO users(users.name,users.lastName,users.age) " +
                    "VALUES(" + "'" + name + "'" + "," + "'" + lastName + "'" + "," + "'" + age + "'" + ");");
            System.out.println("User с именем - " + name + " добавлен в базу");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM Users WHERE id=" + "'" + id + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users;");
            while (resultSet.next()) {
                userList.add(new User(resultSet.getString("name"), resultSet.getString("lastName")
                        , resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM Users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

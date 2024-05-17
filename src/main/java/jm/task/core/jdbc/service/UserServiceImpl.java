package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDaoJDBCImpl dao = new UserDaoJDBCImpl();



    public void createUsersTable() {
        dao.createUsersTable();
    }

    public UserDaoJDBCImpl getDao() {
        return dao;
    }

    public void dropUsersTable() {
        dao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() {
dao.cleanUsersTable();
    }
}

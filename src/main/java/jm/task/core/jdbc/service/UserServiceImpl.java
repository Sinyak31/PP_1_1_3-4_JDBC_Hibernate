package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDao dao = new UserDaoJDBCImpl();
    private UserDao daoHibernate = new UserDaoHibernateImpl();


    public void createUsersTable() {
//        dao.createUsersTable();
        daoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
//        dao.dropUsersTable();
        daoHibernate.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
//        dao.saveUser(name, lastName, age);
        daoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем - " + name + " добавлен в БД");
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return dao.getAllUsers();
        return daoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
//        dao.cleanUsersTable();
        daoHibernate.cleanUsersTable();
    }

}

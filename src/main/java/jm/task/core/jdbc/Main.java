package jm.task.core.jdbc;



import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван","Иванов", (byte) 35);
        userService.saveUser("Артем","Петров", (byte) 20);
        userService.saveUser("Александр","Пушкин", (byte) 50);
        userService.saveUser("Михаил","Лермонтов", (byte) 72);

        List<User> userList = userService.getAllUsers();
        System.out.println(userList);

        userService.removeUserById(1L);

        userService.cleanUsersTable();

        userService.dropUsersTable();



    }
}

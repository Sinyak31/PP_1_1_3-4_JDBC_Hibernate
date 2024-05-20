package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:MySql://localhost:3306/my";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "234065";
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("no such db");
            throw new RuntimeException(e);
        }
        return connection;
    }



    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties set = new Properties();
            set.put(Environment.DRIVER,DB_DRIVER);
            set.put(Environment.URL,DB_URL);
            set.put(Environment.USER,DB_NAME);
            set.put(Environment.PASS,DB_PASSWORD);
            set.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            set.put(Environment.SHOW_SQL,true);
            set.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

            configuration.setProperties(set);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
        return sessionFactory;
        }
    }


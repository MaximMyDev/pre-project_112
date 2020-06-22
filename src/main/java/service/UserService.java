package service;

import model.User;
import org.hibernate.SessionFactory;
import util.connectDB;
import dao.UserHibernateDAO;

import java.util.List;

public class UserService {
    private static UserService userService;

    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(connectDB.getSessionFactory());
        }
        return userService;
    }

    public void serviceNewUser(User user) {
        new UserHibernateDAO(sessionFactory.openSession()).insertUser(user);
    }
    public void serviceDeleteUser(int id) {
        new UserHibernateDAO(sessionFactory.openSession()).deleteUser(id);
    }
    public User serviceSelectUser(int id) {
        return new UserHibernateDAO(sessionFactory.openSession()).selectUser(id);
    }
    public List<User> serviceSelectAllUser(){
        return new UserHibernateDAO(sessionFactory.openSession()).selectAllUsers();
    }
    public void serviceUpdateUser(User user) {
        new UserHibernateDAO(sessionFactory.openSession()).updateUser(user);
    }
}

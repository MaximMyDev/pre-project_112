package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public void insertUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        System.out.println("user id = "+user.getName()+" is added");
        transaction.commit();
    }

    @Override
    public User selectUser(int id) {
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        System.out.println("user id = "+user.getName()+" is selected");
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> selectAllUsers() {
        List<User> allUser = new LinkedList<>();
        Transaction transaction = session.beginTransaction();
        allUser = session.createQuery("from User").list();//.getResultList();
        return allUser;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean result = false;
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
            System.out.println("user id = "+id+" is deleted");
            result = true;
        }

        transaction.commit();

        return result;
    }

    @Override
    public boolean updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        System.out.println("user id = "+user.getName()+" is update");
        transaction.commit();
        return true;
    }

}

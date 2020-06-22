package dao;

import model.User;
import java.util.List;

public interface UserDAO {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

}

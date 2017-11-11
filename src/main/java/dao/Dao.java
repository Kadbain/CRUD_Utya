package dao;

import model.User;

import java.util.List;

/**
 * Created by Ps1X on 27.06.2017.
 */
public interface Dao {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
}

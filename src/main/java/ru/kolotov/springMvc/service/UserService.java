package ru.kolotov.springMvc.service;

import org.springframework.stereotype.Service;
import ru.kolotov.springMvc.Dao.UserDao;
import ru.kolotov.springMvc.models.User;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.index();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userDao.update(id, user);
    }
}

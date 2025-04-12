package ru.kolotov.springMvc.Dao;

import ru.kolotov.springMvc.models.User;
import java.util.List;

public interface UserDaoInterface {
    List<User> index();
    User getUserById(int id);
    void save(User user);
    void update(int id, User updateUser);
    void deleteById(int id);
}

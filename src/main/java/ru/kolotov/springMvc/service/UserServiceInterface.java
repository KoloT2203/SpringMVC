package ru.kolotov.springMvc.service;

import ru.kolotov.springMvc.models.User;

import java.util.List;

public interface UserServiceInterface {
    void createUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    void deleteUserById(int id);
    void updateUser(int id, User user);
}

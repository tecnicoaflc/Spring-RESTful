package com.javaproject.project.dao;

import com.javaproject.project.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User getUser(String id);

    void deleteUser(Long id);

    void registerUser(User user);

    User checkUserPassword(User user);
}

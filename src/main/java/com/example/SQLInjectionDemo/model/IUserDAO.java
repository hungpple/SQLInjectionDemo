package com.example.SQLInjectionDemo.model;

import java.util.List;

public interface IUserDAO {
    public User getUser(String name, String password);
    
    public User checkUserById(String name);

    public int addUser(User user);
}


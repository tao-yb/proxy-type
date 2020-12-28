package com.tyb.jdk.service;

import com.tyb.User;

public class UserServiceImpl implements UserService {
    public void addUser(User user) {
        System.out.println("user is :" + user);
    }
}

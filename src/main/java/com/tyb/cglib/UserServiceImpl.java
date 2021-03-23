package com.tyb.cglib;

import com.tyb.User;

public class UserServiceImpl {
    public void addUser(User user){
        System.out.println("com.tyb.cglib.UserServiceImpl add user work  .. " + user);
    }

    public void work(User user){
        System.out.println("user start work  .. " + user);
    }
}

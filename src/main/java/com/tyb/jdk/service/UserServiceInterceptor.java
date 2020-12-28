package com.tyb.jdk.service;

import com.tyb.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceInterceptor implements InvocationHandler {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public UserServiceInterceptor(Object obj) {
        super();
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args !=null && args.length >0 && args[0] instanceof User){
            User user = (User)args[0];
            if (user.getUserName().length() ==0){
                throw new IllegalArgumentException("user  name length is 0");
            }

        }
        System.out.println("com.tyb.jdk.service.UserServiceInterceptor.invoke over...");
        return method.invoke(obj,args);
    }
}

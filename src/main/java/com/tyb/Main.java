package com.tyb;

import com.tyb.cglib.UserServiceImpl;
import com.tyb.cglib.UserServiceInterceptor;
import net.sf.cglib.proxy.Enhancer;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Proxy;

public class Main {

 /*   public static void main(String[] args) {
        User user = new User();
        user.setAddress("wuhan");
        user.setAge(20);
        user.setUserName("12");
        UserService userService = new UserServiceImpl();
        UserServiceInterceptor userServiceInterceptor = new UserServiceInterceptor(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),new UserServiceInterceptor(userService));
        proxy.addUser(user);
        System.out.println(proxy.hashCode());
    }*/

    public static void main(String[] args) {
        User user = new User();
        user.setAddress("wuhan");
        user.setAge(20);
        user.setUserName("12");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceInterceptor());
        UserServiceImpl userService = (UserServiceImpl)enhancer.create();
        userService.addUser(user);
    }
}

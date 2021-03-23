package com.tyb;

import com.tyb.cglib.MyCallbackFilter;
import com.tyb.cglib.UserServiceImpl;
import com.tyb.cglib.UserServiceInterceptor;
import net.sf.cglib.core.DefaultNamingPolicy;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

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
        enhancer.setCallbackFilter(new MyCallbackFilter());
        enhancer.setNamingPolicy(DefaultNamingPolicy.INSTANCE);
        Class [] classes = new Class[]{UserServiceInterceptor.class};
        Callback [] callbacks = new Callback[classes.length + 1];
        for (int i = 0; i < classes.length; i++) {
            callbacks[i] = new UserServiceInterceptor();
        }
        callbacks[1] = NoOp.INSTANCE;
        enhancer.setCallbacks(callbacks);
        UserServiceImpl userService = (UserServiceImpl)enhancer.create();
        userService.addUser(user);
        System.out.println("---------------------分割---------------------");
        userService.work(user);
    }
}

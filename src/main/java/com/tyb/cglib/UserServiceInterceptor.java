package com.tyb.cglib;

import com.tyb.User;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (objects !=null && objects.length >0 && objects[0] instanceof User){
            User user = (User)objects[0];
            if (user.getUserName().length() ==0){
                throw new IllegalArgumentException("user  name length is 0");
            }
        }
        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("method name >> " + method.getName());

        System.out.println("com.tyb.cglib.UserInterceptor work over");
        return result;
    }
}

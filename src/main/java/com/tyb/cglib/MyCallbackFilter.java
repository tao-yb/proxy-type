package com.tyb.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;
import java.util.Objects;

public class MyCallbackFilter implements CallbackFilter {

    public static final int INTERCEPTOR = 0;

    public static final int NOOPT = 1;

    public static final String INTERCEPTOR_METHOD_NAME = "addUser";

    public int accept(Method method) {
        if (Objects.equals(method.getName(),INTERCEPTOR_METHOD_NAME)){
            return INTERCEPTOR;
        }
        return NOOPT;
    }
}

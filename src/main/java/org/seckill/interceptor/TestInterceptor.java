package org.seckill.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * User: xujiangjun
 * Date: 16/8/31 18:08
 */
public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Test Interceptor...");
        return methodInvocation.proceed();
    }
}

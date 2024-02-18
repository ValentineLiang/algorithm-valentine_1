package opel_demo.reflect_proxy;

import opel_demo.IAccount;
import opel_demo.SecurityChecker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityProxyInvocationHandler implements InvocationHandler {
    private Object proxyedObject;

    public SecurityProxyInvocationHandler(Object o) {
        proxyedObject = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (proxy instanceof IAccount && "operation".equals(method.getName())) {
            SecurityChecker.checkSecurity();
        }
        return method.invoke(proxyedObject, args);
    }
}
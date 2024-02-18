package opel_demo.reflect_proxy;

import opel_demo.AccountImpl;
import opel_demo.IAccount;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception {
        // 2.使用代理
        IAccount account = (IAccount) Proxy.newProxyInstance(
                IAccount.class.getClassLoader(),
                new Class[]{IAccount.class},
                new SecurityProxyInvocationHandler(new AccountImpl()));
        account.operation();
    }
}
package opel_demo;

public class Test {
    public static void main(String[] args) throws Exception {
        // 1.使用包装类
        AccountWithSecurityCheck account = new AccountWithSecurityCheck(new AccountImpl());
        account.operation();
    }
}